# Banco de Dados — Guia de Estudo (Aulas 01 a 05)

Guia de revisão completo e comentado das 5 primeiras aulas da disciplina (prof. Paduan — UAM). Cobre: Fundamentos, Modelagem Conceitual/ER, Modelo Relacional, Normalização e SQL Essencial. Inclui exercícios, gabarito comentado e uma "cola" de revisão rápida.

> Página da disciplina: [paduan.dev.br/bd](https://paduan.dev.br/bd)
>
> Nota: o site do professor disponibiliza 5 apresentações no Google Slides sem extração de texto liberada — este guia organiza e aprofunda os conteúdos da ementa, não é transcrição literal dos slides.

## Roteiro geral

| Aula | Tema central | Você precisa sair sabendo |
|---|---|---|
| 01 | Fundamentos e SGBD | Diferenciar dado, informação, banco de dados e SGBD |
| 02 | Modelagem conceitual | Identificar entidades, atributos, relacionamentos e cardinalidades |
| 03 | Modelo relacional | Transformar o modelo conceitual em tabelas, chaves e relações |
| 04 | Normalização | Reduzir redundância e evitar anomalias de inserção, alteração e exclusão |
| 05 | SQL essencial | Criar estruturas, inserir dados e consultar com comandos básicos |

---

## AULA 01 — Fundamentos de Banco de Dados

**Objetivos:** diferença entre dado e informação · o que é um banco de dados · papel do SGBD · vantagens de centralizar/estruturar dados · componentes básicos de um ambiente de BD.

**1. Dado x informação**
- **Dado:** valor isolado, sem interpretação suficiente (ex.: `35`)
- **Informação:** dado interpretado num contexto (ex.: "o cliente tem 35 anos")

**2. O que é banco de dados:** coleção organizada de dados relacionados, armazenados de forma que possam ser consultados, atualizados e administrados com eficiência (ex.: clientes, pedidos, produtos, pagamentos, histórico).

**3. O que é SGBD:** software que gerencia o banco de dados — fica entre a aplicação e os dados, controlando armazenamento, consultas, alterações, segurança.

| SGBD | Uso comum |
|---|---|
| MySQL | Aplicações web e sistemas corporativos |
| PostgreSQL | Sistemas robustos, dados relacionais e recursos avançados |
| Oracle Database | Grandes ambientes corporativos |
| SQL Server | Ecossistema Microsoft e aplicações empresariais |
| SQLite | Aplicações locais, mobile e sistemas embarcados |

**4. Por que não usar apenas arquivos:** duplicação de dados, dificuldade de manter cópias iguais, consultas complexas mais trabalhosas, controle de acesso/segurança mais difícil de centralizar, conflitos entre usuários alterando os mesmos dados.

**5. Conceitos importantes**

| Conceito | Ideia |
|---|---|
| Persistência | O dado continua existindo após o programa ser fechado |
| Integridade | Os dados devem obedecer regras e permanecer coerentes |
| Segurança | Nem todo usuário pode ver ou alterar tudo |
| Concorrência | Vários usuários podem acessar o banco ao mesmo tempo |
| Recuperação | O SGBD deve ajudar a restaurar dados após falhas |

**Resumo de bolso:** Banco de dados é a coleção organizada de dados. SGBD é o software responsável por gerenciar essa coleção. SQL é a linguagem usada para definir, manipular e consultar dados em muitos SGBDs relacionais.

**Exercícios**
1. Explique com suas palavras a diferença entre dado e informação.
2. Dê dois exemplos de SGBD.
3. Por que um SGBD é melhor do que vários arquivos soltos em um sistema grande?
4. O que significa integridade de dados?
5. Qual é o papel do SGBD entre a aplicação e os dados?

---

## AULA 02 — Modelagem Conceitual e Entidade Relacionamento

**Objetivos:** identificar entidades e atributos · distinguir atributos simples/compostos/multivalorados/derivados · relacionamentos · cardinalidades · montar modelo conceitual coerente com regras de negócio.

**1. Entidade:** algo relevante para o domínio do sistema, sobre o qual queremos armazenar dados (pessoa, objeto, evento ou conceito). Ex.: `CLIENTE`, `PRODUTO`, `PEDIDO`, `FUNCIONÁRIO`, `CURSO`.

**2. Atributo:** característica de uma entidade (um `CLIENTE` pode ter id, nome, CPF, email, data de nascimento).

| Tipo | Exemplo | Observação |
|---|---|---|
| Simples | CPF | Não precisa ser dividido para o modelo |
| Composto | Endereço | Pode ser decomposto em rua, número, cidade e CEP |
| Multivalorado | Telefones | Uma pessoa pode ter mais de um |
| Derivado | Idade | Pode ser calculada a partir da data de nascimento |
| Identificador | id_cliente | Distingue uma ocorrência das demais |

**3. Relacionamento:** associação entre entidades (ex.: `CLIENTE` realiza `PEDIDO`).

**4. Cardinalidade:** quantas ocorrências de uma entidade podem se relacionar com ocorrências de outra.

| Cardinalidade | Leitura | Exemplo |
|---|---|---|
| 1 para 1 | Um com um | Pessoa e prontuário exclusivo |
| 1 para N | Um com muitos | Cliente e pedidos |
| N para N | Muitos com muitos | Alunos e disciplinas |

**Macete:** quando aparecer N para N, quase sempre você vai precisar criar uma entidade/tabela associativa no modelo relacional.

**5. Regra de negócio manda no modelo:** não existe cardinalidade correta sem contexto — modelar é traduzir regras do mundo real para uma estrutura de dados.

**Exemplo conceitual:**
```
CLIENTE  1 ── realiza ──  N  PEDIDO
PEDIDO   1 ── contém  ──  N  ITEM_PEDIDO
PRODUTO  1 ── aparece ──  N  ITEM_PEDIDO
```
`ITEM_PEDIDO` resolve a relação N:N entre `PEDIDO` e `PRODUTO`, guardando também quantidade, preço no momento da compra e desconto.

**Erros clássicos:** criar entidade para qualquer palavra do enunciado · esquecer identificadores · escolher cardinalidade sem ler a regra de negócio · misturar modelo conceitual com detalhes físicos cedo demais · guardar uma lista inteira num único atributo.

**Exercícios**
1. Em um sistema de cinema, cite quatro possíveis entidades.
2. Qual a diferença entre entidade e atributo?
3. Um cliente pode fazer vários pedidos e cada pedido pertence a um único cliente. Qual a cardinalidade?
4. Por que uma relação N para N normalmente exige uma entidade associativa?
5. Dê um exemplo de atributo derivado.

---

## AULA 03 — Modelo Relacional, Tabelas e Chaves

**Objetivos:** relação/tupla/atributo no modelo relacional · chave primária e estrangeira · transformar relações do conceitual em tabelas · integridade de entidade e referencial.

**1. Vocabulário do modelo relacional**

| Termo | No dia a dia |
|---|---|
| Relação | Tabela |
| Tupla | Linha ou registro |
| Atributo | Coluna ou campo |
| Domínio | Conjunto de valores válidos para um atributo |

**2. Chave primária (PRIMARY KEY):** identifica de forma única cada registro de uma tabela. Não se repete e não pode ser nula.

**3. Chave estrangeira (FOREIGN KEY):** cria ligação entre tabelas — guarda um valor que referencia uma chave primária de outra tabela.

**4. Integridade referencial:** uma FK deve apontar para um registro válido da tabela referenciada (salvo quando a regra permitir nulo) — evita, por exemplo, um pedido ligado a um cliente inexistente.

**5. Conversão das cardinalidades**

| No modelo conceitual | No modelo relacional |
|---|---|
| 1 para N | A chave estrangeira normalmente fica no lado N |
| 1 para 1 | A FK pode ficar em um dos lados, de acordo com dependência e regra |
| N para N | Cria-se uma tabela associativa com as chaves das duas tabelas |

**Exemplo completo:**
```
CLIENTE (id_cliente PK, nome, email)
PRODUTO (id_produto PK, nome, preco)
PEDIDO (id_pedido PK, data_pedido, id_cliente FK)
ITEM_PEDIDO (id_pedido PK/FK, id_produto PK/FK, quantidade, preco_unitario)
```
Em `ITEM_PEDIDO`, a combinação de `id_pedido` e `id_produto` forma uma chave primária composta.

**Chaves naturais x artificiais**

| Tipo | Exemplo | Prós e cuidados |
|---|---|---|
| Natural | CPF | Já existe no negócio, mas pode mudar ou ter regras externas |
| Artificial | id_cliente | Criada pelo sistema, simples e estável |

**Exercícios**
1. Explique a função da chave primária.
2. Explique a função da chave estrangeira.
3. Em uma relação CLIENTE 1 para N PEDIDO, em qual tabela a chave estrangeira deve ficar?
4. O que é integridade referencial?
5. Como representar uma relação ALUNO N para N DISCIPLINA no modelo relacional?

---

## AULA 04 — Normalização de Dados

**Objetivos:** por que redundância excessiva causa problemas · anomalias de inserção/atualização/exclusão · 1FN/2FN/3FN em exemplos simples · dependência funcional (nível introdutório).

**1. O problema da redundância:** quando o mesmo fato aparece repetido em várias linhas, o banco depende de várias atualizações pra manter uma única verdade. Exemplo: se Ana trocar de e-mail, o sistema precisaria alterar várias linhas — se uma ficar pra trás, o banco passa a ter versões diferentes do mesmo fato.

```
PEDIDO
id_pedido | cliente_nome | cliente_email | produto | quantidade
1         | Ana          | ana@x.com     | Mouse   | 1
2         | Ana          | ana@x.com     | Teclado | 1
```

**2. Anomalias**

| Anomalia | O que acontece |
|---|---|
| Inserção | Não consigo cadastrar um fato sem cadastrar outro desnecessariamente |
| Atualização | O mesmo dado precisa ser alterado em vários lugares |
| Exclusão | Ao apagar um registro, posso perder informação que deveria continuar existindo |

**3. Primeira Forma Normal (1FN):** valores atômicos, sem listas ou grupos repetidos numa única coluna.
```
ERRADO:  cliente(nome, telefones) → Ana | 9999, 8888
MELHOR:  CLIENTE(id_cliente, nome)
         TELEFONE(id_telefone, numero, id_cliente)
```

**4. Segunda Forma Normal (2FN):** além de estar na 1FN, atributos que não fazem parte da chave devem depender da chave completa — problema típico quando existe chave composta.
```
ITEM_PEDIDO(id_pedido, id_produto, nome_produto, quantidade)
Chave composta: (id_pedido, id_produto)
nome_produto depende só de id_produto → viola 2FN

Solução:
PRODUTO(id_produto, nome_produto)
ITEM_PEDIDO(id_pedido, id_produto, quantidade)
```

**5. Terceira Forma Normal (3FN):** além de estar na 2FN, um atributo não-chave não deve depender de outro atributo não-chave (remove dependências transitivas).
```
FUNCIONARIO(id_funcionario, nome, id_departamento, nome_departamento)
nome_departamento depende de id_departamento, não diretamente de id_funcionario → viola 3FN

Solução:
FUNCIONARIO(id_funcionario, nome, id_departamento)
DEPARTAMENTO(id_departamento, nome_departamento)
```

**Mapa mental das formas normais**
- **1FN:** nada de lista dentro de célula — valores atômicos
- **2FN:** se a chave é composta, atributos não-chave precisam depender da chave inteira
- **3FN:** atributo não-chave não deve depender de outro atributo não-chave

**Exercícios**
1. Por que redundância pode gerar inconsistência?
2. Explique a anomalia de atualização.
3. Qual o problema de guardar vários telefones em uma única coluna?
4. Em que situação a 2FN exige atenção especial?
5. Qual é a ideia principal da 3FN?

---

## AULA 05 — SQL Essencial

**Objetivos:** diferenciar DDL e DML · criar banco e tabelas com SQL · definir PK/FK · inserir/consultar/alterar/excluir dados · filtros, ordenação e junções simples.

**1. Famílias de comandos**

| Grupo | Função | Exemplos |
|---|---|---|
| DDL | Define estruturas | CREATE, ALTER, DROP |
| DML | Manipula dados | INSERT, UPDATE, DELETE |
| DQL | Consulta dados | SELECT |
| DCL | Controla permissões | GRANT, REVOKE |
| TCL | Controla transações | COMMIT, ROLLBACK |

**2. Criando tabelas**
```sql
CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE
);

CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY,
    data_pedido DATE NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);
```

**3. Inserindo dados**
```sql
INSERT INTO cliente (id_cliente, nome, email)
VALUES (1, 'Ana', 'ana@email.com');

INSERT INTO pedido (id_pedido, data_pedido, id_cliente)
VALUES (101, '2026-09-09', 1);
```

**4. Consultando dados**
```sql
SELECT * FROM cliente;

SELECT nome, email
FROM cliente
WHERE id_cliente = 1;

SELECT nome
FROM cliente
ORDER BY nome;
```

**5. Alterando e excluindo**
```sql
UPDATE cliente
SET email = 'novo@email.com'
WHERE id_cliente = 1;

DELETE FROM pedido
WHERE id_pedido = 101;
```
**Cuidado:** UPDATE e DELETE sem WHERE podem atingir todas as linhas da tabela.

**6. JOIN, juntando tabelas:** usa a relação entre PK e FK para combinar dados de tabelas diferentes.
```sql
SELECT c.nome, p.id_pedido, p.data_pedido
FROM cliente c
INNER JOIN pedido p
    ON c.id_cliente = p.id_cliente;
```

| JOIN | Retorna |
|---|---|
| INNER JOIN | Somente linhas com correspondência nos dois lados |
| LEFT JOIN | Todas as linhas da tabela da esquerda, mesmo sem correspondência na direita |

**7. Ordem mental de uma consulta**
```
SELECT   → o que quero ver
FROM     → de onde vêm os dados
JOIN     → quais tabelas preciso combinar
WHERE    → quais linhas quero filtrar
GROUP BY → como quero agrupar
HAVING   → como filtrar grupos
ORDER BY → como quero ordenar
```

**Exercícios**
1. Qual a diferença entre CREATE e INSERT?
2. Escreva uma consulta que retorne todos os clientes.
3. Para que serve WHERE?
4. Qual o risco de executar DELETE sem WHERE?
5. Para que serve JOIN?
6. Qual a diferença prática entre INNER JOIN e LEFT JOIN?

---

## Revisão Integrada — Do problema ao SQL

1. Entenda o domínio e as regras de negócio.
2. Identifique entidades, atributos e relacionamentos.
3. Defina cardinalidades.
4. Transforme o modelo conceitual em tabelas.
5. Defina chaves primárias e estrangeiras.
6. Normalize a estrutura para reduzir redundância.
7. Crie as tabelas no SGBD com SQL.
8. Insira dados.
9. Consulte e relacione informações com SELECT e JOIN.

**Exemplo final — sistema de cinema:** entidades `FILME`, `SESSAO`, `SALA`, `CLIENTE`, `INGRESSO`.
```
FILME(id_filme PK, titulo, duracao_min)
SALA(id_sala PK, nome, capacidade)
SESSAO(id_sessao PK, data_hora, id_filme FK, id_sala FK)
CLIENTE(id_cliente PK, nome, email)
INGRESSO(id_ingresso PK, assento, valor, id_sessao FK, id_cliente FK)
```
Perguntas que o SQL responderia: "quais filmes têm sessão hoje?", "quantos ingressos foram vendidos por sessão?", "quais clientes compraram ingressos para determinado filme?".

**Perguntas pra responder sem decorar:**
- O que diferencia banco de dados, SGBD e SQL?
- Como eu descubro uma entidade?
- Como uma cardinalidade muda a estrutura das tabelas?
- Por que uma chave estrangeira é importante?
- Que tipo de problema a normalização evita?
- Como SELECT, FROM, WHERE e JOIN trabalham juntos?

---

## Gabarito Comentado

**Aula 01**
1. Dado é um valor bruto ou isolado. Informação é o dado interpretado em um contexto.
2. Exemplos: MySQL, PostgreSQL, Oracle Database, SQL Server e SQLite.
3. Porque um SGBD centraliza controle, reduz inconsistências, permite consultas estruturadas e oferece mecanismos de segurança, concorrência e recuperação.
4. Integridade significa manter os dados válidos e coerentes de acordo com regras definidas.
5. O SGBD gerencia o acesso da aplicação aos dados e controla armazenamento, consulta, alteração e proteção.

**Aula 02**
6. Exemplos possíveis: FILME, SESSAO, SALA e INGRESSO.
7. Entidade representa algo sobre o qual guardamos dados. Atributo descreve uma característica dessa entidade.
8. 1 para N.
9. Porque cada lado pode aparecer muitas vezes e a entidade associativa registra cada combinação válida entre eles.
10. Idade calculada a partir da data de nascimento.

**Aula 03**
11. A chave primária identifica cada registro de forma única.
12. A chave estrangeira referencia outra tabela e cria o vínculo entre os registros.
13. Na tabela PEDIDO, o lado N.
14. É a regra que mantém referências entre tabelas apontando para registros válidos.
15. Criando uma tabela associativa, por exemplo MATRICULA(id_aluno, id_disciplina, ...).

**Aula 04**
16. Porque o mesmo fato repetido pode ser atualizado em alguns lugares e esquecido em outros.
17. É a necessidade de alterar o mesmo dado em várias linhas, com risco de inconsistência.
18. A coluna deixa de ser atômica e fica mais difícil consultar, validar e relacionar cada telefone.
19. Quando existe chave composta e um atributo depende apenas de parte dela.
20. Evitar que um atributo não chave dependa de outro atributo não chave.

**Aula 05**
21. CREATE define uma estrutura. INSERT adiciona dados a uma estrutura existente.
22. `SELECT * FROM cliente;`
23. WHERE filtra linhas de acordo com uma condição.
24. Apagar todas as linhas da tabela.
25. Combinar dados relacionados de duas ou mais tabelas.
26. INNER JOIN exige correspondência. LEFT JOIN preserva todas as linhas da tabela da esquerda.

---

## Cola Permitida para Revisão (SQL mínimo para sobreviver)

| Tema | Essência |
|---|---|
| Banco de dados | Coleção organizada de dados relacionados |
| SGBD | Software que gerencia o banco |
| Entidade | Objeto ou conceito relevante para o domínio |
| Atributo | Característica de uma entidade |
| Relacionamento | Associação entre entidades |
| Cardinalidade | Quantidade de ocorrências que podem se relacionar |
| PK | Identifica unicamente uma linha |
| FK | Referencia outra tabela |
| 1FN | Valores atômicos |
| 2FN | Dependência da chave completa |
| 3FN | Sem dependência entre atributos não chave |
| SELECT | Consulta |
| WHERE | Filtra linhas |
| JOIN | Combina tabelas |
| ORDER BY | Ordena resultado |

```sql
CREATE TABLE tabela (...);
INSERT INTO tabela (...) VALUES (...);
SELECT colunas FROM tabela WHERE condicao;
UPDATE tabela SET coluna = valor WHERE condicao;
DELETE FROM tabela WHERE condicao;
SELECT ... FROM a JOIN b ON a.id = b.id_a;
```
