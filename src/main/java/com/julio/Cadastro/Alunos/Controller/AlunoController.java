package com.julio.Cadastro.Alunos.Controller;


import com.julio.Cadastro.Alunos.Exception.AlunoJaMatriculadoException;
import com.julio.Cadastro.Alunos.Exception.AlunoNaoEncontradoException;
import com.julio.Cadastro.Alunos.Exception.AlunoNaoMatriculadoException;
import com.julio.Cadastro.Alunos.Model.Aluno;
import com.julio.Cadastro.Alunos.Service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    //Listar todos os alunos
    @GetMapping
    public List<Aluno> listar(){
        return service.listarAlunos();
    }

    //Buscar aluno por ID
    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Integer id) throws AlunoNaoEncontradoException {
        return  service.buscarPorId(id);
    }

    //Cadastrar novo Aluno
    @PostMapping
    public void adicionar(@RequestBody Aluno a){
        service.cadastrarAluno(a);
    }

    //Delete alunos
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Aluno a){
        service.removerAluno(a);
    }

    //PUT Matricular aluno
    @PutMapping("/{id}/matricular")
    public Aluno matricular(@PathVariable Integer id) throws AlunoJaMatriculadoException, AlunoNaoEncontradoException {
        return service.matricularAluno(id);
    }

    //Put Cancelar Matriculad
    @PutMapping("/{id}/desmatricular")
    public Aluno desmatricular(@PathVariable Integer id) throws AlunoNaoEncontradoException, AlunoNaoMatriculadoException {
        return service.cancelarMatricula(id);
    }
}