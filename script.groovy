def date = "5.5.5"

def buildApp(String arg) {
  	echo 'Building the application'
  	echo "Version: ${Version}"
  	echo "Version: ${env.Version}"
  
	echo arg
}

def testApp() {
  echo 'testing the application'
}

def deployApp() {
  echo 'deploying the application'
  echo "deploying version ${params.VERSION}"
}

return this
