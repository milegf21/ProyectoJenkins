pipeline {
    agent any
    tools {
        maven 'maven-3.6.0'
        jdk 'Java SE 8'
    }
    stages {
        stage ('Obtener fuentes') {

            steps {
 
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '32a9bb40-61d9-48d3-9499-163692fae423', url: 'https://github.com/milegf21/ProyectoJenkins.git']]])
            
            }
        }
        stage ('test') {
            steps {
                    echo 'Build'
                     //junit '**/target/surefire-reports/*.xml'
             
            }
        }
         stage ('metricas') {
            steps {
                    echo 'Build'
             
            }
        }
         stage ('repositorio de activos') {
            steps {
                    echo 'Build'
             
            }
        }
        stage ('despliegue') {
            steps {
                   fileExists 'pom.xml'
             
            }
        }
    }
}
