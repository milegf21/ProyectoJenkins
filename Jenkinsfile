pipeline {
    agent any
    
    stages {
   stage ('install') {
       //environment {
         //   mvnHome= tool name: 'maven-3.6.0', type: 'maven'
       //}
            steps {
                mvnHome= tool name: 'maven-3.6.0', type: 'maven'
                 //sh "${mvnHome}/bin/mvn package"  
            }
        }
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
                   // sh 'mvn sonar:sonar' 
                   // echo 'Build'
                 scannerHome = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    withSonarQubeEnv('SonarQube') {
                      sh "${scannerHome}/bin/sonar-scanner.bat"
                    }
             
            }
        }
         stage ('repositorio de activos') {
            steps {
                   // echo 'Build'
                    sh 'mvn deploy' 
            }
        }
        stage ('despliegue') {
            steps {
                   fileExists 'pom.xml'
             
            }
        }
    }
}
