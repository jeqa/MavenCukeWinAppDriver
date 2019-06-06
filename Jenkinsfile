pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        warnError(message: 'Tests have failed') {
          bat 'mvn test -Dbrowser=firefox'
        }

        warnError(message: 'Chrome Tests have Failed') {
          bat 'mvn test -Dbrowser=chrome'
        }

      }
    }
    stage('Report') {
      steps {
        cucumber '**/*.json'
      }
    }
  }
}