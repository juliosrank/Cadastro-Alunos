package com.julio.Cadastro.Alunos.Exception;

public class AlunoNaoEncontradoException extends RuntimeException{

    //Quando o ID não existe.
    private final Integer id;

    public AlunoNaoEncontradoException(Integer id){
        super("O Aluno com ID " +id + " não foi encontrado.");
        this.id = id;
    }


    public  Integer getId(){
        return id;
    }
}