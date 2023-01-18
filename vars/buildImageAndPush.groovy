#!/usr/bin/env groovy

def call()
{
withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) 
    {
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin ${params.REPO_NAME}"
    }
    

    if (params.REPO_NAME== "")
    {
        sh "docker build -t abdolee/demo-app:${env.VER} ."
        sh "docker push abdolee/demo-app:${env.VER}"    
    }
    else
    {
        sh "docker build -t ${params.REPO_NAME}/demo-app:${params.paramevterName} ."
        sh "docker push ${params.REPO_NAME}/demo-app:${params.paramevterName}"
    }

}