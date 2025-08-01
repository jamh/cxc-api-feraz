package com.cxc.api.converter;

import com.cxc.api.dto.ClienteMovimientosDto;
import com.cxc.api.entity.ClienteMovimientos;

import java.text.SimpleDateFormat;

public class ClienteMovimientosConverter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static ClienteMovimientosDto toDto(ClienteMovimientos entity) {
        if (entity == null) return null;

        ClienteMovimientosDto dto = new ClienteMovimientosDto();

        dto.setIdMovimiento(entity.getIdMovimiento());
        dto.setImporte(entity.getImporte() != null ? entity.getImporte().doubleValue() : null);
        dto.setFecha(entity.getFecha() != null ? dateFormat.format(entity.getFecha()) : null);
        dto.setCalendario(entity.getCalendario() != null ? entity.getCalendario().toString() : null);
        dto.setTipoRecibo(entity.getTipoRecibo());
        dto.setNumFolio(entity.getNumFolio() != null ? entity.getNumFolio().toString() : null);
        dto.setIdCompania(entity.getIdCompania());
        dto.setImporteTotal(entity.getImporteTotal() != null ? entity.getImporteTotal().doubleValue() : null);
        dto.setAutorizado(entity.getAutorizado());
        dto.setNumFolioFe(entity.getNumFolioFe());
        dto.setNomPdf(entity.getNomPdf());
        dto.setNomXml(entity.getNomXml());
        dto.setCancelada(entity.getCancelada());
        dto.setObservacion(entity.getObservacion());
        dto.setIdCliente(entity.getIdCliente());
        dto.setIdLocal(entity.getIdLocal());
        dto.setSec(entity.getSec() != null ? entity.getSec().toString() : null);
        dto.setIdConcepto(entity.getIdConcepto());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setNoCuentaBanco(entity.getNoCuentaBanco());
        dto.setIdMoneda(entity.getIdMoneda());
        dto.setObservaciones(entity.getObservaciones());
        dto.setClasificacion(entity.getClasificacion());
        dto.setCantidad(entity.getCantidad() != null ? entity.getCantidad().doubleValue() : null);
        dto.setTipoCambio(entity.getTipoCambio() != null ? entity.getTipoCambio().doubleValue() : null);
        dto.setFechaCap(entity.getFechaCap() != null ? dateFormat.format(entity.getFechaCap()) : null);
        dto.setNumFolioFacturaNc(entity.getNumFolioFacturaNc() != null ? entity.getNumFolioFacturaNc().toString() : null);
        dto.setNumFolioFeFacturaNc(entity.getNumFolioFeFacturaNc());
        dto.setTipoIngreso(entity.getTipoIngreso());
        dto.setCtoCostos(entity.getCtoCostos());
        dto.setBancoPago(entity.getBancoPago());
        dto.setCuentaBancoPago(entity.getCuentaBancoPago());
        dto.setFechaCancelacion(entity.getFechaCancelacion() != null ? dateFormat.format(entity.getFechaCancelacion()) : null);
        Double pagoTotalDto = null;
        if (entity.getPagoTotal() != null) {
            try {
                pagoTotalDto = Double.parseDouble(entity.getPagoTotal());
            } catch (Exception e) {
                pagoTotalDto = null;
            }
        }
        dto.setPagoTotal(pagoTotalDto);

