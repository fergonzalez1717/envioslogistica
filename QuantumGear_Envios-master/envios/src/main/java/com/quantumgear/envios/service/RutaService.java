package com.quantumgear.envios.service;

import com.quantumgear.envios.model.Ruta;
import com.quantumgear.envios.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    public Ruta save(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public Ruta findById(Long id) {
        return rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada con id: " + id));
    }

    public void delete(Long id) {
        rutaRepository.deleteById(id.intValue()); // usando la query nativa
    }

    public List<Ruta> findByOrigen(String origen) {
        return rutaRepository.findByOrigen(origen);
    }

    public List<Ruta> findByDestino(String destino) {
        return rutaRepository.findByDestino(destino);
    }
}
