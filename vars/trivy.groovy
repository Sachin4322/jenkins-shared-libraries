def call() {
    sh 'trivy fs --format json -o results.json .'
}
