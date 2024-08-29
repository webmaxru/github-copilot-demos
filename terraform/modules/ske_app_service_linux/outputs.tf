output "name" {
  description = "Name of the app service"
  value       = azurerm_linux_web_app.app_service.name
}

output "url" {
  description = "Url of the app service"
  value       = azurerm_linux_web_app.app_service.default_hostname
}