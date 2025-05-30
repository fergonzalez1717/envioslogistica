package com.quantumgear.envios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quantumgear.envios.service.TransporteService;
import com.quantumgear.envios.model.Transporte;

import java.util.List;

@RestController
@RequestMapping

public class TransporteController {

    @Autowired
    private TransporteService transporteService;

    @GetMapping
    public ResponseEntity<List<Transporte>> listar() {
        List<Transporte> transportes = transporteService.findAll();
        if (transportes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(transportes);
    }

    @PostMapping
    public ResponseEntity<Transporte> guardar(@RequestBody Transporte transporte) {
        Transporte nuevoTransporte = transporteService.save(transporte);
        return new ResponseEntity<>(nuevoTransporte, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transporte> buscar(@PathVariable long id) {
        try {
            Transporte transporte = transporteService.findById(id);
            return new ResponseEntity<>(transporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transporte> actualizar(@PathVariable long id, @RequestBody Transporte transporte) {
        try {
            Transporte transporteExistente = transporteService.findById(id);

            transporteExistente.setTipo(transporte.getTipo());
            transporteExistente.setPatente(transporte.getPatente());
            transporteExistente.setNombreChofer(transporte.getNombreChofer());

            transporteService.save(transporteExistente);
            return new ResponseEntity<>(transporteExistente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id) {
        try {
            transporteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
