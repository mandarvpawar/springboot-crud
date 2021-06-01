def buildApp() {
  echo 'building the application'
  echo "Version: ${Version}"
  echo "Version: ${env.Version}"
}

def testApp() {
  echo 'testing the application'
}

def deployApp() {
  echo 'deploying the application'
  echo "deploying version ${params.VERSION}"
}

return this
