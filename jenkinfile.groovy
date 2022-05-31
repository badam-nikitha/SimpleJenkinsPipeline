pipeline {
    agent any
    stages {

        stage('Checkout Codebase') {
            steps {
            checkout scm: [$class: 'Git SCM', userRemoteConfigs: [[credentialsId: 'ssh-key',url: 'git@github.com:badam-nikitha/multithreading-example1.git']]]

            }
        }
        stage('Build') {
            steps {
                sh 'gcc multithreading-example1.c -lpthread'

            }
        }
        stage('Test') {
            steps {
                sh './a.out'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo Done!'
            }
        }
    }
}