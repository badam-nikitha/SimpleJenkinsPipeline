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
                bat 'gcc multithreading-example1.c -lpthread'

            }
        }
        stage('Test') {
            steps {
                bat './a.out'
            }
        }
        stage('Deploy') {
            steps {
                bat 'echo Done!'
            }
        }
    }
}
