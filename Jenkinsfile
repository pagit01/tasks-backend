pipeline{
    agent any
    stages{
        stage ('Build backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
		stage ('Teste unitario'){
            steps{
                bat 'mvn test'
            }
        }
		
		stage ('Teste unitario'){
            steps{
                bat 'mvn test'
            }
        }
		
		stage ('Deploy backend'){
            steps{
                bat 'deploy adapters: [tomcat8(credentialsId: 'fe2edbb6-da49-448d-9e22-3259fb502588', path: '', url: 'http://localhost:8080/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        }
      
    
}