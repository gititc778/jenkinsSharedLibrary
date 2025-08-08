def call() {
    def date = new Date().format('yyyyMMdd')
    def buildTag = "${date}.${env.BUILD_NUMBER}"
    currentBuild.displayName = buildTag
    sh "echo BUILD_TAG=${buildTag} > build.env"
    return buildTag
}


