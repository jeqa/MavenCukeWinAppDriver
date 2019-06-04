pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }
    stage('Report') {
      steps {
        cucumber '**/*.json'
      }
    }
  }
}