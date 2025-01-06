package com.projetonaruto.controller;

import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.service.SenviceInterface;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/personagem")
public class PersonagensNarutoController {

    @Autowired
    private SenviceInterface service;

    @PostMapping
    public ResponseEntity<Personagem> cadastrar(@RequestBody NovoPersonagemDto novoPersonagem){
        Personagem novoPersonagemCriado = service.novoPersonagem(novoPersonagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPersonagemCriado);
    }

    @GetMapping()
    public ResponseEntity<Map<String, Personagem>> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body((Map<String, Personagem>) service.buscar());
    }
    @GetMapping("/usarjutsu/{nome}")
    public ResponseEntity<String> usarJutsu(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(service.usarJutsu(nome));
    }
    @GetMapping("/desviar/{nome}")
    public ResponseEntity<String> desviar(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(service.desviar(nome));
    }

}