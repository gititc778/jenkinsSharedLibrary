def call(buildTag) {
    sh """
        helm upgrade --install sampleapp ./helm/sampleapp -n devops \
            --set image.tag=${buildTag}
    """
}
