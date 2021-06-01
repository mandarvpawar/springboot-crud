def date = "5.5.5"

def buildApp() {
  	echo 'Building the application'
  	echo "Version: ${Version}"
  	echo "Version: ${env.Version}"
  
	echo '${date}'
}

def testApp() {
  echo 'testing the application'
}

def deployApp() {
  echo 'deploying the application'
  echo "deploying version ${params.VERSION}"
}

return this
