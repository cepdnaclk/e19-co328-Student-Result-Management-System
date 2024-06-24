# Deployment Plan

- Infrastructure is to be maintained cloud platform indipendant (To ensure easy migration and reduce time to redploy )
- Initial plan is to go with AWS, while GCP and local kubernetees as secondry plans 

1. Setup Cloud CLI (AWS configure, gcloud init)
   <details>
      <summary>AWS Configure</summary>
        ```
      
        # install aws cli
        sudo apt-get update
        sudo apt-get install awscli -y
        aws configure
        # verify
        aws sts get-caller-identity
           
        ```
   </details>

   <details>
   <summary>gcloud init</summary>
        ```
      
           # install gcp sdk
           sudo apt-get update
           sudo apt-get install apt-transport-https ca-certificates gnupg -y
           echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
           sudo apt-get install google-cloud-sdk -y 
           gcloud init
           # verify
           gcloud info

       ```
   </details>

2. Clone the repo and Go to devops branch and CD into /devops/automate-aws or /devops/automate-gcp on your choice of cloud platform.
    - Set your VPC/Network/Subnetwork/Project info in main.tf
    - Copy and Paste the .pem file of your ssh pvt key in this directory

3. Configure Ansible Plyabooks
    - Create Ansible Playbooks for software packages and initial automate scripts
    - Update main.tf with these ansible playbooks' names (if planning to run with the terreaform script)
  
4. Execute Terraform 
   <details>
     <summary>Install Terraform</summary>

        ```
   
        sudo apt-get update
        sudo apt-get install -y gnupg software-properties-common curl
        curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
        sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
        sudo apt-get update
        sudo apt-get install terraform
      
        # verify
        terraform -version
   
       ```
   </details>
    
    <details>
       <summary>Execute Terraform</summary>
      ```
      
            terraform init # only first time
            terraform apply
      
              ```
    </details>
    
5. Execute Additional Ansible Playbooks (or if previous play with main.tf failed)
     - TODO: create a playbook for docker/docker-compose  
```
  ansible-playbook -i ${IP_ADDRESS}, --private-key ${PVT_KEY_PATH} ${PLAYBOOK_NAME}.yaml
```

6. Set up jenkins CI/CD Server
    - With the above scripts now Java, Jenkins, Maven should be installed
    - From a browser log into http://IP_ADDRESS:8080 (change port to 8081 if needed)
    - Install Plugins from UI
        - Docker Pipeline
        - Pipeline Stages
        - Git Client
        - Git
        - Pipline (and check if any other plugin is required)   

7. Set up a new Pipeline job in jenkins
    - Copy and Paste the groovy scriot from /devops/jenkins-pipelines
    - Setup CRON job to POLL SCM (for every minute)
    - Build Now (Now the pipeline should be up and running with all the services deployed) 
 
# Testing Pipeline

1. Main QA pipeline is already integrated into the springboot's defult build steps (but currently running with skipping these: -DskipTests)
2. Postman API collections tesing Pipeline (TODO)

# POST Deployment Plan
(This is easier with Cloud UI, but can perform with terraform too)
1. Configure Load Balancing
2. Testing it with Autoscaling Groups 
