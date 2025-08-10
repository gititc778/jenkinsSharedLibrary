def call(buildTag) {
    sh """
        helm upgrade --install sampleapp ./helm-charts/sampleapp \
            --set image.tag=${buildTag}
    """
}