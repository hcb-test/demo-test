pipeline {
    agent any

    stages {
        stage('pull code from Git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '81fba204-1854-4612-8bbb-3dcc29845e02', url: 'git@github.com:hcb-test/demo-test.git']]])
            }
        }
        stage('wait for approve') {
            steps {
                input 'Approve'
            }
        }
        stage('maven build') {
            steps {
                bat 'D:\\apache-maven-3.3.9\\bin\\mvn clean package'
            }
        }
        stage('send build artifacts over SSH') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'test deploy server', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd /usr/local/jenkins_deploy_test/docker/
                mv ../target/*jar ./
                chmod 777 *.jar''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'target/*.jar docker/*')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
        stage('build and start docker image over SSH') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'test deploy server', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''docker-compose down
                docker-compose up -d --build
                docker image prune -f''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
