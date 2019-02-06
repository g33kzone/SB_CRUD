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
        docker.withRegistry('https://gcr.io', 'gcr:[devops-gcr]') {
      app.push("${env.BUILD_NUMBER}")
      app.push("latest")
         }
        }
      }
    }
  }
}