        dto.setIva(entity.getIva() != null ? entity.getIva().doubleValue() : null);
        dto.setRetIva(entity.getRetIva() != null ? entity.getRetIva().doubleValue() : null);
        dto.setRetIsr(entity.getRetIsr() != null ? entity.getRetIsr().doubleValue() : null);
        dto.setUnidad(entity.getUnidad());
        dto.setDiasRevision(entity.getDiasRevision());
        dto.setFechaRevision(entity.getFechaRevision() != null ? dateFormat.format(entity.getFechaRevision()) : null);
        dto.setNotas(entity.getNotas());
        dto.setExento(entity.getExento());
        dto.setMetodopagoSat(entity.getMetodopagoSat());
        dto.setFormapagoSat(entity.getFormapagoSat());
        dto.setUsocfdiSat(entity.getUsocfdiSat());
        dto.setClaveprodSat(entity.getClaveprodSat());
        dto.setClaveunidadSat(entity.getClaveunidadSat());
        dto.setIeps(entity.getIeps() != null ? entity.getIeps().doubleValue() : null);
        dto.setRetIeps(entity.getRetIeps() != null ? entity.getRetIeps().doubleValue() : null);
        dto.setTraslados(entity.getTraslados() != null ? entity.getTraslados().toString() : null);
        dto.setRetenciones(entity.getRetenciones() != null ? entity.getRetenciones().toString() : null);
        dto.setFormadepagop(entity.getFormadepagop());
        dto.setNumOperacion(entity.getNumoperacion());
        dto.setRfcEmisorCatOrd(entity.getRfcemisorcatord());
        dto.setNomBancoOrdExt(entity.getNombancoordext());
        dto.setCtaOrdenante(entity.getCtaordenante());
        dto.setTipoCadPago(entity.getTipocadpago());
        dto.setCertPago(entity.getCertpago());
        dto.setCadPago(entity.getCadpago());
        dto.setSelloPago(entity.getSellopago());
        dto.setNumParcialidad(entity.getNumparcialidad() != null ? entity.getNumparcialidad().intValue() : null);
        dto.setImpSaldoAnt(entity.getImpsaldoant() != null ? entity.getImpsaldoant().doubleValue() : null);
        dto.setCfdiPago(entity.getCfdiPago());
        dto.setNumFolioFePago(entity.getNumFolioFePago());
        dto.setUuidPago(entity.getUuidPago());
        dto.setDescuento(entity.getDescuento() != null ? entity.getDescuento().doubleValue() : null);
        dto.setUuid(entity.getUuid());
        dto.setSecc(entity.getSecc() != null ? entity.getSecc().toString() : null);
        dto.setHora(entity.getHora());
        dto.setSecuencial(entity.getSecuencial() != null ? entity.getSecuencial().toString() : null);
        dto.setNoIdentificacion(entity.getNoidentificacion());
        dto.setIvaPorc(entity.getIvaPorc() != null ? entity.getIvaPorc().doubleValue() : null);
        dto.setRetIvaPorc(entity.getRetIvaPorc() != null ? entity.getRetIvaPorc().doubleValue() : null);
        dto.setIepsPorc(entity.getIepsPorc() != null ? entity.getIepsPorc().doubleValue() : null);
        dto.setRetIepsPorc(entity.getRetIepsPorc() != null ? entity.getRetIepsPorc().doubleValue() : null);
        dto.setRetIsrPorc(entity.getRetIsrPorc() != null ? entity.getRetIsrPorc().doubleValue() : null);
        dto.setFolioPrefactura(entity.getFolioPrefactura() != null ? entity.getFolioPrefactura().toString() : null);
        dto.setUsuarioCapturo(entity.getUsuarioCapturo());
        dto.setUsuarioTimbro(entity.getUsuarioTimbro());
        dto.setIdLugarExpedicion(entity.getIdLugarExpedicion() != null ? entity.getIdLugarExpedicion().toString() : null);
        dto.setTipoCambioPago(entity.getTipoCambioPago() != null ? entity.getTipoCambioPago().doubleValue() : null);
        dto.setSerie(entity.getSerie());
        dto.setHoraAgrupacionPagos(entity.getHoraAgrupacionPagos());
        dto.setMonedaPago(entity.getMonedaPago());
        dto.setNumeroPedimento(entity.getNumeroPedimento());
        dto.setTipoRelacionPago(entity.getTipoRelacionPago());
        dto.setUuidRelacionPago(entity.getUuidRelacionPago());
        dto.setNumOrdenCompra(entity.getNumOrdenCompra());
        dto.setFechaSolCancela(entity.getFechaSolCancela() != null ? dateFormat.format(entity.getFechaSolCancela()) : null);
        dto.setEstatusCancelacion(entity.getEstatusCancelacion());
        dto.setCotizacion(entity.getCotizacion());
        dto.setAgrupacionPagos(entity.getAgrupacionPagos());
        dto.setIdAnticipo(entity.getIdAnticipo());
        dto.setCondicionesPago(entity.getCondicionesPago());
        dto.setDatosSkOrigen(entity.getDatosSkOrigen());
        dto.setDatosSkLugar(entity.getDatosSkLugar());
        dto.setDatosSkPeriodo(entity.getDatosSkPeriodo());
        dto.setFechaRep(entity.getFechaRep() != null ? dateFormat.format(entity.getFechaRep()) : null);
        dto.setFechaTimbradoPago(entity.getFechaTimbradoPago() != null ? dateFormat.format(entity.getFechaTimbradoPago()) : null);
        dto.setCuentaIngreso(entity.getCuentaIngreso());
        dto.setCuentaCxc(entity.getCuentaCxc());
        dto.setCuentaCxcComplementaria(entity.getCuentaCxcComplementaria());
        dto.setUsuarioCancela(entity.getUsuarioCancela());
        dto.setIdPlanta(entity.getIdPlanta());
        dto.setIdDepositoSin(entity.getIdDepositoSin());
        dto.setTipoCambioPagoEspecial(entity.getTipoCambioPagoEspecial() != null ? entity.getTipoCambioPagoEspecial().doubleValue() : null);
        dto.setMotivoCancelacion(entity.getMotivoCancelacion());
        dto.setMotivoSustitucion(entity.getMotivoSustitucion());
        dto.setMotivoNc(entity.getMotivoNc());
        dto.setCm(entity.getCm() != null ? entity.getCm().toString() : null);
        dto.setCostoXcm(entity.getCostoxcm() != null ? entity.getCostoxcm().doubleValue() : null);
        dto.setFechaVencimiento(entity.getFechaVencimiento() != null ? dateFormat.format(entity.getFechaVencimiento()) : null);
        dto.setNumFolioFacturaNd(entity.getNumFolioFacturaNd() != null ? entity.getNumFolioFacturaNd().toString() : null);
        dto.setNumFolioFeFacturaNd(entity.getNumFolioFeFacturaNd());
        dto.setMotivoCancelacionSat(entity.getMotivoCancelacionSat());
        dto.setFolioFiscalSat(entity.getFolioFiscalSat());
        dto.setCfdiPagoCanceladoVirtual(entity.getCfdiPagoCanceladoVirtual());
        dto.setCfdiPagoCanceladoVirtualFecha(entity.getCfdiPagoCanceladoVirtualFecha() != null ? dateFormat.format(entity.getCfdiPagoCanceladoVirtualFecha()) : null);
        dto.setExportacion(entity.getExportacion());
        dto.setPeriodicidad(entity.getPeriodicidad());
        dto.setMeses(entity.getMeses());
        dto.setAnio(entity.getAnio());
        dto.setVersion(entity.getVersion());
        dto.setObjetoImp(entity.getObjetoimp());
        dto.setRfcACuentaTerceros(entity.getRfcacuentaterceros());
        dto.setNombreACuentaTerceros(entity.getNombreacuentaterceros());
        dto.setRegimenFiscalACuentaTerceros(entity.getRegimenfiscalacuentaterceros());
        dto.setDomicilioFiscalACuentaTerceros(entity.getDomiciliofiscalacuentaterceros());
        dto.setObjetoImpDr(entity.getObjetoimpdr());
        dto.setFechaAutorizado(entity.getFechaAutorizado() != null ? dateFormat.format(entity.getFechaAutorizado()) : null);

