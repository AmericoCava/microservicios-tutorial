package com.app.moto.service.controller;

import com.app.moto.service.entity.Moto;
import com.app.moto.service.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarCarros() {
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerCarroPorId(@PathVariable("id") int id) {
        Moto moto = motoService.getMotoById(id);
        if (moto == null) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarCarro(@RequestBody Moto moto) {
        Moto nuevaMoto = motoService.save(moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarCarrosPorUusuarioId(@PathVariable("usuarioId") int usuarioId) {
        List<Moto> Motos = motoService.byUsuarioId(usuarioId);
        if (Motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Motos);
    }
}
