projectname='google-selenium'

pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/hdsgrewal/google-selenium.git'
            }
        }
        stage('test') {
              steps {
                   sh "mvn clean test -Dcucumber.options="src/resources"
              }
        }
    }
}
