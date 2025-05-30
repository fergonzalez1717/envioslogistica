package com.quantumgear.envios.repository;

import com.quantumgear.envios.model.Envios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnviosRepository extends JpaRepository<Envios, Long>{

    @Query(value = "SELECT * FROM envios", nativeQuery = true)
    List<Envios> findAll();

    @Query(value = "SELECT * FROM envios WHERE destino = :destino", nativeQuery = true)
    List<Envios> findByDestino(@Param("destino") String destino);

    @Query(value = "SELECT * FROM envios WHERE estado = :estado", nativeQuery = true)
    List<Envios> findByEstado(@Param("estado") String estado);

    @Query(value = "DELETE FROM envios WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);
}
