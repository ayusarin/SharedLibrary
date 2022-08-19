def call(Map pipelineParams) {

    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                    git branch: pipelineParams.branch, credentialsId: 'GitCredentials', url: pipelineParams.scmUrl
                }
            }

            stage('build') {
                steps {
                    sh 'Build'
                }
            }

            stage ('test') {
                steps {
                        sh 'test'
                }
            }

            stage('deploy developmentServer'){
                steps {
                    sh 'test'
                }
            }

            stage('deploy staging'){
                steps {
                   sh 'test'
                }
            }

            stage('deploy production'){
                steps {
                    sh 'deploy'
                }
            }
        }
        post {
            failure {
                sh "${env.BUILD_URL}"
            }
        }
    }
}
