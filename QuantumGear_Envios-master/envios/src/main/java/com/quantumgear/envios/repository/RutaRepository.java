package com.quantumgear.envios.repository;

import com.quantumgear.envios.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository


public interface RutaRepository  extends JpaRepository<Ruta, Long> {
    @Query(value = "SELECT * FROM Ruta", nativeQuery = true)
    List<Ruta> findAll();

    @Query(value = "SELECT * FROM Ruta WHERE origen = :origen", nativeQuery = true)
    List<Ruta> findByOrigen(@Param("origen") String origen);

    @Query(value = "SELECT * FROM Ruta WHERE destino = :destino", nativeQuery = true)
    List<Ruta> findByDestino(@Param("destino") String destino);

    @Query(value = "DELETE FROM Ruta WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);
}
