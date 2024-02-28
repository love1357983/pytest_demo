pipeline {
    agent {
        label 'macos'
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
                source ./venv/bin/activate
                pip3 install -r requirements.txt
                '''
            }
        }

        stage('Run Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh '''source ./venv/bin/activate
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
    }
}
