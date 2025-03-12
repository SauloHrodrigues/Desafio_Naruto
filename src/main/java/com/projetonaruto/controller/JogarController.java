package com.projetonaruto.controller;

import com.projetonaruto.service.IJogarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/jogar")
public class JogarController {

    @Autowired
    private IJogarService service;

    @PostMapping("/{ninja}/{oponente}/novojogo")
    public ResponseEntity<String> novoJogo(@PathVariable String ninja, @PathVariable String oponente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.novoJogo(ninja, oponente));
    }

    @GetMapping("/{nomeDoNinja}/{nomeDoJutsu}/usarjutsu")
    public ResponseEntity<String> usarJutsu(@PathVariable(required = false) String nomeDoNinja, @PathVariable String nomeDoJutsu) {
        return ResponseEntity.status(HttpStatus.OK).body(service.usarJutsu(nomeDoNinja, nomeDoJutsu));
    }

    @GetMapping("/desviar")
    public ResponseEntity<String> desviar() {
        return ResponseEntity.status(HttpStatus.OK).body(service.desviar());
    }

}
