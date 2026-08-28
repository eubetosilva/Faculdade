# Atividade 6 — Análise de Risco

**Status:** ⏳ pendente

**Objetivo:** classificar funcionalidades por probabilidade × impacto e definir quais devem receber maior esforço de teste.

**Formato:** dupla, entrega individual no Ulife, PDF, 40 min.

## Etapas

1. Listagem de Funcionalidades — listar as principais funcionalidades do sistema
2. Classificação de Probabilidade — atribuir probabilidade de falha (Alta/Média/Baixa) para cada uma
3. Classificação de Impacto — atribuir impacto da falha (Alta/Média/Baixa)
4. Matriz de Risco — posicionar cada funcionalidade na matriz e calcular risco (Probabilidade × Impacto)
5. Definição de Prioridade de Teste — definir o esforço de teste para cada funcionalidade

## Template

| Funcionalidade | Probabilidade (A/M/B) | Impacto (A/M/B) | Risco (P × I) | Prioridade de Teste |
|---|---|---|---|---|
| Login/Autenticação | A | A | 5 | 🔴 Crítica — Teste Exaustivo |
| Reserva de Livros | M | A | 4 | 🟡 Alta — Teste Prioritário |

## Definição de Prioridade de Teste (referência)

| Nível de Risco | Prioridade | Esforço de Teste | Estratégia |
|---|---|---|---|
| 5 (Crítico) | 1º | Exaustivo | Testar todas as combinações, fluxos alternativos, casos de borda, segurança, performance |
| 3-4 (Alto) | 2º | Prioritário | Testar principais fluxos, casos críticos, integrações |
| 2 (Médio) | 3º | Normal | Testar fluxos principais, casos de erro básicos |
| 1 (Baixo) | 4º | Básico | Testar apenas fluxo principal (happy path) |

## Ideia para aplicar no app 99 (já analisado na Atividade 1)

Pode reaproveitar as funcionalidades já discutidas: login/autenticação, solicitar corrida, pagamento, rastreamento de motorista, cancelamento — classificando cada uma por probabilidade × impacto.
