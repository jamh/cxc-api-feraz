package com.cxc.api.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class DateFormatterService {

    private static final DateTimeFormatter ORACLE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DISPLAY_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Formatea una fecha de Oracle para mostrar
     */
    public String formatOracleDate(String oracleDate) {
        if (oracleDate == null || oracleDate.trim().isEmpty()) {
            return null;
        }
        
        try {
            // Intentar parsear como timestamp de Oracle
            LocalDateTime dateTime = LocalDateTime.parse(oracleDate, ORACLE_DATE_FORMAT);
            return dateTime.format(DISPLAY_DATE_FORMAT);
        } catch (Exception e) {
            // Si falla, devolver el valor original
            return oracleDate;
        }
    }

    /**
     * Formatea una fecha para Oracle
     */
    public String formatForOracle(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(ORACLE_DATE_FORMAT);
    }

    /**
     * Convierte un Date a formato Oracle
     */
    public String formatDateForOracle(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime()).toString();
    }

    /**
     * Obtiene la fecha actual en formato Oracle
     */
    public String getCurrentOracleDate() {
        return LocalDateTime.now().format(ORACLE_DATE_FORMAT);
    }

    /**
     * Verifica si una cadena es una fecha válida de Oracle
     */
    public boolean isValidOracleDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return false;
        }
        
        try {
            LocalDateTime.parse(dateString, ORACLE_DATE_FORMAT);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
} 