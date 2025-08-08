def call(buildTag) {
    withCredentials([file(credentialsId: 'kubeconfig-creds', variable: 'KUBECONFIG')]) {
        sh """
            sed -i "s/IMAGE_TAG/${buildTag}/g" deployment.yaml
            kubectl apply -f deployment.yaml
        """
    }
}