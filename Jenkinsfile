pipeline {
    agent any

    stages {
        stage ('Obtener fuentes') {

            steps {
 
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '32a9bb40-61d9-48d3-9499-163692fae423', url: 'https://github.com/milegf21/ProyectoJenkins.git']]])
            
            }
        }
        stage ('test') {
            steps {
                    echo 'Static code analisys'
             
            }
        }
         stage ('metricas') {
            steps {
                   fileExists 'pom.xml'
             
            }
        }
         stage ('repositorio de activos') {
            steps {
                    echo 'Build'
             
            }
        }
        stage ('despliegue') {
            steps {
                    echo 'Build'
             
            }
        }
    }
}
