package com.cxc.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class OracleConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        // Configuraciones optimizadas para Oracle 19c
        jdbcTemplate.setFetchSize(100);
        jdbcTemplate.setMaxRows(1000);
        
        return jdbcTemplate;
    }

    /**
     * Constantes para consultas optimizadas en Oracle 12c
     */
    public static class Oracle12cQueries {
        // Consulta optimizada para contar registros
        public static final String COUNT_CLIENTES = 
            "SELECT COUNT(*) FROM R_CLIENTES WHERE ROWNUM <= 10000";
        
        // Consulta optimizada para obtener cliente por ID
        public static final String GET_CLIENTE_BY_ID = 
            "SELECT * FROM R_CLIENTES WHERE ID_CLIENTE = ? AND ID_COMPANIA = ? AND ROWNUM = 1";
        
        // Consulta optimizada para paginación
        public static final String GET_CLIENTES_PAGINATED = 
            "SELECT * FROM (" +
            "  SELECT a.*, ROWNUM rnum FROM (" +
            "    SELECT * FROM R_CLIENTES WHERE ID_COMPANIA = ? ORDER BY %s" +
            "  ) a WHERE ROWNUM <= ?" +
            ") WHERE rnum > ?";
        
        // Consulta para clasificaciones únicas
        public static final String GET_DISTINCT_CLASIFICACIONES = 
            "SELECT DISTINCT CLASIFICACION FROM R_CLIENTES " +
            "WHERE ID_COMPANIA = ? AND CLASIFICACION IS NOT NULL AND ROWNUM <= 100";
        
        // Consulta para grupos únicos
        public static final String GET_DISTINCT_GRUPOS = 
            "SELECT DISTINCT GRUPO FROM R_CLIENTES " +
            "WHERE ID_COMPANIA = ? AND GRUPO IS NOT NULL AND ROWNUM <= 100";
        
        // Consulta para cobradores únicos
        public static final String GET_DISTINCT_COBRADORES = 
            "SELECT DISTINCT COBRADOR FROM R_CLIENTES " +
            "WHERE ID_COMPANIA = ? AND COBRADOR IS NOT NULL AND ROWNUM <= 100";
    }
} 