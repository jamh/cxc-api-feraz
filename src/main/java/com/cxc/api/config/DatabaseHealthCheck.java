package com.cxc.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class DatabaseHealthCheck implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHealthCheck.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        logger.info("🔍 Verificando conexión a Oracle...");
        
        try (Connection connection = dataSource.getConnection()) {
            logger.info("✅ Conexión a Oracle establecida exitosamente");
            
            // Verificar información de la conexión
            logger.info("📊 Información de la conexión:");
            logger.info("   - URL: {}", connection.getMetaData().getURL());
            logger.info("   - Usuario: {}", connection.getMetaData().getUserName());
            logger.info("   - Base de datos: {}", connection.getCatalog());
            logger.info("   - Driver: {}", connection.getMetaData().getDriverName());
            logger.info("   - Versión: {}", connection.getMetaData().getDatabaseProductVersion());
            
            // Probar consulta simple
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL")) {
                
                if (rs.next()) {
                    String currentDate = rs.getString(1);
                    logger.info("📅 Fecha actual del servidor: {}", currentDate);
                }
            }
            
            // Verificar acceso a la tabla R_CLIENTES (solo lectura para evitar triggers)
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM R_CLIENTES WHERE ROWNUM <= 1")) {
                
                if (rs.next()) {
                    int totalClientes = rs.getInt(1);
                    logger.info("📋 Acceso a tabla R_CLIENTES verificado (muestra: {} registros)", totalClientes);
                }
            }
            
            logger.info("🎉 Verificación de base de datos completada exitosamente");
            
        } catch (Exception e) {
            logger.error("❌ Error al conectar con Oracle: {}", e.getMessage());
            logger.error("Detalles del error:", e);
            // No lanzar excepción para evitar que la aplicación falle
            logger.warn("⚠️ La aplicación continuará sin verificación de base de datos");
        }
    }
} 