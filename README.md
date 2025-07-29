# API CXC con Swagger

API REST para gestión de Cuentas por Cobrar (CXC) con documentación automática usando Swagger/OpenAPI 3.

## Características

- ✅ API REST de consulta con Spring Boot 3.5.4
- ✅ Documentación automática con Swagger/OpenAPI 3
- ✅ Seguridad configurada con Spring Security
- ✅ Base de datos Oracle con JPA (solo lectura)
- ✅ Lombok para reducir código boilerplate
- ✅ Paginación y búsquedas avanzadas

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

### Consulta de Clientes (API REST Paginada - Solo Lectura)
- `GET /api/clientes/{idCompania}` - Obtener clientes paginados por compañía
- `GET /api/clientes/{idCompania}/{idCliente}` - Obtener cliente específico por ID
- `GET /api/clientes/{idCompania}/buscar/nombre` - Buscar por nombre o razón social
- `GET /api/clientes/{idCompania}/buscar/rfc` - Buscar por RFC
- `GET /api/clientes/{idCompania}/buscar/referencia` - Buscar por referencia
- `GET /api/clientes/{idCompania}/buscar/email` - Buscar por email
- `GET /api/clientes/{idCompania}/buscar/clasificacion` - Buscar por clasificación
- `GET /api/clientes/{idCompania}/buscar/grupo` - Buscar por grupo
- `GET /api/clientes/{idCompania}/buscar/cobrador` - Buscar por cobrador
- `GET /api/clientes/{idCompania}/buscar/avanzado` - Búsqueda avanzada con múltiples criterios
- `GET /api/clientes/{idCompania}/estadisticas/total` - Obtener total de clientes
- `GET /api/clientes/{idCompania}/catalogos/clasificaciones` - Obtener clasificaciones disponibles
- `GET /api/clientes/{idCompania}/catalogos/grupos` - Obtener grupos disponibles
- `GET /api/clientes/{idCompania}/catalogos/cobradores` - Obtener cobradores disponibles

## Configuración

### Base de Datos Oracle
- **Servidor**: 217.160.55.171:1521
- **SID**: rentas
- **Usuario**: api1radm
- **Contraseña**: pXA*3234G
- **Driver**: ojdbc11 (versión automática de Spring Boot)
- **Nota**: Configurado para evitar triggers problemáticos (CHANGE_DATE_FORMAT)

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

# Base de Datos Oracle
spring.datasource.url=jdbc:oracle:thin:@217.160.55.171:1521:rentas
spring.datasource.username=api1radm
spring.datasource.password=pXA*3234G
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
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

1. ✅ Configurar base de datos Oracle
2. ✅ Implementar modelos de datos (entidades JPA)
3. ✅ Agregar servicios de negocio
4. ✅ Implementar API REST de consulta paginada
5. ✅ Configurar para evitar triggers problemáticos
6. Implementar validaciones
7. Configurar autenticación JWT
8. Agregar más endpoints de consulta según requerimientos

## Tecnologías utilizadas

- **Spring Boot**: 3.5.4
- **Java**: 21
- **Spring Security**: Para autenticación y autorización
- **Spring Data JPA**: Para persistencia de datos
- **Oracle Database**: Oracle
- **Oracle JDBC Driver**: ojdbc11 (automático)
- **Swagger/OpenAPI**: Documentación de API
- **Lombok**: Reducción de código boilerplate 