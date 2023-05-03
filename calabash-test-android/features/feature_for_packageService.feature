Feature: PackageService functionality

  Scenario: Guardamos un paquete correctamente
    Given I have a package with id "ABC123", date "31/12/2022", content "Contenido de prueba", description "Descripción de prueba", loggerId 1, and storehouseId 2
    When I save the package
    Then the package should be saved successfully

  Scenario: Guardamos un paquete con los campos vacios
    Given I have a package with id "", date "", content "", description "", loggerId 1, and storehouseId 2
    When I save the package
    Then the package should not be saved
