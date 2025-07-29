package com.cxc.api.service;

import com.cxc.api.dto.ClienteDTO;
import com.cxc.api.dto.ClienteDetalleDTO;
import com.cxc.api.dto.PaginatedResponseDTO;
import com.cxc.api.entity.Cliente;
import com.cxc.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Obtiene todos los clientes paginados por compañía
     */
    public PaginatedResponseDTO<ClienteDTO> obtenerClientes(Long idCompania, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByIdCompania(idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por nombre o razón social
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorNombre(Long idCompania, String nombre, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByNombreContainingAndIdCompania(nombre, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por RFC
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorRfc(Long idCompania, String rfc, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByRfcContainingAndIdCompania(rfc, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por referencia
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorReferencia(Long idCompania, String referencia, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByReferenciaContainingAndIdCompania(referencia, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por email
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorEmail(Long idCompania, String email, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByEmailContainingAndIdCompania(email, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por clasificación
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorClasificacion(Long idCompania, String clasificacion, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByClasificacionContainingAndIdCompania(clasificacion, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por grupo
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorGrupo(Long idCompania, String grupo, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByGrupoContainingAndIdCompania(grupo, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Busca clientes por cobrador
     */
    public PaginatedResponseDTO<ClienteDTO> buscarPorCobrador(Long idCompania, String cobrador, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByCobradorContainingAndIdCompania(cobrador, idCompania, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Búsqueda avanzada con múltiples criterios
     */
    public PaginatedResponseDTO<ClienteDTO> buscarAvanzado(Long idCompania, String nombre, String rfc, String referencia, 
                                                          String clasificacion, String grupo, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Cliente> clientesPage = clienteRepository.findByMultipleCriteria(idCompania, nombre, rfc, referencia, clasificacion, grupo, pageable);
        
        return buildPaginatedResponse(clientesPage, this::convertToDTO);
    }

    /**
     * Obtiene un cliente específico por ID y compañía
     */
    public Optional<ClienteDetalleDTO> obtenerClientePorId(Long idCliente, Long idCompania) {
        Optional<Cliente> cliente = clienteRepository.findByIdClienteAndIdCompania(idCliente, idCompania);
        return cliente.map(this::convertToDetalleDTO);
    }

    /**
     * Obtiene estadísticas de clientes por compañía
     */
    public long contarClientes(Long idCompania) {
        try {
            return clienteRepository.countByIdCompania(idCompania);
        } catch (Exception e) {
            // Si hay error, retornar 0
            return 0L;
        }
    }

    /**
     * Obtiene clasificaciones únicas por compañía
     */
    public List<String> obtenerClasificaciones(Long idCompania) {
        return clienteRepository.findDistinctClasificacionesByIdCompania(idCompania);
    }

    /**
     * Obtiene grupos únicos por compañía
     */
    public List<String> obtenerGrupos(Long idCompania) {
        return clienteRepository.findDistinctGruposByIdCompania(idCompania);
    }

    /**
     * Obtiene cobradores únicos por compañía
     */
    public List<String> obtenerCobradores(Long idCompania) {
        return clienteRepository.findDistinctCobradoresByIdCompania(idCompania);
    }

    // Métodos privados de conversión
    private ClienteDTO convertToDTO(Cliente cliente) {
        return new ClienteDTO(
            cliente.getIdCliente(),
            cliente.getReferencia(),
            cliente.getNombreRazonSocial(),
            cliente.getNombreComercial(),
            cliente.getRfc(),
            cliente.getEmail(),
            cliente.getTelefono(),
            cliente.getDomicilio(),
            cliente.getCalle(),
            cliente.getNoExterior(),
            cliente.getNoInterior(),
            cliente.getColonia(),
            cliente.getMunicipio(),
            cliente.getEstado(),
            cliente.getCp(),
            cliente.getPais(),
            cliente.getClasificacion(),
            cliente.getGrupo(),
            cliente.getCobrador(),
            cliente.getMetodoPago(),
            cliente.getPorcIsr(),
            cliente.getPorcIva(),
            cliente.getPorcIeps(),
            cliente.getCriterioImpuestos(),
            cliente.getFacturasSeparadas(),
            cliente.getIdCompania()
        );
    }

    private ClienteDetalleDTO convertToDetalleDTO(Cliente cliente) {
        return new ClienteDetalleDTO(
            cliente.getIdCliente(),
            cliente.getReferencia(),
            cliente.getNombreRazonSocial(),
            cliente.getNombreComercial(),
            cliente.getContratanteMoral(),
            cliente.getCedulaIdentificacion(),
            cliente.getIfeContratante(),
            cliente.getRegimenContratante(),
            cliente.getDomicNotifiContratante(),
            cliente.getOcupacionContratante(),
            cliente.getRfc(),
            cliente.getEdoCivilContratante(),
            cliente.getOriginarioDe(),
            cliente.getDomicilio(),
            cliente.getNotificacionesContratante(),
            cliente.getTelefono(),
            cliente.getCriterioImpuestos(),
            cliente.getIdCompania(),
            cliente.getCalle(),
            cliente.getNoExterior(),
            cliente.getNoInterior(),
            cliente.getColonia(),
            cliente.getMunicipio(),
            cliente.getEstado(),
            cliente.getPais(),
            cliente.getNacionalidadContratante(),
            cliente.getCp(),
            cliente.getEmail(),
            cliente.getLocalidad(),
            cliente.getFacturasSeparadas(),
            cliente.getClasificacion(),
            cliente.getGrupo(),
            cliente.getCobrador(),
            cliente.getObligadoSolidario(),
            cliente.getNacObligadoSolidario(),
            cliente.getEdoCivilObligadoSolidario(),
            cliente.getDomObligadoSolidario(),
            cliente.getIfeObligadoSolidario(),
            cliente.getDomNotiObligadoSolidario(),
            cliente.getOriginarioObligadoSolidario(),
            cliente.getGarantiaObligadoSolidario(),
            cliente.getPorcIsr(),
            cliente.getPorcIva(),
            cliente.getCedulaIdentificacionObligado(),
            cliente.getTipoIngreso(),
            cliente.getClasificacionAnt(),
            cliente.getMetodoPago(),
            cliente.getNoCuentaBanco(),
            cliente.getMetodoPagoSat(),
            cliente.getFormaPagoSat(),
            cliente.getUsoCfdiSat(),
            cliente.getPorcIeps(),
            cliente.getNumRegIdTrib(),
            cliente.getResidenciaFiscal(),
            cliente.getEmailCc(),
            cliente.getEmailRevision(),
            cliente.getSistemaFeraz(),
            cliente.getServicioFeraz(),
            cliente.getNotasFeraz(),
            cliente.getVendedor(),
            cliente.getErpCuenta(),
            cliente.getErpCuentaComplementaria(),
            cliente.getIdMoneda(),
            cliente.getDomicilioFiscalReceptor(),
            cliente.getRegimenFiscalReceptor(),
            cliente.getObjetoImp(),
            cliente.getRegimenCapital(),
            cliente.getEmailComplementos(),
            cliente.getAgregarConcepto()
        );
    }

    private <T> PaginatedResponseDTO<T> buildPaginatedResponse(Page<Cliente> page, java.util.function.Function<Cliente, T> converter) {
        List<T> content = page.getContent().stream()
                .map(converter)
                .collect(Collectors.toList());

        return new PaginatedResponseDTO<>(
            content,
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.hasNext(),
            page.hasPrevious(),
            page.isFirst(),
            page.isLast()
        );
    }
} 