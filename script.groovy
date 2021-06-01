def map = [
        Bob  : 42,
        Alice: 54,
        Max  : 33
]

def buildApp() {
  	echo 'Building the application'
  	echo "Version: ${Version}"
  	echo "Version: ${env.Version}"
  
	script {
		map.each { entry ->
	    	stage (entry.key) {
	        	timestamps{
	            	echo "$entry.value"
	        	}
	    	}
		}
	}
}

def testApp() {
  echo 'testing the application'
}

def deployApp() {
  echo 'deploying the application'
  echo "deploying version ${params.VERSION}"
}

return this
