def call(buildTag) {
    sh """
        helm upgrade --install sampleapp ./helm/sampleapp  \
            --set image.tag=${buildTag}
    """
}
