pipeline {
    agent any

    stages {
        stage ('checkout-git') {

            steps {
               git poll:true, url:'https://github.com/milegf21/ProyectoJenkins.git'
                }
            }
        }

        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven-3.6.0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}
