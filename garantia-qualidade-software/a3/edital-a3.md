# Edital da A3 — Garantia da Qualidade de Software

**Formato:** Projeto Prático de QA + Relatório Técnico + Evidências + Apresentação Oral
**Tema Central:** Quality Assurance em Sistemas Open Source: da Implantação ao Quality Gate
**Grupos:** 2, 3 ou 4 alunos (nosso grupo: Alberto, Samuel, Armando — 3 integrantes)
**Apresentação:** até 20 min por grupo, com slides para projeção

> Documento original: [`edital_A3.pdf`](./edital_A3.pdf)

## ⚠️ Ações urgentes

1. **Cadastrar o grupo** — formulário: https://forms.office.com/r/nxtma8CcN2 (só um integrante precisa cadastrar todos)
2. **Escolher e registrar o sistema open source** — regra é "um sistema = um grupo", por ordem de chegada. Ver lista de sugestões abaixo.
3. **Confirmar com a professora as hashtags dos posts do LinkedIn** — o edital lista hashtags e exemplos de post sobre "Sustentabilidade + IA" (ex: projeto fictício "Food Connect"), que não tem relação com o tema real da nossa A3 (QA em software). Parece erro de cópia de outro edital — não usar esse conteúdo literalmente.

## Missão da equipe de QA

Responder, com evidências técnicas (não opinião pessoal):

> "Com base em evidências técnicas, este software apresenta qualidade suficiente para ser considerado apto para uma release?"

Cobrindo: atributos de qualidade, planejamento da qualidade, critérios de aceitação, plano de testes, análise de riscos, testes caixa-preta e caixa-branca, testes unitários/integração/sistema/aceitação/regressão, inspeção e revisão de código, gestão de defeitos, cobertura, métricas de qualidade, melhoria contínua.

## O que cada grupo deve fazer (12 passos)

1. Selecionar um sistema open source no GitHub (ainda não escolhido por outro grupo)
2. Clonar o repositório para o ambiente local
3. Configurar todas as dependências e ferramentas necessárias
4. Executar o sistema localmente, garantindo funcionamento
5. Compreender arquitetura, funcionalidades e código-fonte
6. Planejar uma estratégia completa de garantia da qualidade
7. Testar com técnicas de caixa-preta e caixa-branca
8. Inspecionar o código com análise estática e revisão técnica
9. Automatizar testes unitários, de integração e/ou API
10. Medir métricas de qualidade e cobertura de testes
11. Avaliar a qualidade do sistema com base nas evidências coletadas
12. Documentar tudo no relatório técnico e apresentar os resultados

## Restrições do sistema a escolher

| Critério | Regra |
|---|---|
| Sistema | Open source, GitHub, licença permissiva (MIT, Apache, GPL, etc.) |
| Linguagem | Deve ter suporte a frameworks de teste (JUnit, pytest, Mocha, etc.) |
| Tamanho | Mínimo 1.000 linhas; máximo recomendado 50.000 linhas |
| Repetição | Cada sistema só pode ser escolhido por UM grupo |

**Requisitos mínimos obrigatórios:** código-fonte disponível, licença open source identificável, front-end funcional (HTML/JS/CSS), back-end (Java), banco de dados (qualquer), execução local possível, funcionalidades/regras de negócio suficientes para testes, possibilidade de análise de código, criação/execução de testes automatizados, análise de cobertura.

**Desejável (não obrigatório):** API REST (Java), documentação de instalação, testes automatizados já existentes.

**Não serão aceitos:** sistemas excessivamente simples, exclusivamente front-end, exclusivamente back-end, sem persistência, ou que não rodem localmente.

## Sistemas sugeridos (escolher um, ou propor outro que atenda aos requisitos)

| # | Sistema | Linguagem | Testes | Cobertura | GitHub |
|---|---|---|---|---|---|
| 1 | Spring PetClinic (Angular) | Java 21 | JUnit | JaCoCo | github.com/spring-petclinic/spring-petclinic-angular |
| 2 | Spring PetClinic (React) | Java 21 | JUnit | JaCoCo | github.com/spring-petclinic/spring-petclinic-reactjs |
| 3 | Spring PetClinic (Microservices) | Java 21 | JUnit | JaCoCo | github.com/spring-petclinic/spring-petclinic-microservices |
| 4 | Spring PetClinic (REST) | Java 21 | JUnit | JaCoCo | github.com/spring-petclinic/spring-petclinic-rest |
| 5 | Drone Feeder | Java/Quarkus | JUnit 5 | JaCoCo (95%) | github.com/tamireshc/drone-feeder |
| 6 | U-Society API | Java 8 | JUnit + Mockito | JaCoCo | github.com/renderjaviii/u-society-api |
| 7 | Task Manager | Java 21 | JUnit | — | github.com/guuipauuli/taskmanager |
| 8 | Fullstack Cardápio Digital | Java/Spring Boot | — | — | github.com/joaolucasdevv/fullstack-java-spring |
| 9 | Rest Spring Test | Java 21 | JUnit 5 + Mockito | JaCoCo | github.com/douglasfragoso/rest-spring-test |
| 10 | MyCRM | Kotlin/Java 17 | TestContainers | JaCoCo | github.com/antonarhipov/mycrm |
| 11 | Multi-module Coverage Example | Java 8+ | JUnit 5 | JaCoCo | github.com/Rokko11/maven-multimodule-coverage |
| 12 | OAuth2 Demo Server (Spring Boot) | Java 17 | JUnit | JaCoCo | github.com/SammyOcharo/Springboot-Auth-OAuth2-Username-Password |
| 13 | OAuth2 Demo Server (Docker) | Java 17 | JUnit | — | github.com/bata515/authentication-authorization-investigate-best-practices |
| 14 | OAuth2 JWT Demo | Java/Spring Boot | — | — | github.com/panxiao81/spring-security-jwt-using-oauth2 |
| 15 | Jumpstart | Go | — | JaCoCo | github.com/nurdsoft/jumpstart |
| 16 | Sirius Web | Java 17 | JUnit | JaCoCo | github.com/scireum/sirius-biz |
| 17 | Magic-API | Java 1.8+ | JUnit | JaCoCo | github.com/ssssssss-team/magic-api |
| 18 | Para | Java 8+ | JUnit | JaCoCo | github.com/Erudika/para |
| 19 | Library API | Java 21 | JUnit | Flyway | github.com/andre-carbajal/LibraryApi |
| 20 | Zolt | Java 21 | JUnit | JaCoCo | github.com/zoltsh/zolt |

