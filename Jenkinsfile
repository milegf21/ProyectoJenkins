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
                     junit '**/target/surefire-reports/*.xml'
             
            }
        }
         stage ('metricas') {
            steps {
                 withSonarQubeEnv ( ' Servidor SonarQube ' ) {
			    	bat 'D:/Sonar/sonar-scanner-2.6.1/bin/sonar-scanner'
			    }
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
