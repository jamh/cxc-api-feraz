package com.cxc.api.controller;

import com.cxc.api.dto.ClienteDTO;
import com.cxc.api.dto.ClienteDetalleDTO;
import com.cxc.api.dto.PaginatedResponseDTO;
import com.cxc.api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Consulta de Clientes", description = "API para consulta de clientes en el sistema CXC (solo lectura)")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{idCompania}")
    @Operation(
        summary = "Obtener clientes paginados",
        description = "Retorna una lista paginada de todos los clientes de una compañía específica"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes encontrados exitosamente",
            content = @Content(schema = @Schema(implementation = PaginatedResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parámetros de paginación inválidos"),
        @ApiResponse(responseCode = "404", description = "Compañía no encontrada")
    })
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> obtenerClientes(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Número de página (0-based)", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "nombreRazonSocial")
            @RequestParam(defaultValue = "nombreRazonSocial") String sortBy,
            @Parameter(description = "Dirección del ordenamiento (ASC/DESC)", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.obtenerClientes(idCompania, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/nombre")
    @Operation(
        summary = "Buscar clientes por nombre",
        description = "Busca clientes por nombre o razón social (búsqueda parcial)"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Parámetros de búsqueda inválidos")
    })
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorNombre(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Nombre a buscar", required = true, example = "Juan")
            @RequestParam String nombre,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "nombreRazonSocial")
            @RequestParam(defaultValue = "nombreRazonSocial") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorNombre(idCompania, nombre, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/rfc")
    @Operation(
        summary = "Buscar clientes por RFC",
        description = "Busca clientes por RFC (búsqueda parcial)"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorRfc(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "RFC a buscar", required = true, example = "XAXX")
            @RequestParam String rfc,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "rfc")
            @RequestParam(defaultValue = "rfc") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorRfc(idCompania, rfc, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/referencia")
    @Operation(
        summary = "Buscar clientes por referencia",
        description = "Busca clientes por referencia (búsqueda parcial)"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorReferencia(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Referencia a buscar", required = true, example = "REF001")
            @RequestParam String referencia,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "referencia")
            @RequestParam(defaultValue = "referencia") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorReferencia(idCompania, referencia, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/email")
    @Operation(
        summary = "Buscar clientes por email",
        description = "Busca clientes por email (búsqueda parcial)"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorEmail(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Email a buscar", required = true, example = "cliente@ejemplo.com")
            @RequestParam String email,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "email")
            @RequestParam(defaultValue = "email") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorEmail(idCompania, email, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/clasificacion")
    @Operation(
        summary = "Buscar clientes por clasificación",
        description = "Busca clientes por clasificación (búsqueda parcial)"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorClasificacion(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Clasificación a buscar", required = true, example = "Premium")
            @RequestParam String clasificacion,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "clasificacion")
            @RequestParam(defaultValue = "clasificacion") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorClasificacion(idCompania, clasificacion, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/grupo")
    @Operation(
        summary = "Buscar clientes por grupo",
        description = "Busca clientes por grupo (búsqueda parcial)"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorGrupo(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Grupo a buscar", required = true, example = "Grupo A")
            @RequestParam String grupo,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "grupo")
            @RequestParam(defaultValue = "grupo") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorGrupo(idCompania, grupo, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/cobrador")
    @Operation(
        summary = "Buscar clientes por cobrador",
        description = "Busca clientes por cobrador (búsqueda parcial)"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarPorCobrador(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Cobrador a buscar", required = true, example = "Juan Pérez")
            @RequestParam String cobrador,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "cobrador")
            @RequestParam(defaultValue = "cobrador") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarPorCobrador(idCompania, cobrador, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/buscar/avanzado")
    @Operation(
        summary = "Búsqueda avanzada de clientes",
        description = "Busca clientes con múltiples criterios de búsqueda"
    )
    public ResponseEntity<PaginatedResponseDTO<ClienteDTO>> buscarAvanzado(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "Nombre a buscar", example = "Juan")
            @RequestParam(required = false) String nombre,
            @Parameter(description = "RFC a buscar", example = "XAXX")
            @RequestParam(required = false) String rfc,
            @Parameter(description = "Referencia a buscar", example = "REF001")
            @RequestParam(required = false) String referencia,
            @Parameter(description = "Clasificación a buscar", example = "Premium")
            @RequestParam(required = false) String clasificacion,
            @Parameter(description = "Grupo a buscar", example = "Grupo A")
            @RequestParam(required = false) String grupo,
            @Parameter(description = "Número de página", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamaño de la página", example = "20")
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "Campo por el cual ordenar", example = "nombreRazonSocial")
            @RequestParam(defaultValue = "nombreRazonSocial") String sortBy,
            @Parameter(description = "Dirección del ordenamiento", example = "ASC")
            @RequestParam(defaultValue = "ASC") String sortDir) {
        
        PaginatedResponseDTO<ClienteDTO> response = clienteService.buscarAvanzado(idCompania, nombre, rfc, referencia, clasificacion, grupo, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCompania}/{idCliente}")
    @Operation(
        summary = "Obtener cliente por ID",
        description = "Retorna la información detallada de un cliente específico"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado exitosamente",
            content = @Content(schema = @Schema(implementation = ClienteDetalleDTO.class))),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    public ResponseEntity<ClienteDetalleDTO> obtenerClientePorId(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania,
            @Parameter(description = "ID del cliente", required = true, example = "123")
            @PathVariable Long idCliente) {
        
        return clienteService.obtenerClientePorId(idCliente, idCompania)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{idCompania}/estadisticas/total")
    @Operation(
        summary = "Obtener total de clientes",
        description = "Retorna el número total de clientes de una compañía"
    )
    public ResponseEntity<Long> obtenerTotalClientes(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania) {
        
        long total = clienteService.contarClientes(idCompania);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/{idCompania}/catalogos/clasificaciones")
    @Operation(
        summary = "Obtener clasificaciones disponibles",
        description = "Retorna la lista de clasificaciones únicas disponibles para una compañía"
    )
    public ResponseEntity<List<String>> obtenerClasificaciones(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania) {
        
        List<String> clasificaciones = clienteService.obtenerClasificaciones(idCompania);
        return ResponseEntity.ok(clasificaciones);
    }

    @GetMapping("/{idCompania}/catalogos/grupos")
    @Operation(
        summary = "Obtener grupos disponibles",
        description = "Retorna la lista de grupos únicos disponibles para una compañía"
    )
    public ResponseEntity<List<String>> obtenerGrupos(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania) {
        
        List<String> grupos = clienteService.obtenerGrupos(idCompania);
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{idCompania}/catalogos/cobradores")
    @Operation(
        summary = "Obtener cobradores disponibles",
        description = "Retorna la lista de cobradores únicos disponibles para una compañía"
    )
    public ResponseEntity<List<String>> obtenerCobradores(
            @Parameter(description = "ID de la compañía", required = true, example = "1")
            @PathVariable Long idCompania) {
        
        List<String> cobradores = clienteService.obtenerCobradores(idCompania);
        return ResponseEntity.ok(cobradores);
    }
} 