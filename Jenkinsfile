def gv

pipeline {
  
  agent any
  
  parameters {
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  
  stages {
    stage("init") {
      steps {
        script {
          gv = load "script.groovy"
          echo 'printenv'
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
          gv.buildApp()
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
          gv.testApp()
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
