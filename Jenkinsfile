pipeline {
    agent any

    stages {
        stage('Preparação') {
            steps {
                echo 'Realizando etapas de preparação antes do build...'
            }
        }

        stage('Build da Aplicação') {
            steps {
                script {
                    echo '\033[1;34mIniciando o Build da Aplicação (Moca)\033[0m'
                }
                build job: 'Moca'
            }
        }

        stage('Testes Unitários') {
            steps {
                script {
                    echo '\033[1;35mExecutando Testes Unitários...\033[0m'
                }
            }
        }

        stage('Deploy de Desenvolvimento') {
            steps {
                script {
                    echo '\033[1;36mRealizando o Deploy da Aplicação em Ambiente de Desenvolvimento...\033[0m'
                }
            }
        }

        stage('Teste de Carga') {
            steps {
                script {
                    echo '\033[1;33mIniciando o Teste de Carga...\033[0m'
                }
                build job: 'Load Test'
            }
        }

        stage('Finalizando Job') {
            steps {
                script {
                    echo '\033[1;32mLimpando arquivos e finalizando job...\033[0m'
                }
            }
        }

        stage('Job Finalizado') {
            steps {
                script {
                    echo '\033[1;32mJob Finalizado com sucesso!\033[0m'
                }
            }
        }
    }
}
