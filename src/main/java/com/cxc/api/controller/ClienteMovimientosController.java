package com.cxc.api.controller;

import com.cxc.api.dto.ClienteMovimientosDto;
import com.cxc.api.dto.PaginatedResponseDTO;
import com.cxc.api.service.ClienteMovimientosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class ClienteMovimientosController {

    private final ClienteMovimientosService movimientosService;

    public ClienteMovimientosController(ClienteMovimientosService movimientosService) {
        this.movimientosService = movimientosService;
    }

  
    @GetMapping("/por-id-movimiento/{idMovimiento}")
    public ResponseEntity<PaginatedResponseDTO<ClienteMovimientosDto>> obtenerPorIdMovimiento(
        @PathVariable("idMovimiento") Long idMovimiento,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "20") int size,
        @RequestParam(name = "sortBy", defaultValue = "fecha") String sortBy,
        @RequestParam(name = "sortDir", defaultValue = "ASC") String sortDir) {

        PaginatedResponseDTO<ClienteMovimientosDto> response = movimientosService.obtenerPorIdMovimiento(idMovimiento, page, size, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }


    }


