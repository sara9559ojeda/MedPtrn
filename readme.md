# Proyecto de Gestión de Medicamentos

Este proyecto es una aplicación web basada en Spring Boot para la gestión de medicamentos. Incluye una API REST para manejar operaciones CRUD y autenticación de usuarios, junto con una interfaz web simple para interactuar con la aplicación.

## Instalación

### Requisitos previos
- Java 17 o superior
- Spring Boot
- MySQL (o H2 para pruebas)
- Postman (para probar la API)

### Configuración del Backend
1. Clonar el repositorio del proyecto.
2. Configurar la base de datos en `application.properties`.
3. Ejecutar el proyecto con:
   ```sh
   mvn spring-boot:run
   ```

### Configuración del Frontend
1. Abrir el archivo `index.html` en un navegador o servirlo con un servidor web local.

## Rutas de la API para probar en Postman

### Medicamentos
- **Obtener todos los medicamentos**
  ```
  GET http://localhost:8080/api/medicine
  ```

- **Obtener un medicamento por ID**
  ```
  GET http://localhost:8080/api/medicine/1
  ```

- **Crear un nuevo medicamento**
  ```
  POST http://localhost:8080/api/medicine
  ```

- **Actualizar un medicamento**
  ```
  PUT http://localhost:8080/api/medicine/1
  ```

- **Eliminar un medicamento**
  ```
  DELETE http://localhost:8080/api/medicine/1
  ```

### Autenticación de Usuarios
- **Registrar usuario**
  ```
  POST http://localhost:8080/api/auth/register
  ```

- **Iniciar sesión**
  ```
  POST http://localhost:8080/api/auth/login
  ```

### Interfaz Web
- **Acceder al frontend**
  ```
  http://localhost:8080/index.html
  

