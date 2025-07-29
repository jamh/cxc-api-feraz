package com.cxc.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDetalleDTO {
    private Long idCliente;
    private String referencia;
    private String nombreRazonSocial;
    private String nombreComercial;
    private String contratanteMoral;
    private String cedulaIdentificacion;
    private String ifeContratante;
    private String regimenContratante;
    private String domicNotifiContratante;
    private String ocupacionContratante;
    private String rfc;
    private String edoCivilContratante;
    private String originarioDe;
    private String domicilio;
    private String notificacionesContratante;
    private String telefono;
    private String criterioImpuestos;
    private Long idCompania;
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
    private String nacionalidadContratante;
    private String cp;
    private String email;
    private String localidad;
    private String facturasSeparadas;
    private String clasificacion;
    private String grupo;
    private String cobrador;
    private String obligadoSolidario;
    private String nacObligadoSolidario;
    private String edoCivilObligadoSolidario;
    private String domObligadoSolidario;
    private String ifeObligadoSolidario;
    private String domNotiObligadoSolidario;
    private String originarioObligadoSolidario;
    private String garantiaObligadoSolidario;
    private BigDecimal porcIsr;
    private BigDecimal porcIva;
    private String cedulaIdentificacionObligado;
    private String tipoIngreso;
    private String clasificacionAnt;
    private String metodoPago;
    private String noCuentaBanco;
    private String metodoPagoSat;
    private String formaPagoSat;
    private String usoCfdiSat;
    private BigDecimal porcIeps;
    private String numRegIdTrib;
    private String residenciaFiscal;
    private String emailCc;
    private String emailRevision;
    private String sistemaFeraz;
    private String servicioFeraz;
    private String notasFeraz;
    private String vendedor;
    private String erpCuenta;
    private String erpCuentaComplementaria;
    private Long idMoneda;
    private String domicilioFiscalReceptor;
    private String regimenFiscalReceptor;
    private String objetoImp;
    private String regimenCapital;
    private String emailComplementos;
    private String agregarConcepto;
} 