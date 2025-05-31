package com.quantumgear.envios.controller;

import com.quantumgear.envios.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quantumgear.envios.model.Envios;

import java.util.List;

@RestController
@RequestMapping("/api/v1/envios")

public class EnviosController {

    @Autowired
    private EnviosService envioService;

    @GetMapping
    public ResponseEntity<List<Envios>> listar() {
        List<Envios> envios = envioService.findAll();
        if (envios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(envios);
    }

    @PostMapping
    public ResponseEntity<Envios> guardar(@RequestBody Envios envio) {
        Envios nuevoEnvio = envioService.save(envio);
        return new ResponseEntity<>(nuevoEnvio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envios> buscar(@PathVariable Long id) {
        try {
            Envios envio = envioService.findById(id);
            return new ResponseEntity<>(envio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envios> actualizar(@PathVariable Long id, @RequestBody Envios envio) {
        try {
            Envios envioExistente = envioService.findById(id);

            envioExistente.setDestino(envio.getDestino());
            envioExistente.setEstado(envio.getEstado());
            envioExistente.setTransportista(envio.getTransportista());

            envioService.save(envioExistente);
            return new ResponseEntity<>(envioExistente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            envioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
