package com.cxc.api.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        
        // Configuración básica
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);
        
        // Configuración del pool de conexiones
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        
        // Configuración específica para Oracle
        config.addDataSourceProperty("oracle.jdbc.timezoneAsRegion", "false");
        config.addDataSourceProperty("oracle.jdbc.fanEnabled", "false");
        config.addDataSourceProperty("oracle.net.CONNECT_TIMEOUT", "10000");
        config.addDataSourceProperty("oracle.jdbc.ReadTimeout", "30000");
        config.addDataSourceProperty("oracle.jdbc.implicitCachingEnabled", "true");
        config.addDataSourceProperty("oracle.jdbc.maxCachedBufferSize", "20");
        
        // Configuración de validación de conexión
        config.setConnectionTestQuery("SELECT 1 FROM DUAL");
        config.setValidationTimeout(5000);
        
        return new HikariDataSource(config);
    }
} 