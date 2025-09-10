package com.julio.Cadastro.Alunos.Service;

import com.julio.Cadastro.Alunos.Exception.AlunoJaMatriculadoException;
import com.julio.Cadastro.Alunos.Exception.AlunoNaoEncontradoException;
import com.julio.Cadastro.Alunos.Exception.AlunoNaoMatriculadoException;
import com.julio.Cadastro.Alunos.Model.Aluno;
import com.julio.Cadastro.Alunos.Repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {


    private final AlunoRepository repo;

    //Listar todos os alunos
    public List<Aluno> listarAlunos(){
        return repo.getListaDeAlunos();
    }

    //Procurar aluno por ID
    public Aluno buscarPorId(Integer id) {
        return repo.getListaDeAlunos().stream()
                .filter(t->t.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(id));
    }

    //Cadastrar novo aluno
    public void cadastrarAluno(Aluno novoAluno){
        repo.getListaDeAlunos().add(novoAluno);

    }

    //Remover Aluno
    public void removerAluno(Aluno deleteAluno){
        repo.getListaDeAlunos().removeIf(t -> t.id().equals(deleteAluno.id()));
    }


    //Matricular aluno
    public Aluno matricularAluno(Integer id) {
        Aluno alunoAtual = buscarPorId(id);

        if (alunoAtual.matriculado()) {
            throw new AlunoJaMatriculadoException(alunoAtual.nome());
        }
        Aluno alunoAtualizado = new Aluno(
                alunoAtual.id(),
                alunoAtual.nome(),
                alunoAtual.idade(),
                true);

        removerAluno(alunoAtual);
        cadastrarAluno(alunoAtualizado);
        return alunoAtualizado;
    }

    //Cancelar Matricula
    public Aluno cancelarMatricula(Integer id)  {
        Aluno alunoAtual = buscarPorId(id);

        if (!alunoAtual.matriculado()){
            throw new AlunoNaoMatriculadoException(alunoAtual.nome());
        }
        Aluno alunoCancelado = new Aluno(
                alunoAtual.id(),
                alunoAtual.nome(),
                alunoAtual.idade(),
                false);

        removerAluno(alunoAtual);
        cadastrarAluno(alunoCancelado);
        return alunoCancelado;
    }

}
