pipeline {
    agent any

    stages {
        stage ('checkout') {

            steps {
 
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '32a9bb40-61d9-48d3-9499-163692fae423', url: 'https://github.com/milegf21/ProyectoJenkins.git']]])
            
            }
        }
        stage ('Stacti code analisys') {
            steps {
                    echo 'Stacti code analisys'
             
            }
        }
         stage ('Build') {
            steps {
                    echo 'Build'
             
            }
        }
    }
}
