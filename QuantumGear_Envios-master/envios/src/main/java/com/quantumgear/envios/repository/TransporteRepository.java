package com.quantumgear.envios.repository;

import com.quantumgear.envios.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long>{

    @Query(value = "SELECT * FROM transporte", nativeQuery = true)
    List<Transporte> findAll();

    @Query(value = "SELECT * FROM transporte WHERE tipo = :tipo", nativeQuery = true)
    List<Transporte> findByTipo(@Param("tipo") String tipo);

    @Query(value = "SELECT * FROM transporte WHERE patente = :patente", nativeQuery = true)
    Transporte findByPatente(@Param("patente") String patente);

    @Query(value = "DELETE FROM transporte WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);

}
