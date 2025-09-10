package com.julio.Cadastro.Alunos.Exception;

public class AlunoNaoMatriculadoException extends RuntimeException{

    //Quando tentam cancelar a matricula de um aluno já cancelado
    private final String nome;

    public  AlunoNaoMatriculadoException(String nome){
        super("O matricula do aluno " +nome + " já está cancelada.");
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

}
