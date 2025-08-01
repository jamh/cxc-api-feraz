package com.cxc.api.repository;


import com.cxc.api.entity.ClienteMovimientos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteMovimientosRepository extends JpaRepository<ClienteMovimientos, Long> {
	
    Page<ClienteMovimientos> findByIdMovimiento(Long idMovimiento, Pageable pageable);
}
