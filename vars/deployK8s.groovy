def call(buildTag) {
   
        sh """
            sed -i "s/IMAGE_TAG/${buildTag}/g" deployment.yaml
            kubectl apply -f deployment.yaml
        """
   
}
