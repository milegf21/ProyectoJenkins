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
                    echo 'Build'
                     //junit '**/target/surefire-reports/*.xml'
             
            }
        }
         stage ('metricas') {
            environment {
                 scannerHome = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                 mvnHome =tool name: 'maven-3.6.0', type: 'maven'
                }
            steps {
                   // sh 'mvn sonar:sonar' 
                   // echo 'Build'
               
                    withSonarQubeEnv('SonarQube') {
                      sh "${mvnHome}/bin/mvn sonar:sonar"
                    }
             
            }
        }
         stage ('repositorio de activos') {
            steps {
                   echo 'Build'
                    //sh 'mvn deploy' 
            }
        }
        stage ('despliegue') {
            steps {
                   fileExists 'pom.xml'
             
            }
        }
    }
}
