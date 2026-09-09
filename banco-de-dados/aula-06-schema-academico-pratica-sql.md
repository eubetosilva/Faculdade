# Aula 06 — Schema Acadêmico (Curso, Aluno, Turma, Matrícula) — material de estudo

Script fornecido pelo prof. Paduan para praticar consultas SQL (JOINs, agregações, filtros).

**Correção aplicada:** o script original veio com acentuação quebrada (mojibake, ex.: `SÃ£o Paulo` em vez de `São Paulo`) — sintoma de UTF-8 sendo lido como Latin-1. Corrigido no arquivo salvo aqui, com `SET NAMES utf8mb4;` no início e `DEFAULT CHARSET=utf8mb4` em cada `CREATE TABLE`. Se os dados já foram inseridos no banco com o encoding quebrado, é preciso `DROP TABLE` nas 4 tabelas e reimportar com o script corrigido (rodar `SET NAMES utf8mb4;` antes dos INSERTs resolve).

> Script completo: [`schema-academico/schema_academico.sql`](./schema-academico/schema_academico.sql)
>
> Material do professor: [paduan.dev.br/bd](https://paduan.dev.br/bd) — Banco de Dados 2026

## DER Conceitual (exercício em aula) vs. schema físico implementado

O professor apresentou um DER conceitual mais completo — **Gestão Escolar**: `CURSO` (1,N)—possui—(1,1) `DISCIPLINA` (1,1)—leciona—(1,N) `PROFESSOR`, e `ALUNO` (0,N)—cursa—(0,N) `DISCIPLINA`. Como "cursa" é N:N entre Aluno e Disciplina, no projeto físico essa relação vira a tabela associativa `MATRICULA`.

O schema que efetivamente implementamos (seção acima) é uma versão simplificada desse DER: substitui `DISCIPLINA` + `PROFESSOR` por `TURMA` (ligada direto a `CURSO`), então `MATRICULA` liga `ALUNO` ↔ `TURMA` em vez de `ALUNO` ↔ `DISCIPLINA`.

## Boas Práticas ao Escrever DDL (slide da aula)

- Definir tipos de dados compatíveis com o domínio real de cada atributo
- Aplicar `NOT NULL` em colunas obrigatórias e `DEFAULT` quando fizer sentido
- Nomear tabelas e colunas de forma clara e consistente

## Estrutura das tabelas

| Tabela | PK | FKs | Campos principais |
|---|---|---|---|
| `curso` | `id_curso` | — | nome, carga_horaria |
| `aluno` | `id_aluno` | — | nome, data_nascimento, cidade, email |
| `turma` | `id_turma` | `id_curso` → curso | codigo, ano, semestre |
| `matricula` | `id_matricula` | `id_aluno` → aluno, `id_turma` → turma | data_matricula, situacao |

Dados de exemplo: 5 cursos, 20 alunos, 6 turmas, 20 matrículas (situação: Ativa / Trancada / Cancelada).

## Sugestões de consultas para praticar

```sql
-- 1. Listar nome do aluno + curso em que está matriculado
SELECT a.nome AS aluno, c.nome AS curso, t.codigo AS turma
FROM matricula m
JOIN aluno a ON a.id_aluno = m.id_aluno
JOIN turma t ON t.id_turma = m.id_turma
JOIN curso c ON c.id_curso = t.id_curso;

-- 2. Contar quantos alunos ativos tem cada turma
SELECT t.codigo, COUNT(*) AS total_ativos
FROM matricula m
JOIN turma t ON t.id_turma = m.id_turma
WHERE m.situacao = 'Ativa'
GROUP BY t.codigo;

-- 3. Alunos com matrícula Trancada ou Cancelada
SELECT a.nome, m.situacao
FROM matricula m
JOIN aluno a ON a.id_aluno = m.id_aluno
WHERE m.situacao IN ('Trancada', 'Cancelada');

-- 4. Curso com maior carga horária
SELECT nome, carga_horaria
FROM curso
ORDER BY carga_horaria DESC
LIMIT 1;

-- 5. Quantidade de alunos matriculados por curso
SELECT c.nome AS curso, COUNT(m.id_matricula) AS total_matriculas
FROM curso c
JOIN turma t ON t.id_curso = c.id_curso
JOIN matricula m ON m.id_turma = t.id_turma
GROUP BY c.nome
ORDER BY total_matriculas DESC;

-- 6. Alunos que nunca se matricularam (LEFT JOIN)
SELECT a.nome
FROM aluno a
LEFT JOIN matricula m ON m.id_aluno = a.id_aluno
WHERE m.id_matricula IS NULL;
```
