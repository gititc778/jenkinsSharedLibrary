def call(buildTag) {
    sh "docker build -t sampleapp:${buildTag} ."
}