def value = "5.5.5"

def buildApp(String arg) {
  	echo 'Building the application'
  	echo "Version: ${Version}"
  	echo "Version: ${env.Version}"
  
	echo arg
	println value
}

def testApp() {
  echo 'testing the application'
}

def deployApp() {
  echo 'deploying the application'
  echo "deploying version ${params.VERSION}"
}

return this
