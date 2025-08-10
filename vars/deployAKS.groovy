def call(buildTag) {
    sh """
        helm upgrade --install sampleapp ./helm-charts/sampleApp \
            --set image.tag=${buildTag}
    """
}