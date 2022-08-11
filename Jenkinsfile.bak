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
        }
      
    
}