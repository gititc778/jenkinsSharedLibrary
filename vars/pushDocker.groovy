def call(buildTag) {
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
            docker tag sampleapp:${buildTag} ${DOCKER_USER}/sampleapp:${buildTag}
            docker push ${DOCKER_USER}/sampleapp:${buildTag}
        """
    }
}