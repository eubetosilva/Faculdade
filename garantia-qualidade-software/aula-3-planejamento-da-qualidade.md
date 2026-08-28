# Aula 3 — Planejamento da Qualidade

## Definição

Planejamento da Qualidade de Software é o processo de estruturar como um projeto garantirá que o produto final atenda aos padrões exigidos, funcione sem falhas críticas e satisfaça as necessidades do cliente. Define diretrizes, ferramentas, métricas e etapas do início ao fim do desenvolvimento.

## Fluxo geral

```
Requisitos de Software → Análise de Risco → Critérios de Aceitação → Estratégias de Validação → Execução de Testes e Validação → Conclusão/Aceitação
```

Tudo isso é conectado pela **Matriz de Rastreabilidade** (Requisitos ↔ Testes ↔ Riscos), com monitoramento contínuo.

## Requisitos de Software

- **Funcionais (RF):** ações que o sistema executa. *Ex: o sistema deve permitir cadastro de usuários com verificação de e-mail.*
- **Não Funcionais (RNF):** atributos de qualidade, restrições e desempenho. *Ex: a API deve responder em menos de 200ms sob carga normal.*

## Critérios de Aceitação

Conjunto de condições que uma funcionalidade precisa cumprir para ser considerada concluída e aprovada pelo cliente/PO. Objetivo: eliminar ambiguidade sobre o que significa uma tarefa estar "pronta".

**Formato Given-When-Then:**
- **Dado** que o usuário está na tela de login,
- **Quando** ele inserir uma senha incorreta 3 vezes seguidas,
- **Então** a conta deve ser bloqueada temporariamente por 15 minutos.

## Estratégias de Validação

- **UAT (User Acceptance Testing):** validação feita pelo cliente/usuário final em ambiente de homologação
- **Pirâmide de Testes Automatizados:**
  - *Unidade:* componentes e funções isoladas
  - *Integração:* interfaces e comunicação entre módulos, APIs, bancos
  - *Ponta a Ponta (E2E):* fluxo completo do usuário
- **Testes de Carga e Estresse:** múltiplos acessos simultâneos, valida desempenho/estabilidade
- **Testes de Regressão:** garante que novas alterações não quebrem o que já funcionava

## Matriz de Rastreabilidade

Tabela que conecta requisitos aos artefatos (casos de teste, código, riscos). Objetivo: garantir cobertura total (todo requisito tem teste correspondente) e facilitar análise de impacto.

- **Forward (pra frente):** Requisito → Design → Código → Casos de Teste
- **Backward (pra trás):** Casos de Teste/Bugs → Requisito de origem (evita implementar código "extra" não solicitado)

| ID Requisito | Descrição | ID Caso de Teste | Status | ID Bug |
|---|---|---|---|---|
| REQ-01 | Autenticação via OAuth2 | CT-01, CT-02 | Passou | — |
| REQ-02 | Exportação de relatório PDF | CT-03 | Falhou | BUG-104 |

## Análise de Risco

Processo contínuo de identificar, avaliar e priorizar potenciais problemas que podem impactar qualidade, prazo ou custo. Objetivo: **Risk-Based Testing** — direcionar esforço de teste para as áreas mais críticas.

**Etapas:**
1. **Identificação de Riscos** — mapear o que pode dar errado
2. **Avaliação** (Matriz Probabilidade × Impacto — Baixa/Média/Alta em cada eixo)
3. **Mitigação e Plano de Contingência**

**Matriz de Risco (Probabilidade × Impacto):**

| | Impacto Baixo | Impacto Médio | Impacto Alto |
|---|---|---|---|
| **Probabilidade Alta** | 1 | 4 | **5 — Crítico** |
| **Probabilidade Média** | 2 | 3 | 4 |
| **Probabilidade Baixa** | 1 | 2 | 3 |

**Priorização de Testes:**
- **Risco Crítico (5):** teste obrigatório e exaustivo (ex: falha de autenticação → perda de dados)
- **Risco Alto (3-4):** teste prioritário (ex: falha no checkout → perda de vendas)
- **Risco Médio (2):** teste normal (ex: erro em filtro de busca → frustração do usuário)
- **Risco Baixo (1):** teste básico (ex: erro visual em botão → problema estético)
