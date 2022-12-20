pipeline {
    agent any

    stages {
        stage('pull code from Git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '81fba204-1854-4612-8bbb-3dcc29845e02', url: 'git@github.com:hcb-test/demo-test.git']]])
            }
        }
        stage('wait for input') {
            steps {
                input 'Approve'
            }
        }
        stage('maven build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
