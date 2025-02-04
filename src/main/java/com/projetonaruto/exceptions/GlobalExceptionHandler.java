package com.projetonaruto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonagemNaoNinjaException.class)
    public ResponseEntity<Object> handlePersonagemNaoGuerreiroExcepition(PersonagemNaoNinjaException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // ou outro status HTTP adequado
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }
    @ExceptionHandler(PersonagemNaoCadastradoExcepition.class)
    public ResponseEntity<Object> handlePersonagemNaoExisteExcepition(PersonagemNaoCadastradoExcepition ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // ou outro status HTTP adequado
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }
   @ExceptionHandler(JutsuInvalidoException.class)
    public ResponseEntity<Object> handleJutsuInexistenteExcepition(JutsuInvalidoException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // ou outro status HTTP adequado
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }
    @ExceptionHandler(PersonagemJaCadastradoException.class)
    public ResponseEntity<Object> handlePersonagemJaExistenteExcepition(PersonagemJaCadastradoException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // ou outro status HTTP adequado
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    @ExceptionHandler(ChakrasInsuficientesException.class)
    public ResponseEntity<Object> handleChakrasInsuficientesException(ChakrasInsuficientesException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // ou outro status HTTP adequado
                .body(new ErrorResponse("Erro", ex.getMessage()));
    }

    // Classe para representar a resposta do erro
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