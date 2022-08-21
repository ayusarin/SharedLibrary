def call(String branch,String Url) {

    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                     sh 'echo checkout'
                    git branch: "${branch}", url: "${Url}"
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
