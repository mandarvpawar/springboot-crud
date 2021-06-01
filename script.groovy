def version = "5.5.5"

def buildApp() {
  	echo 'Building the application'
  	echo "Version: ${Version}"
  	echo "Version: ${env.Version}"
  
	echo '$version'
}

def testApp() {
  echo 'testing the application'
}

def deployApp() {
  echo 'deploying the application'
  echo "deploying version ${params.VERSION}"
}

return this
