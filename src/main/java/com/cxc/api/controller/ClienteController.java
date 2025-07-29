package com.cxc.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Gestión de Clientes", description = "API para la gestión de clientes en el sistema CXC")
public class ClienteController {

    @GetMapping
    @Operation(
        summary = "Obtener todos los clientes",
        description = "Retorna una lista de todos los clientes registrados en el sistema"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes encontrados exitosamente",
            content = @Content(schema = @Schema(implementation = Map.class))),
        @ApiResponse(responseCode = "404", description = "No se encontraron clientes"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Map<String, Object>> obtenerClientes() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Lista de clientes");
        response.put("total", 0);
        response.put("clientes", new Object[]{});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Obtener cliente por ID",
        description = "Retorna la información de un cliente específico por su ID"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Map<String, Object>> obtenerClientePorId(
            @Parameter(description = "ID del cliente", required = true, example = "1")
            @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("nombre", "Cliente Ejemplo");
        response.put("email", "cliente@ejemplo.com");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(
        summary = "Crear nuevo cliente",
        description = "Crea un nuevo cliente en el sistema"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Map<String, Object>> crearCliente(
            @Parameter(description = "Datos del cliente", required = true)
            @RequestBody Map<String, Object> cliente) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Cliente creado exitosamente");
        response.put("id", 1);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar cliente",
        description = "Actualiza la información de un cliente existente"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<Map<String, Object>> actualizarCliente(
            @Parameter(description = "ID del cliente", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "Datos actualizados del cliente", required = true)
            @RequestBody Map<String, Object> cliente) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Cliente actualizado exitosamente");
        response.put("id", id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar cliente",
        description = "Elimina un cliente del sistema"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    public ResponseEntity<Map<String, Object>> eliminarCliente(
            @Parameter(description = "ID del cliente", required = true, example = "1")
            @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Cliente eliminado exitosamente");
        response.put("id", id);
        return ResponseEntity.ok(response);
    }
} 