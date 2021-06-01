def gv

pipeline {
  
  agent any
  
  parameters {
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  
  environment {
  	version = "1.0.0"
  }
  
  stages {
    stage("Env Variables") {
      steps {
        sh "printenv"
      }
    }
    stage("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    stage("build") {
      steps {
        script {
          sh "ls ${env.JENKINS_HOME}"
          echo '***********************'
          sh "ls ${env.WORKSPACE}"
          echo '***********************'
          sh "ls ${env.PWD}"
          echo '***********************'
          sh "ls ${env.WORKSPACE_TMP}"
          echo '***********************'
          sh 'printenv'
          gv.buildApp("build stage")
        }
      }
    }
    stage("test") {
      when {
        expression {
          params.executeTests
        }
      }
      steps {
        script {
          gv.testApp("jenkinsfile:: test")
        }
      }
    }
    stage("deploy") {
      steps {
        script {
          gv.deployApp()
        }
      }
    }
  }
}
