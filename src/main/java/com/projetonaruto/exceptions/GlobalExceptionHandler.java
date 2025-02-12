package com.projetonaruto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonagemNaoENinjaException.class)
    public ResponseEntity<Object> handlePersonagemNaoGuerreiroExcepition(PersonagemNaoENinjaException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(PersonagemNaoCadastradoExcepition.class)
    public ResponseEntity<Object> handlePersonagemNaoExisteExcepition(PersonagemNaoCadastradoExcepition ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

   @ExceptionHandler(JutsuInvalidoException.class)
    public ResponseEntity<Object> handleJutsuInexistenteExcepition(JutsuInvalidoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(JogadorEmAtaqueException.class)
    public ResponseEntity<Object> handleJogadorEmAtaqueException(JogadorEmAtaqueException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(JogoInvalidoException.class)
    public ResponseEntity<Object> handleJogoInvalidoException(JogoInvalidoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(PersonagemJaCadastradoException.class)
    public ResponseEntity<Object> handlePersonagemJaExistenteExcepition(PersonagemJaCadastradoException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(PersonagemNaoEstaJogandoExcepition.class)
    public ResponseEntity<Object> handlePersonagemNaoEstaJogandoExcepition(PersonagemNaoEstaJogandoExcepition ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(JogadorForaDaVezException.class)
    public ResponseEntity<Object> handleJogadorInvalidoException(JogadorForaDaVezException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(ChakrasInsuficientesException.class)
    public ResponseEntity<Object> handleChakrasInsuficientesException(ChakrasInsuficientesException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    static class ErrorResponse {
        private String tipoErro;
        private String mensagem;

        public ErrorResponse(String tipoErro, String mensagem) {
            this.tipoErro = tipoErro;
            this.mensagem = mensagem;
        }

        public String getTipoErro() {
            return tipoErro;
        }

        public String getMensagem() {
            return mensagem;
        }
    }
}