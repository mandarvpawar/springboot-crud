def value = "5.5.5"

def buildApp(String arg) {
  	echo 'Building the application'
  	echo "Version: ${Version}"
  
	echo arg
	testApp("script.groovy:: buildApp.")
}

def testApp(String type) {
	println "from " + type
	echo 'testing the application'
}

def deployApp() {
	echo 'deploying the application'
  	echo "deploying version ${params.VERSION}"
  	echo this.value
}

return this
