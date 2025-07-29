package com.cxc.api.repository;

import com.cxc.api.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

    // Buscar por ID de compañía
    Page<Cliente> findByIdCompania(Long idCompania, Pageable pageable);

    // Buscar por nombre o razón social (búsqueda parcial)
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "(LOWER(c.nombreRazonSocial) LIKE LOWER(CONCAT('%', :nombre, '%')) OR " +
           "LOWER(c.nombreComercial) LIKE LOWER(CONCAT('%', :nombre, '%')))")
    Page<Cliente> findByNombreContainingAndIdCompania(
            @Param("nombre") String nombre, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Buscar por RFC
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "LOWER(c.rfc) LIKE LOWER(CONCAT('%', :rfc, '%'))")
    Page<Cliente> findByRfcContainingAndIdCompania(
            @Param("rfc") String rfc, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Buscar por referencia
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "LOWER(c.referencia) LIKE LOWER(CONCAT('%', :referencia, '%'))")
    Page<Cliente> findByReferenciaContainingAndIdCompania(
            @Param("referencia") String referencia, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Buscar por email
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%'))")
    Page<Cliente> findByEmailContainingAndIdCompania(
            @Param("email") String email, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Buscar por clasificación
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "LOWER(c.clasificacion) LIKE LOWER(CONCAT('%', :clasificacion, '%'))")
    Page<Cliente> findByClasificacionContainingAndIdCompania(
            @Param("clasificacion") String clasificacion, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Buscar por grupo
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "LOWER(c.grupo) LIKE LOWER(CONCAT('%', :grupo, '%'))")
    Page<Cliente> findByGrupoContainingAndIdCompania(
            @Param("grupo") String grupo, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Buscar por cobrador
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "LOWER(c.cobrador) LIKE LOWER(CONCAT('%', :cobrador, '%'))")
    Page<Cliente> findByCobradorContainingAndIdCompania(
            @Param("cobrador") String cobrador, 
            @Param("idCompania") Long idCompania, 
            Pageable pageable);

    // Búsqueda general con múltiples criterios
    @Query("SELECT c FROM Cliente c WHERE c.idCompania = :idCompania AND " +
           "(:nombre IS NULL OR LOWER(c.nombreRazonSocial) LIKE LOWER(CONCAT('%', :nombre, '%')) OR " +
           "LOWER(c.nombreComercial) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
           "(:rfc IS NULL OR LOWER(c.rfc) LIKE LOWER(CONCAT('%', :rfc, '%'))) AND " +
           "(:referencia IS NULL OR LOWER(c.referencia) LIKE LOWER(CONCAT('%', :referencia, '%'))) AND " +
           "(:clasificacion IS NULL OR LOWER(c.clasificacion) LIKE LOWER(CONCAT('%', :clasificacion, '%'))) AND " +
           "(:grupo IS NULL OR LOWER(c.grupo) LIKE LOWER(CONCAT('%', :grupo, '%')))")
    Page<Cliente> findByMultipleCriteria(
            @Param("idCompania") Long idCompania,
            @Param("nombre") String nombre,
            @Param("rfc") String rfc,
            @Param("referencia") String referencia,
            @Param("clasificacion") String clasificacion,
            @Param("grupo") String grupo,
            Pageable pageable);

    // Buscar cliente específico por ID y compañía
    Optional<Cliente> findByIdClienteAndIdCompania(Long idCliente, Long idCompania);

    // Contar clientes por compañía
    long countByIdCompania(Long idCompania);

    // Obtener clasificaciones únicas por compañía
    @Query("SELECT DISTINCT c.clasificacion FROM Cliente c WHERE c.idCompania = :idCompania AND c.clasificacion IS NOT NULL")
    List<String> findDistinctClasificacionesByIdCompania(@Param("idCompania") Long idCompania);

    // Obtener grupos únicos por compañía
    @Query("SELECT DISTINCT c.grupo FROM Cliente c WHERE c.idCompania = :idCompania AND c.grupo IS NOT NULL")
    List<String> findDistinctGruposByIdCompania(@Param("idCompania") Long idCompania);

    // Obtener cobradores únicos por compañía
    @Query("SELECT DISTINCT c.cobrador FROM Cliente c WHERE c.idCompania = :idCompania AND c.cobrador IS NOT NULL")
    List<String> findDistinctCobradoresByIdCompania(@Param("idCompania") Long idCompania);
} 