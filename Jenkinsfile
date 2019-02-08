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
        sh 'docker build -t gcr.io/devops-gcr/sb_crud:build-$BUILD_NUMBER .'
      }
    }
    stage('Docker Push') {
  agent any
        steps {
            sh 'docker push gcr.io/devops-gcr/sb_crud:build-$BUILD_NUMBER'
        }
      }
    }
  }
