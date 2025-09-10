# Cadastro de Alunos - Spring Boot

Um projeto simples desenvolvido em **Java com Spring Boot** para treinar os conceitos básicos de:

- Controllers (REST API)
- Services
- Repositories (em memória)
- Records (Java 16+)
- Tratamento de Exceções personalizadas
- Uso de `@RestControllerAdvice` para padronizar respostas de erro

Objetivo

Este projeto tem como objetivo aprender e fixar conceitos fundamentais de Java com Spring Boot, incluindo arquitetura em camadas e boas práticas de tratamento de erros.

---

##  Funcionalidades

- Listar todos os alunos
- Buscar aluno por **ID**
- Cadastrar novos alunos
- Remover alunos
- Matricular aluno (caso não esteja matriculado)
- Cancelar matrícula de aluno
- Tratamento de erros (ex.: aluno não encontrado, já matriculado, não matriculado)

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Lombok
- Maven

---

##  Endpoints Principais

- **GET /alunos** → Lista todos os alunos  
- **GET /alunos/{id}** → Busca aluno por ID  
- **POST /alunos** → Adiciona novo aluno  
- **DELETE /alunos/{id}** → Remove aluno  
- **PUT /alunos/{id}/matricular** → Matricula aluno  
- **PUT /alunos/{id}/desmatricular** → Cancela matrícula  

---

## ⚠ Tratamento de Erros

Exemplo de resposta de erro padronizada:

```json
{
  "timestamp": "2025-09-08T21:45:12.501",
  "status": 404,
  "error": "Aluno não encontrado",
  "message": "O Aluno com ID 99 não foi encontrado."
}
