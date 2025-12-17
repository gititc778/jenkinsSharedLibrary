def call() {
    withCredentials([usernamePassword(credentialsId: 'aks-login', usernameVariable: 'AZURE_CLIENT_ID', passwordVariable: 'AZURE_CLIENT_SECRET')]) {
        sh """
            az logout || true
            az login --service-principal \\
                     -u "$AZURE_CLIENT_ID" \\
                     -p "$AZURE_CLIENT_SECRET" \\
                     --tenant 2b32b1fa-7899-482e-a6de-be99c0ff5516

            az aks get-credentials \\
                --resource-group rg-dev-flux \\
                --name aks-dev-flux-cluster \\
                --overwrite-existing

            kubectl get pods -n default
        """
    }
}
