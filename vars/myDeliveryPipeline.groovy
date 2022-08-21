def call(Map pipelineParams) {

    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                     sh 'echo checkout'
                    git branch: pipelineParams.branch, url: pipelineParams.Url
                }
            }

            stage('build') {
                steps {
                    sh 'cat test.txt'
                }
            }
        }
    }
}
