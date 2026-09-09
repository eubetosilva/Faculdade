-- ============================================================
-- Schema acadêmico (Curso, Aluno, Turma, Matrícula) — prof. Paduan
-- Banco de Dados — material de estudo
-- ============================================================

SET NAMES utf8mb4;

-- ============================================================
-- 1. TABELA DE CURSOS
-- ============================================================

CREATE TABLE curso (
    id_curso INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL
) DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- 2. TABELA DE ALUNOS
-- ============================================================

CREATE TABLE aluno (
    id_aluno INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    cidade VARCHAR(50),
    email VARCHAR(100)
) DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- 3. TABELA DE TURMAS
-- ============================================================

CREATE TABLE turma (
    id_turma INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    semestre INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
) DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- 4. TABELA DE MATRICULAS
-- ============================================================

CREATE TABLE matricula (
    id_matricula INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT NOT NULL,
    id_turma INT NOT NULL,
    data_matricula DATE NOT NULL,
    situacao VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
) DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- 5. POPULACAO DA TABELA CURSO
-- ============================================================

INSERT INTO curso (nome, carga_horaria) VALUES
('Análise e Desenvolvimento de Sistemas', 2000),
('Ciência da Computação', 3200),
('Sistemas de Informação', 3000),
('Engenharia de Software', 3200),
('Redes de Computadores', 2000);

-- ============================================================
-- 6. POPULACAO DA TABELA ALUNO
-- ============================================================

INSERT INTO aluno
(nome, data_nascimento, cidade, email) VALUES
('Ana Paula Souza', '2003-05-12', 'São Paulo', 'ana.souza@email.com'),
('Bruno Henrique Lima', '2002-08-23', 'Santo André', 'bruno.lima@email.com'),
('Carlos Eduardo Santos', '2001-03-17', 'São Paulo', 'carlos.santos@email.com'),
('Daniela Oliveira', '2004-11-05', 'Osasco', 'daniela.oliveira@email.com'),
('Eduardo Martins', '2000-07-19', 'Guarulhos', 'eduardo.martins@email.com'),
('Fernanda Alves', '2003-01-28', 'São Paulo', 'fernanda.alves@email.com'),
('Gabriel Rodrigues', '2002-12-10', 'São Bernardo do Campo', 'gabriel.rodrigues@email.com'),
('Helena Costa', '2004-04-15', 'São Paulo', 'helena.costa@email.com'),
('Igor Ferreira', '2001-09-30', 'Mauá', 'igor.ferreira@email.com'),
('Juliana Mendes', '2003-06-21', 'Santo André', 'juliana.mendes@email.com'),
('Lucas Barbosa', '2002-02-14', 'São Paulo', 'lucas.barbosa@email.com'),
('Mariana Castro', '2004-10-09', 'Osasco', 'mariana.castro@email.com'),
('Nicolas Almeida', '2001-12-03', 'Guarulhos', 'nicolas.almeida@email.com'),
('Patrícia Gomes', '2003-03-25', 'São Paulo', 'patricia.gomes@email.com'),
('Rafael Teixeira', '2000-05-18', 'São Bernardo do Campo', 'rafael.teixeira@email.com'),
('Sabrina Ribeiro', '2004-08-07', 'Mauá', 'sabrina.ribeiro@email.com'),
('Thiago Moreira', '2002-11-26', 'São Paulo', 'thiago.moreira@email.com'),
('Vanessa Carvalho', '2003-09-13', 'Santo André', 'vanessa.carvalho@email.com'),
('William Nascimento', '2001-01-06', 'Osasco', 'william.nascimento@email.com'),
('Yasmin Ferreira', '2004-07-22', 'São Paulo', 'yasmin.ferreira@email.com');

-- ============================================================
-- 7. POPULACAO DA TABELA TURMA
-- ============================================================

INSERT INTO turma
(codigo, ano, semestre, id_curso) VALUES
('ADS-2026-1A', 2026, 1, 1),
('CC-2026-1A', 2026, 1, 2),
('SI-2026-1A', 2026, 1, 3),
('ES-2026-1A', 2026, 1, 4),
('RC-2026-1A', 2026, 1, 5),
('ADS-2026-2A', 2026, 2, 1);

-- ============================================================
-- 8. POPULACAO DA TABELA MATRICULA
-- ============================================================

INSERT INTO matricula
(id_aluno, id_turma, data_matricula, situacao) VALUES
(1, 1, '2026-01-10', 'Ativa'),
(2, 1, '2026-01-11', 'Ativa'),
(3, 2, '2026-01-12', 'Ativa'),
(4, 3, '2026-01-13', 'Ativa'),
(5, 4, '2026-01-14', 'Ativa'),
(6, 1, '2026-01-15', 'Ativa'),
(7, 2, '2026-01-15', 'Ativa'),
(8, 3, '2026-01-16', 'Trancada'),
(9, 5, '2026-01-16', 'Ativa'),
(10, 3, '2026-01-17', 'Ativa'),
(11, 1, '2026-01-18', 'Ativa'),
(12, 4, '2026-01-18', 'Ativa'),
(13, 2, '2026-01-19', 'Ativa'),
(14, 1, '2026-01-20', 'Ativa'),
(15, 5, '2026-01-20', 'Ativa'),
(16, 5, '2026-01-21', 'Ativa'),
(17, 2, '2026-01-22', 'Ativa'),
(18, 3, '2026-01-22', 'Ativa'),
(19, 4, '2026-01-23', 'Cancelada'),
(20, 1, '2026-01-24', 'Ativa');
