#!groovy

pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
          image 'maven:3.5.0'
        }
      }
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Docker Build') {
      agent any
      steps {
        app = docker.build("devops-gcr/sb_crud")
      }
    }
    stage('Docker Push') {
  agent any
        steps {
          withDockerRegistry(credentialsId: 'gcr:devops-gcr') {
            sh 'docker push gcr.io/devops-gcr/sb-crud:latest'
          }
        }
      }
    }
  }
