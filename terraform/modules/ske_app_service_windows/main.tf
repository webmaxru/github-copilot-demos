

# Create a resource group
resource "azurerm_resource_group" "rg" {
    name     = var.resource_group_name
    location = var.location
}

# Create an App Service Plan
resource "azurerm_service_plan" "app_service_plan" {
    name                = "${var.app_service_name}-plan"
    location            = var.location
    resource_group_name = azurerm_resource_group.rg.name
    sku_name = "B1"
    os_type = "Windows"
}

# Create an App Service
resource "azurerm_windows_web_app" "app_service" {
    name                = var.app_service_name
    location            = var.location
    resource_group_name = azurerm_resource_group.rg.name
    service_plan_id = azurerm_service_plan.app_service_plan.id

    site_config {
        application_stack {
            current_stack = "dotnet"
            dotnet_version = "v8.0"
        }
    }
}