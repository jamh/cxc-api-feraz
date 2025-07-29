package com.cxc.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "R_CLIENTES", schema = "RADM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "REFERENCIA", length = 100)
    private String referencia;

    @Column(name = "NOMBRE_RAZON_SOCIAL", length = 250)
    private String nombreRazonSocial;

    @Column(name = "NOMBRE_COMERCIAL", length = 250)
    private String nombreComercial;

    @Column(name = "CONTRATANTE_MORAL", length = 250)
    private String contratanteMoral;

    @Column(name = "CEDULA_IDENTIFICACION", length = 50)
    private String cedulaIdentificacion;

    @Column(name = "IFE_CONTRATANTE", length = 50)
    private String ifeContratante;

    @Column(name = "REGIMEN_CONTRATANTE", length = 250)
    private String regimenContratante;

    @Column(name = "DOMIC_NOTIFI_CONTRATANTE", length = 4000)
    private String domicNotifiContratante;

    @Column(name = "OCUPACION_CONTRATANTE", length = 100)
    private String ocupacionContratante;

    @Column(name = "RFC", length = 20)
    private String rfc;

    @Column(name = "EDO_CIVIL_CONTRATANTE", length = 15)
    private String edoCivilContratante;

    @Column(name = "ORIGINARIO_DE", length = 30)
    private String originarioDe;

    @Column(name = "DOMICILIO", length = 4000)
    private String domicilio;

    @Column(name = "NOTIFICACIONES_CONTRATANTE", length = 2000)
    private String notificacionesContratante;

    @Column(name = "TELEFONO", length = 200)
    private String telefono;

    @Column(name = "CRITERIO_IMPUESTOS", length = 1)
    private String criterioImpuestos = "A";

    @Column(name = "ID_COMPANIA", nullable = false)
    private Long idCompania;

    @Column(name = "CALLE", length = 200)
    private String calle;

    @Column(name = "NO_EXTERIOR", length = 50)
    private String noExterior;

    @Column(name = "NO_INTERIOR", length = 50)
    private String noInterior;

    @Column(name = "COLONIA", length = 100)
    private String colonia;

    @Column(name = "MUNICIPIO", length = 100)
    private String municipio;

    @Column(name = "ESTADO", length = 100)
    private String estado;

    @Column(name = "PAIS", length = 100)
    private String pais;

    @Column(name = "NACIONALIDAD_CONTRATANTE", length = 15)
    private String nacionalidadContratante;

    @Column(name = "CP", length = 30)
    private String cp;

    @Column(name = "EMAIL", length = 4000)
    private String email;

    @Column(name = "LOCALIDAD", length = 200)
    private String localidad;

    @Column(name = "FACTURAS_SEPARADAS", length = 1)
    private String facturasSeparadas = "N";

    @Column(name = "CLASIFICACION", length = 1000)
    private String clasificacion;

    @Column(name = "GRUPO", length = 1000)
    private String grupo;

    @Column(name = "COBRADOR", length = 1000)
    private String cobrador;

    @Column(name = "OBLIGADO_SOLIDARIO", length = 250)
    private String obligadoSolidario;

    @Column(name = "NAC_OBLIGADO_SOLIDARIO", length = 150)
    private String nacObligadoSolidario;

    @Column(name = "EDO_CIVIL_OBLIGADO_SOLIDARIO", length = 150)
    private String edoCivilObligadoSolidario;

    @Column(name = "DOM_OBLIGADO_SOLIDARIO", length = 4000)
    private String domObligadoSolidario;

    @Column(name = "IFE_OBLIGADO_SOLIDARIO", length = 50)
    private String ifeObligadoSolidario;

    @Column(name = "DOM_NOTI_OBLIGADO_SOLIDARIO", length = 4000)
    private String domNotiObligadoSolidario;

    @Column(name = "ORIGINARIO_OBLIGADO_SOLIDARIO", length = 30)
    private String originarioObligadoSolidario;

    @Column(name = "GARANTIA_OBLIGADO_SOLIDARIO", length = 100)
    private String garantiaObligadoSolidario;

    @Column(name = "PORC_ISR", precision = 18, scale = 4)
    private BigDecimal porcIsr = BigDecimal.ZERO;

    @Column(name = "PORC_IVA", precision = 18, scale = 4)
    private BigDecimal porcIva = BigDecimal.ZERO;

    @Column(name = "CEDULA_IDENTIFICACION_OBLIGADO", length = 50)
    private String cedulaIdentificacionObligado;

    @Column(name = "TIPO_INGRESO", length = 10)
    private String tipoIngreso;

    @Column(name = "CLASIFICACION_ANT", length = 1000)
    private String clasificacionAnt;

    @Column(name = "METODO_PAGO", length = 255)
    private String metodoPago = "No Identificado";

    @Column(name = "NO_CUENTA_BANCO", length = 250)
    private String noCuentaBanco;

    @Column(name = "METODOPAGO_SAT", length = 3)
    private String metodoPagoSat;

    @Column(name = "FORMAPAGO_SAT", length = 2)
    private String formaPagoSat;

    @Column(name = "USOCFDI_SAT", length = 10)
    private String usoCfdiSat;

    @Column(name = "PORC_IEPS", precision = 18, scale = 4)
    private BigDecimal porcIeps = BigDecimal.ZERO;

    @Column(name = "NUMREGIDTRIB", length = 250)
    private String numRegIdTrib;

    @Column(name = "RESIDENCIA_FISCAL", length = 20)
    private String residenciaFiscal;

    @Column(name = "EMAIL_CC", length = 4000)
    private String emailCc;

    @Column(name = "EMAIL_REVISION", length = 4000)
    private String emailRevision;

    @Column(name = "SISTEMA_FERAZ", length = 4000)
    private String sistemaFeraz;

    @Column(name = "SERVICIO_FERAZ", length = 4000)
    private String servicioFeraz;

    @Column(name = "NOTAS_FERAZ", length = 4000)
    private String notasFeraz;

    @Column(name = "VENDEDOR", length = 4000)
    private String vendedor;

    @Column(name = "ERP_CUENTA", length = 150)
    private String erpCuenta;

    @Column(name = "ERP_CUENTA_COMPLEMENTARIA", length = 150)
    private String erpCuentaComplementaria;

    @Column(name = "ID_MONEDA")
    private Long idMoneda;

    @Column(name = "DOMICILIOFISCALRECEPTOR", length = 10)
    private String domicilioFiscalReceptor;

    @Column(name = "REGIMENFISCALRECEPTOR", length = 10)
    private String regimenFiscalReceptor;

    @Column(name = "OBJETOIMP", length = 10)
    private String objetoImp;

    @Column(name = "REGIMEN_CAPITAL", length = 4000)
    private String regimenCapital;

    @Column(name = "EMAIL_COMPLEMENTOS", length = 4000)
    private String emailComplementos;

    @Column(name = "AGREGAR_CONCEPTO", length = 10)
    private String agregarConcepto = "S";
} 