# Atividade 8 — Engenharia de Casos de Teste (com base nos Cenários)

**Status:** ⏳ pendente (depende da Atividade 7)

**Objetivo:** a partir dos cenários de teste definidos na Atividade 7, elaborar casos de teste detalhados (positivos, negativos e de fronteira), aplicando técnicas de particionamento de equivalência e análise de valores-limite.

## Descrição

Com base nos cenários da Atividade 7:
1. Selecionar **3 cenários** para detalhamento (pelo menos 1 deve ser de prioridade Alta)
2. Para cada cenário, elaborar:
   - 2 casos **positivos**
   - 2 casos **negativos**
   - 2 casos de **fronteira**
3. Total: 3 cenários × 6 casos = **18 casos de teste (mínimo)**
4. Construir a **Matriz Cenário ↔ Casos de Teste**

## Template do Caso de Teste

| Campo | Valor |
|---|---|
| ID do Caso de Teste | |
| Cenário de Teste Relacionado | |
| Título / Objetivo | |
| Pré-condições | |
| Dados de Teste | |
| Passos para Execução | |
| Resultado Esperado | |
| Pós-condições | |
| Resultado Obtido | (preencher na execução) |
| Status | (preencher na execução) |

## Template Matriz Cenário ↔ Casos de Teste

| ID | Cenário | Casos de Teste Associados |
|---|---|---|
| CEN-001 | Login com sucesso | CT-001 (positivo) |
| CEN-002 | Login com falha | CT-002 (negativo - senha inválida), CT-003 (negativo - e-mail inválido) |

## Sugestão de cenários a detalhar (dos 12 da Atividade 7)

Escolher 3 entre os de prioridade Alta: CEN-01 (cadastro válido), CEN-03 (login válido), CEN-07 (reserva dentro do prazo), CEN-08 (concorrência na reserva) — ou outra combinação, desde que ao menos 1 seja Alta.
