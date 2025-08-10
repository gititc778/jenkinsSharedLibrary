def call(buildTag) {
    withCredentials([file(credentialsId: 'kubeconfig-creds', variable: 'KUBECONFIG')]) {
        sh """
            helm upgrade --install sampleapp ./helm-charts/sampleApp \
                --set image.tag=${buildTag} \              
        """
    }
}
