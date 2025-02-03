package com.projetonaruto.controller;

import com.projetonaruto.service.IJogarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/jogar")
public class JogarController {

    @Autowired
    private IJogarService service;
    @PostMapping("/{ninja}/{oponente}/novojogo")
    public ResponseEntity<String> novoJogo(@RequestParam String ninja, @RequestParam String oponente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.novoJogo(ninja,oponente));
    }

    @GetMapping("/{ninja}/{oponente}/{nomeDoJutsu}/usarjutsu")
    public ResponseEntity<String> usarJutsu(@RequestParam String ninja, @RequestParam String oponente, @RequestParam String nomeDoJutsu) {
        return ResponseEntity.status(HttpStatus.OK).body(service.usarJutsu(ninja, oponente, nomeDoJutsu));
    }

    @GetMapping("/{nome}/desviar")
    public ResponseEntity<String> desviar(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body("teste");
//    }

}
