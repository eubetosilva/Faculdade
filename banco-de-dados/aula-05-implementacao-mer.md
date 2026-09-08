# Aula 05 — Implementação do MER no MySQL Workbench

**Status:** 🔄 em andamento (feito no PC da faculdade, continua em casa com o trio)

Implementação em SQL do [MER de Aluguel de Carro](./mer-aluguel-carro.md), feita no MySQL Workbench.

## Script (até agora)

```sql
-- cria um nova banco de dados (schema)
create database bd_aula05;

-- marca o banco default (passa a ser o banco de trabalho)
use bd_aula05;

-- inicio da criação das tabelas

create table categoria (
  id integer primary key,
  tipo varchar(40) not null,
  valor numeric(4,2) default 0
);

create table veiculo (
  id integer not null primary key,
  marca varchar(30) not null,
  modelo varchar(30) not null,
  ano int,
  id_categoria integer not null
);

-- FK adicionada depois de criar a tabela (correção)
alter table veiculo
  add constraint fk_veiculo_categoria
  foreign key (id_categoria) references categoria(id);
```

## Próximos passos (a fazer em casa com o trio)

Continuar o script criando as tabelas restantes do MER:

- `cliente` (id_cliente PK, nome, cpf/cnpj, telefone, email, endereço, tipo)
- `locadora` (id_locadora PK, nome, endereço, cidade, telefone)
- `vendedor` (id_vendedor PK, nome, cpf, cargo, FK para locadora)
- `aluguel` (id_aluguel PK, FKs para cliente/veiculo/vendedor/locadora, datas, valores, km) — entidade associativa

> Observação: a tabela `categoria` não estava no MER original (Veículo tinha o atributo `categoria` direto) — foi normalizada em uma tabela separada nesta implementação, o que é uma boa prática (evita repetir texto e permite reaproveitar categorias entre veículos).
