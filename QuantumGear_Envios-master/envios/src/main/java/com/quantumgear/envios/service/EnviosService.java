package com.quantumgear.envios.service;

import com.quantumgear.envios.model.Envios;
import com.quantumgear.envios.repository.EnviosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional

public class EnviosService {
    @Autowired
    private EnviosRepository enviosRepository;

    public List<Envios> findAll() {
        return enviosRepository.findAll();
    }

    public Envios save(Envios envio) {
        return enviosRepository.save(envio);
    }

    public Envios findById(Long id) {
        return enviosRepository.findById(id).orElseThrow(() -> new RuntimeException("Envío no encontrado"));
    }

    public void delete(Long id) {
        enviosRepository.deleteById(id);
    }
}
