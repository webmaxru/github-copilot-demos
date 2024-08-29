provider "azurerm" {
        features {}
        skip_provider_registration = true
}

module "web_app" {
    source = "./modules/ske_app_service_linux"

    resource_group_name = "demo-linux-rg"
    app_service_name    = "copilotdemo-linux"
    location            = "norwayeast"
}