def call(Map pipelineParams) {

    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                    sh 'echo checkout'
                   // git branch: pipelineParams.branch, credentialsId: 'GitCredentials', url: pipelineParams.scmUrl
                }
            }

            stage('build') {
                steps {
                    sh 'echo Build'
                }
            }

            stage ('test') {
                steps {
                        sh 'echo test'
                }
            }

            stage('deploy developmentServer'){
                steps {
                    sh 'echo deploy'
                }
            }

            stage('deploy staging'){
                steps {
                   sh 'echo staging'
                }
            }

            stage('deploy production'){
                steps {
                    sh 'echo deploy'
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
