pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
 
                    sh 'mvn clean compile'
            
            }
        }


        stage ('Deployment Stage') {
            steps {
                    sh 'mvn deploy'
             
            }
        }
    }
}
