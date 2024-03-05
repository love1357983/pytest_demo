pipeline {
    agent {
        label 'master'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/love1357983/pytest_demo.git'
            }
        }

        stage('Initialize Virtual Environment') {
            steps {
                sh '''python3 -m venv venv
                . ./venv/bin/activate
                pip3 install -r requirements.txt
                '''
            }
        }

        stage('Run Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh '''. ./venv/bin/activate
                    pytest --alluredir=allure-results
                    '''
                }
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']]
                ])
            }
        }

        stage('Send Email') {
            steps {
                emailext (
                    subject: 'Test Results',
                    body: '''<p>Test results are available in the Allure report.</p>
                                <p>Please check the following link: <a href="${BUILD_URL}allure">Allure Report</a></p>''',
                    to: 'example@example.com',
                    attachLog: true,
                    mimeType: 'text/html'
                )
            }
        }
    }
}