## Ferramentas sugeridas

Git/GitHub, IDE (VS Code, IntelliJ, Eclipse, PyCharm), JUnit/pytest/Mocha, Selenium/Cypress (opcional), Postman/Insomnia, SonarQube/SonarLint, JaCoCo/Coverage.py/Istanbul, Jira/Trello/GitHub Issues, GitHub Actions/Jenkins.

## Estrutura do relatório final (PDF, obrigatório)

Usar o template fornecido pela professora (ainda não anexado aqui). Só é aceito em PDF.

## Apresentação oral (Seminário, até 20 min)

| Parte | Foco |
|---|---|
| Arquitetura | Diagrama de arquitetura criado pelo grupo |
| Plano de Testes | Resumo do escopo, estratégia e critérios de aceitação |
| Matriz de Rastreabilidade | Resumo com principais requisitos e casos de teste |
| Análise de Riscos | Matriz Probabilidade × Impacto e prioridades de teste |
| SonarQube | Dashboard com bugs, vulnerabilidades, code smells, cobertura |
| Casos de Teste (caixa-preta) | Tabela resumo com principais casos e resultados |
| Casos de Teste (caixa-branca) | Tabela resumo com principais casos e resultados |
| Testes Automatizados | Prints da execução e estrutura do código |
| Métricas | Dashboard com indicadores calculados |
| Quality Decision | Tabela de critérios, decisão final e justificativa |
| Melhorias Propostas | Lista priorizada com justificativas |
| Lições Aprendidas | Principais aprendizados do projeto |

Também demonstrar: sistema em execução, execução da suíte de testes (passed/failed), dashboard de métricas, e a decisão final (Go / No-Go / Conditional).

**A nota da apresentação é individual** — todo integrante precisa dominar o conteúdo e responder perguntas.

## Cronograma

| Checkpoint | Conteúdo | Entrega |
|---|---|---|
| 1 | Seleção do sistema + Documentação de Configuração + Análise Inicial da Arquitetura | Ulife (template) + post LinkedIn |
| 2 | Plano de Testes + Matriz de Rastreabilidade + Análise de Riscos | Ulife (template) + post LinkedIn |
| 3 | Casos de Teste + Testes Automatizados + Relatório de Inspeção (SonarQube) + Relatório de Métricas + Quality Decision | Ulife (template) + post LinkedIn |
| Entrega Final | Relatório completo (PDF) + Apresentação (PDF) | Ulife + post de encerramento |
| Seminário | Apresentação oral (até 20 min) + demonstração do MVP | Slides + demonstração |

*Datas exatas de cada checkpoint estão na Agenda do Ulife (disponibilizada pela professora).*

## Posts obrigatórios no LinkedIn (1 ponto por checkpoint)

- Formato: texto + imagem (print do protótipo, diagrama, foto do grupo, etc.)
- Marcar @Profa. Cassilene Assis e @Anhembi Morumbi
- Post público ou visível para a rede da Anhembi
- Publicar até a data do checkpoint
- Anexar o link do post na entrega do Ulife

**Critérios de avaliação do post:** publicado no prazo, hashtags/menções corretas, clareza e qualidade do texto, relevância da imagem, engajamento (bônus).

> ⚠️ Ver aviso no topo — confirmar com a professora o conteúdo/hashtags reais antes de publicar, já que o exemplo do edital não bate com o tema da nossa A3.

## Critérios de avaliação da apresentação

Clareza e Organização · Demonstração Prática (sistema rodando, testes, métricas ao vivo) · Domínio do Conteúdo (todos os integrantes) · Argumentação Técnica (Quality Decision fundamentada) · Cumprimento do Tempo (20 min) · Qualidade dos Slides.

## Composição da nota (40 pontos)

| Item | Pontos |
|---|---|
| Atividades (em sala + checkpoints + posts LinkedIn) | 11 |
| Relatório Final (PDF) + Apresentação (PDF) | 14,5 |
| Seminário (Apresentação Oral) | 14,5 |
| **Total** | **40** |
