package com.cxc.api.service;

import com.cxc.api.converter.ClienteMovimientosConverter;
import com.cxc.api.dto.ClienteMovimientosDto;
import com.cxc.api.dto.PaginatedResponseDTO;
import com.cxc.api.entity.ClienteMovimientos;
import com.cxc.api.repository.ClienteMovimientosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class ClienteMovimientosService {

    @Autowired
    private ClienteMovimientosRepository movimientosRepository;

    public PaginatedResponseDTO<ClienteMovimientosDto> obtenerPorIdMovimiento(Long idMovimiento, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<ClienteMovimientos> pageResult = movimientosRepository.findByIdMovimiento(idMovimiento, pageable);

        return buildPaginatedResponse(pageResult, ClienteMovimientosConverter::toDto);
    }

    private <T, U> PaginatedResponseDTO<U> buildPaginatedResponse(Page<T> page, Function<T, U> converter) {
        List<U> dtoList = page.stream()
                             .map(converter)
                             .collect(Collectors.toList());

        PaginatedResponseDTO<U> response = new PaginatedResponseDTO<>();
        response.setContent(dtoList);
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return response;
    }
}
