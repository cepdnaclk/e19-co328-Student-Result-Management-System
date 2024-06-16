locals {
	vpc_id="vpc-0d7a3ce49e3ed1cbb" 
	subnet_id="subnet-0ab67c30966607de7"
	ssh_user="ubuntu" 
	key_name="devops"
	pvt_k_path="/home/kalindu/Athal/AWS_athal/automate-1/devops.pem"
}

provider "aws"{
	region="ap-northeast-1"
}

resource "aws_security_group" "tomcat" {
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

resource "aws_instance" "tomcat" {
  ami                         = "ami-0595d6e81396a9efb"
  subnet_id                   = local.subnet_id
  instance_type               = "t2.micro"
  associate_public_ip_address = true
  security_groups             = [aws_security_group.tomcat.id]
  key_name                    = local.key_name

  provisioner "remote-exec" {
    inline = ["echo 'Wait until SSH is ready'"]

    connection {
      type        = "ssh"
      user        = local.ssh_user
      private_key = file(local.pvt_k_path)
      host        = aws_instance.tomcat.public_ip
    }
  }

  provisioner "local-exec" {
    command = "ansible-playbook -i ${aws_instance.tomcat.public_ip}, --private-key ${local.pvt_k_path} tomcat-playbook.yaml"
  }
}


output "tomcat_ip" {
  value = aws_instance.tomcat.public_ip
}
