package com.quantumgear.envios.service;

import com.quantumgear.envios.repository.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.quantumgear.envios.model.Transporte;

import java.util.List;

@Service
@Transactional

public class TransporteService {
    @Autowired
    private TransporteRepository transporteRepository;

    public List<Transporte> findAll() {
        return transporteRepository.findAll();
    }

    public Transporte save(Transporte transporte) {
        return transporteRepository.save(transporte);
    }

    public Transporte findById(long id) {
        return transporteRepository.findById(id).orElseThrow();
    }

    public void delete(long id) {
        transporteRepository.deleteById(id);
    }
}
