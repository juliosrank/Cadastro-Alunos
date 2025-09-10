package com.julio.Cadastro.Alunos.Repository;


import com.julio.Cadastro.Alunos.Model.Aluno;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AlunoRepository {


    public List<Aluno> listaDeAlunos = new ArrayList<>(
            List.of(
                    new Aluno(1, "Julio", 31, false),
                    new Aluno(2, "Maria", 16, true)
            )
    );

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }
}
