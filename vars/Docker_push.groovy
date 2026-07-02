def call(String credId, String imageName) {

    withCredentials([
        usernamePassword(
            credentialsId: credId,
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh """
            echo "\$dockerHubPass" | docker login -u "\$dockerHubUser" --password-stdin
            docker tag ${imageName}:latest \$dockerHubUser/${imageName}:latest
            docker push \$dockerHubUser/${imageName}:latest
        """
    }
}
