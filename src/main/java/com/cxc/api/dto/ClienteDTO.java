	package com.cxc.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long idCliente;
    private String referencia;
    private String nombreRazonSocial;
    private String nombreComercial;
    private String rfc;
    private String email;
    private String telefono;
    private String domicilio;
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String cp;
    private String pais;
    private String clasificacion;
    private String grupo;
    private String cobrador;
    private String metodoPago;
    private BigDecimal porcIsr;
    private BigDecimal porcIva;
    private BigDecimal porcIeps;
    private String criterioImpuestos;
    private String facturasSeparadas;
    private Long idCompania;
} 