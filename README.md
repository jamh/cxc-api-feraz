# API CXC con Swagger

API REST para gestión de Cuentas por Cobrar (CXC) con documentación automática usando Swagger/OpenAPI 3.

## Características

- ✅ API REST con Spring Boot 3.5.4
- ✅ Documentación automática con Swagger/OpenAPI 3
- ✅ Seguridad configurada con Spring Security
- ✅ Base de datos Oracle con JPA
- ✅ Lombok para reducir código boilerplate

## Configuración de Swagger

### Dependencias agregadas:
- `springdoc-openapi-starter-webmvc-ui`: Interfaz de usuario de Swagger
- `springdoc-openapi-starter-common`: Soporte para OpenAPI 3

### URLs de acceso:
- **Swagger UI**: http://localhost:8080/api/swagger-ui.html
- **Documentación JSON**: http://localhost:8080/api/api-docs
- **OpenAPI JSON**: http://localhost:8080/api/v3/api-docs

## Cómo ejecutar

1. **Compilar el proyecto:**
   ```bash
   ./mvnw clean compile
   ```

2. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acceder a Swagger UI:**
   - Abrir navegador en: http://localhost:8080/api/swagger-ui.html

## Endpoints disponibles

### Gestión de Clientes
- `GET /api/clientes` - Obtener todos los clientes
- `GET /api/clientes/{id}` - Obtener cliente por ID
- `POST /api/clientes` - Crear nuevo cliente
- `PUT /api/clientes/{id}` - Actualizar cliente
- `DELETE /api/clientes/{id}` - Eliminar cliente

## Configuración

### application.properties
```properties
# Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha

# Servidor
server.port=8080
server.servlet.context-path=/api
```

### Seguridad
- Los endpoints de Swagger están configurados para acceso público
- Los endpoints de la API están temporalmente abiertos para desarrollo
- Para producción, configurar autenticación apropiada

## Anotaciones de Swagger utilizadas

- `@Tag`: Agrupa endpoints por funcionalidad
- `@Operation`: Describe la operación del endpoint
- `@Parameter`: Documenta parámetros de entrada
- `@ApiResponses`: Define códigos de respuesta posibles
- `@Schema`: Define la estructura de datos

## Próximos pasos

1. Implementar modelos de datos (entidades JPA)
2. Agregar servicios de negocio
3. Implementar validaciones
4. Configurar autenticación JWT
5. Agregar más endpoints según requerimientos
6. Configurar base de datos Oracle

## Tecnologías utilizadas

- **Spring Boot**: 3.5.4
- **Java**: 21
- **Spring Security**: Para autenticación y autorización
- **Spring Data JPA**: Para persistencia de datos
- **Oracle Database**: Base de datos
- **Swagger/OpenAPI**: Documentación de API
- **Lombok**: Reducción de código boilerplate 