        return dto;
    }

    public static ClienteMovimientos toEntity(ClienteMovimientosDto dto) {
        if (dto == null) return null;

        ClienteMovimientos entity = new ClienteMovimientos();

        entity.setIdMovimiento(dto.getIdMovimiento());
        entity.setImporte(dto.getImporte() != null ? new java.math.BigDecimal(dto.getImporte()) : null);
        try {
            entity.setFecha(dto.getFecha() != null ? dateFormat.parse(dto.getFecha()) : null);
        } catch (Exception e) {
            entity.setFecha(null);
        }
        entity.setCalendario(dto.getCalendario() != null ? Integer.valueOf(dto.getCalendario()) : null);
        entity.setTipoRecibo(dto.getTipoRecibo());
        entity.setNumFolio(dto.getNumFolio() != null ? Long.valueOf(dto.getNumFolio()) : null);
        entity.setIdCompania(dto.getIdCompania());
        entity.setImporteTotal(dto.getImporteTotal() != null ? new java.math.BigDecimal(dto.getImporteTotal()) : null);
        entity.setAutorizado(dto.getAutorizado());
        entity.setNumFolioFe(dto.getNumFolioFe());
        entity.setNomPdf(dto.getNomPdf());
        entity.setNomXml(dto.getNomXml());
        entity.setCancelada(dto.getCancelada());
        entity.setObservacion(dto.getObservacion());
        entity.setIdCliente(dto.getIdCliente());
        entity.setIdLocal(dto.getIdLocal());
        entity.setSec(dto.getSec() != null ? Long.valueOf(dto.getSec()) : null);
        entity.setIdConcepto(dto.getIdConcepto());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setNoCuentaBanco(dto.getNoCuentaBanco());
        entity.setIdMoneda(dto.getIdMoneda());
        entity.setObservaciones(dto.getObservaciones());
        entity.setClasificacion(dto.getClasificacion());
        entity.setCantidad(dto.getCantidad() != null ? new java.math.BigDecimal(dto.getCantidad()) : null);
        entity.setTipoCambio(dto.getTipoCambio() != null ? new java.math.BigDecimal(dto.getTipoCambio()) : null);
        try {
            entity.setFechaCap(dto.getFechaCap() != null ? dateFormat.parse(dto.getFechaCap()) : null);
        } catch (Exception e) {
            entity.setFechaCap(null);
        }
        entity.setNumFolioFacturaNc(dto.getNumFolioFacturaNc() != null ? Long.valueOf(dto.getNumFolioFacturaNc()) : null);
        entity.setNumFolioFeFacturaNc(dto.getNumFolioFeFacturaNc());
        entity.setTipoIngreso(dto.getTipoIngreso());
        entity.setCtoCostos(dto.getCtoCostos());
        entity.setBancoPago(dto.getBancoPago());
        entity.setCuentaBancoPago(dto.getCuentaBancoPago());
        try {
            entity.setFechaCancelacion(dto.getFechaCancelacion() != null ? dateFormat.parse(dto.getFechaCancelacion()) : null);
        } catch (Exception e) {
            entity.setFechaCancelacion(null);
        }
        entity.setPagoTotal(dto.getPagoTotal() != null ? dto.getPagoTotal().toString() : null);
        entity.setIva(dto.getIva() != null ? new java.math.BigDecimal(dto.getIva()) : null);
        entity.setRetIva(dto.getRetIva() != null ? new java.math.BigDecimal(dto.getRetIva()) : null);
        entity.setRetIsr(dto.getRetIsr() != null ? new java.math.BigDecimal(dto.getRetIsr()) : null);
        entity.setUnidad(dto.getUnidad());
        entity.setDiasRevision(dto.getDiasRevision());
        try {
            entity.setFechaRevision(dto.getFechaRevision() != null ? dateFormat.parse(dto.getFechaRevision()) : null);
        } catch (Exception e) {
            entity.setFechaRevision(null);
        }
        entity.setNotas(dto.getNotas());
        entity.setExento(dto.getExento());
        entity.setMetodopagoSat(dto.getMetodopagoSat());
        entity.setFormapagoSat(dto.getFormapagoSat());
        entity.setUsocfdiSat(dto.getUsocfdiSat());
        entity.setClaveprodSat(dto.getClaveprodSat());
        entity.setClaveunidadSat(dto.getClaveunidadSat());
        entity.setIeps(dto.getIeps() != null ? new java.math.BigDecimal(dto.getIeps()) : null);
        entity.setRetIeps(dto.getRetIeps() != null ? new java.math.BigDecimal(dto.getRetIeps()) : null);
        entity.setTraslados(dto.getTraslados() != null ? new java.math.BigDecimal(dto.getTraslados()) : null);
        entity.setRetenciones(dto.getRetenciones() != null ? new java.math.BigDecimal(dto.getRetenciones()) : null);
        entity.setFormadepagop(dto.getFormadepagop());
        entity.setNumoperacion(dto.getNumOperacion());
        entity.setRfcemisorcatord(dto.getRfcEmisorCatOrd());
        entity.setNombancoordext(dto.getNomBancoOrdExt());
        entity.setCtaordenante(dto.getCtaOrdenante());
        entity.setTipocadpago(dto.getTipoCadPago());
        entity.setCertpago(dto.getCertPago());
        entity.setCadpago(dto.getCadPago());
        entity.setSellopago(dto.getSelloPago());
        entity.setNumparcialidad(dto.getNumParcialidad() != null ? dto.getNumParcialidad().longValue() : null);
        entity.setImpsaldoant(dto.getImpSaldoAnt() != null ? new java.math.BigDecimal(dto.getImpSaldoAnt()) : null);
        entity.setCfdiPago(dto.getCfdiPago());
        entity.setNumFolioFePago(dto.getNumFolioFePago());
        entity.setUuidPago(dto.getUuidPago());
        entity.setDescuento(dto.getDescuento() != null ? new java.math.BigDecimal(dto.getDescuento()) : null);
        entity.setUuid(dto.getUuid());
        entity.setSecc(dto.getSecc() != null ? Long.valueOf(dto.getSecc()) : null);
        entity.setHora(dto.getHora());
        entity.setSecuencial(dto.getSecuencial() != null ? Long.valueOf(dto.getSecuencial()) : null);
        entity.setNoidentificacion(dto.getNoIdentificacion());
        entity.setIvaPorc(dto.getIvaPorc() != null ? new java.math.BigDecimal(dto.getIvaPorc()) : null);
        entity.setRetIvaPorc(dto.getRetIvaPorc() != null ? new java.math.BigDecimal(dto.getRetIvaPorc()) : null);
        entity.setIepsPorc(dto.getIepsPorc() != null ? new java.math.BigDecimal(dto.getIepsPorc()) : null);
        entity.setRetIepsPorc(dto.getRetIepsPorc() != null ? new java.math.BigDecimal(dto.getRetIepsPorc()) : null);
        entity.setRetIsrPorc(dto.getRetIsrPorc() != null ? new java.math.BigDecimal(dto.getRetIsrPorc()) : null);
        entity.setFolioPrefactura(dto.getFolioPrefactura() != null ? Long.valueOf(dto.getFolioPrefactura()) : null);
        entity.setUsuarioCapturo(dto.getUsuarioCapturo());
        entity.setUsuarioTimbro(dto.getUsuarioTimbro());
        entity.setIdLugarExpedicion(dto.getIdLugarExpedicion() != null ? Long.valueOf(dto.getIdLugarExpedicion()) : null);
        entity.setTipoCambioPago(dto.getTipoCambioPago() != null ? new java.math.BigDecimal(dto.getTipoCambioPago()) : null);
        entity.setSerie(dto.getSerie());
        entity.setHoraAgrupacionPagos(dto.getHoraAgrupacionPagos());
        entity.setMonedaPago(dto.getMonedaPago());
        entity.setNumeroPedimento(dto.getNumeroPedimento());
        entity.setTipoRelacionPago(dto.getTipoRelacionPago());
        entity.setUuidRelacionPago(dto.getUuidRelacionPago());
        entity.setNumOrdenCompra(dto.getNumOrdenCompra());
        try {
            entity.setFechaSolCancela(dto.getFechaSolCancela() != null ? dateFormat.parse(dto.getFechaSolCancela()) : null);
        } catch (Exception e) {
            entity.setFechaSolCancela(null);
        }
        entity.setEstatusCancelacion(dto.getEstatusCancelacion());
        entity.setCotizacion(dto.getCotizacion());
        entity.setAgrupacionPagos(dto.getAgrupacionPagos());
        entity.setIdAnticipo(dto.getIdAnticipo());
        entity.setCondicionesPago(dto.getCondicionesPago());
        entity.setDatosSkOrigen(dto.getDatosSkOrigen());
        entity.setDatosSkLugar(dto.getDatosSkLugar());
        entity.setDatosSkPeriodo(dto.getDatosSkPeriodo());
        try {
            entity.setFechaRep(dto.getFechaRep() != null ? dateFormat.parse(dto.getFechaRep()) : null);
        } catch (Exception e) {
            entity.setFechaRep(null);
        }
        try {
            entity.setFechaTimbradoPago(dto.getFechaTimbradoPago() != null ? dateFormat.parse(dto.getFechaTimbradoPago()) : null);
        } catch (Exception e) {
            entity.setFechaTimbradoPago(null);
        }
        entity.setCuentaIngreso(dto.getCuentaIngreso());
        entity.setCuentaCxc(dto.getCuentaCxc());
        entity.setCuentaCxcComplementaria(dto.getCuentaCxcComplementaria());
        entity.setUsuarioCancela(dto.getUsuarioCancela());
        entity.setIdPlanta(dto.getIdPlanta());
        entity.setIdDepositoSin(dto.getIdDepositoSin());
        entity.setTipoCambioPagoEspecial(dto.getTipoCambioPagoEspecial() != null ? new java.math.BigDecimal(dto.getTipoCambioPagoEspecial()) : null);
        entity.setMotivoCancelacion(dto.getMotivoCancelacion());
        entity.setMotivoSustitucion(dto.getMotivoSustitucion());
        entity.setMotivoNc(dto.getMotivoNc());
        entity.setCm(dto.getCm() != null ? new java.math.BigDecimal(dto.getCm()) : null);
        entity.setCostoxcm(dto.getCostoXcm() != null ? new java.math.BigDecimal(dto.getCostoXcm()) : null);
        try {
            entity.setFechaVencimiento(dto.getFechaVencimiento() != null ? dateFormat.parse(dto.getFechaVencimiento()) : null);
        } catch (Exception e) {
            entity.setFechaVencimiento(null);
        }
        entity.setNumFolioFacturaNd(dto.getNumFolioFacturaNd() != null ? Long.valueOf(dto.getNumFolioFacturaNd()) : null);
        entity.setNumFolioFeFacturaNd(dto.getNumFolioFeFacturaNd());
        entity.setMotivoCancelacionSat(dto.getMotivoCancelacionSat());
        entity.setFolioFiscalSat(dto.getFolioFiscalSat());
        entity.setCfdiPagoCanceladoVirtual(dto.getCfdiPagoCanceladoVirtual());
        try {
            entity.setCfdiPagoCanceladoVirtualFecha(dto.getCfdiPagoCanceladoVirtualFecha() != null ? dateFormat.parse(dto.getCfdiPagoCanceladoVirtualFecha()) : null);
        } catch (Exception e) {
            entity.setCfdiPagoCanceladoVirtualFecha(null);
        }
        entity.setExportacion(dto.getExportacion());
        entity.setPeriodicidad(dto.getPeriodicidad());
        entity.setMeses(dto.getMeses());
        entity.setAnio(dto.getAnio());
        entity.setVersion(dto.getVersion());
        entity.setObjetoimp(dto.getObjetoImp());
        entity.setRfcacuentaterceros(dto.getRfcACuentaTerceros());
        entity.setNombreacuentaterceros(dto.getNombreACuentaTerceros());
        entity.setRegimenfiscalacuentaterceros(dto.getRegimenFiscalACuentaTerceros());
        entity.setDomiciliofiscalacuentaterceros(dto.getDomicilioFiscalACuentaTerceros());
        entity.setObjetoimpdr(dto.getObjetoImpDr());
        try {
            entity.setFechaAutorizado(dto.getFechaAutorizado() != null ? dateFormat.parse(dto.getFechaAutorizado()) : null);
        } catch (Exception e) {
            entity.setFechaAutorizado(null);
        }

        return entity;
    }
}
