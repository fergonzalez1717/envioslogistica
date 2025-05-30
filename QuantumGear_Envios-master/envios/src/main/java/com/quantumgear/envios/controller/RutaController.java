package com.quantumgear.envios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quantumgear.envios.service.RutaService;
import com.quantumgear.envios.model.Ruta;

import java.util.List;
@RestController
@RequestMapping

public class RutaController {
    @Autowired
    private RutaService rutaService;

    @GetMapping
    public ResponseEntity<List<Ruta>> listar() {
        List<Ruta> ruta = rutaService.findAll();
        if (ruta.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(ruta);
    }

    @PostMapping
    public ResponseEntity<Ruta> guardar(@RequestBody Ruta ruta) {
        Ruta nuevaRuta = rutaService.save(ruta);
        return new ResponseEntity<>(nuevaRuta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> buscar(@PathVariable long id) {
        try {
            Ruta ruta = rutaService.findById(id);
            return new ResponseEntity<>(ruta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruta> actualizar(@PathVariable long id, @RequestBody Ruta ruta) {
        try {
            Ruta rutaExistente = rutaService.findById(id);

            rutaExistente.setOrigen(ruta.getOrigen());
            rutaExistente.setDestino(ruta.getDestino());
            rutaExistente.setDuracionEstimada(ruta.getDuracionEstimada());

            rutaService.save(rutaExistente);
            return new ResponseEntity<>(rutaExistente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id) {
        try {
            rutaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
