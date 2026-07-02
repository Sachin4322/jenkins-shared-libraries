def call(String credId,string imagename){ 
  withCredentials([usernamePassword(
                    credentialsId: '${credId}',
                    usernameVariable: 'dockerHubUser',
                    passwordVariable: 'dockerHubPass'
                )]) {

                    sh '''
                    echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
                    docker tag ${imagename} $dockerHubUser/${imagename}
                    docker push $dockerHubUser/${imagename}:latest
                    '''
                }
}
