pipeline {
    agent any

    triggers{
        gitHubPush()
    }

    environment {
        REMOTE_ADDRESS = "190.168.0.1"
    }

    stages {
        stage ('Test & Build Artifact') {
            agent {
                docker {
                    image 'openjdk:17'
                    args '-v "$PWD":/app'
                    reuseNode true
                }
            }
            steps {
                sh './gradlew clean build'
            }
        }
        stage ('Build & Push docker image') {
            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                    sh 'docker push giovanni/dsvcrud'
                }
            }
        }
        stage ('Deploy image to remote server') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'instance-1', keyFileVariable: 'KEY_FILE', usernameVariable: 'USER')]) {
                    sh 'ssh -i ${KEY_FILE} ${USER}@${REMOTE_ADDRESS} "docker run -d giovanni/dsvcrud"'
                }
            }
        }
    }
}