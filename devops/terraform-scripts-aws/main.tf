// provisioning in AWS

locals {
	vpc_id=""  // create VPC and puth the id
	subnet_id="" // choose a subnet from above vpc
	ssh_user="" // username 
	key_name="" // private key 
	pvt_k_path="" // path to .pem file
}

provider "aws"{
	region="ap-northeast-1"
}

resource "aws_security_group" "academetrics" {
  name   = "web_access"
  vpc_id = local.vpc_id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "academetrics" {
  ami                         = "ami-0595d6e81396a9efb"
  subnet_id                   = local.subnet_id
  instance_type               = "t2.micro"
  associate_public_ip_address = true
  security_groups             = [aws_security_group.academetrics.id]
  key_name                    = local.key_name

  provisioner "remote-exec" {
    inline = ["echo 'Wait until SSH is ready'"]

    connection {
      type        = "ssh"
      user        = local.ssh_user
      private_key = file(local.pvt_k_path)
      host        = aws_instance.academetrics.public_ip
    }
  }

  provisioner "local-exec" {
    command = "ansible-playbook -i ${aws_instance.academetrics.public_ip}, --private-key ${local.pvt_k_path} java-maven-jenkins-playbook.yaml"
  }
}


output "academetrics_ip" {
  value = aws_instance.academetrics.public_ip
}
