package com.julio.Cadastro.Alunos.Exception.Handler;

import com.julio.Cadastro.Alunos.Exception.AlunoJaMatriculadoException;
import com.julio.Cadastro.Alunos.Exception.AlunoNaoEncontradoException;
import com.julio.Cadastro.Alunos.Exception.AlunoNaoMatriculadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleAlunoNaoEncontrado(AlunoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        "Aluno não encontrado",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(AlunoJaMatriculadoException.class)
    public ResponseEntity<ErrorResponse> handleAlunoJaMatriculado(AlunoJaMatriculadoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "Aluno já matriculado",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(AlunoNaoMatriculadoException.class)
    public ResponseEntity<ErrorResponse> handleAlunoNaoMatriculado(AlunoNaoMatriculadoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "Aluno não está matriculado",
                        ex.getMessage()
                ));
    }
}
