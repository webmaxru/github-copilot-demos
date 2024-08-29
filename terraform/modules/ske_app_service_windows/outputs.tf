output "name" {
  description = "Name of the app service"
  value       = azurerm_windows_web_app.app_service.name
}

output "url" {
  description = "Url of the app service"
  value       = azurerm_windows_web_app.app_service.default_hostname
}