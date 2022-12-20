pipeline {
    agent any

    stages {
        stage('拉取Git代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '523902f1-d6d0-4d37-ac03-7cfe3f507165', url: 'https://github.com/hcb-test/demo-test.git']]])
            }
        }
        stage('maven构建') {
            steps {
            }
        }
        stage('构建Docker镜像') {
            steps {
            }
        }
        stage('通过Publish Over SSH通知目标服务器') {
            steps {
            }
        }
    }
}
