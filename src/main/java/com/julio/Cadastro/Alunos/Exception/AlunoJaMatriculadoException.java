package com.julio.Cadastro.Alunos.Exception;

public class AlunoJaMatriculadoException extends RuntimeException{

    //Quando tentam matricular um aluno já matriculado
    private final String nome;

    public  AlunoJaMatriculadoException(String nome){
        super("O aluno " +nome + " já está matriculado.");
        this.nome = nome;
    }

    public String getTitulo(){
        return nome;
    }

}