# Atividade 8 — Engenharia de Casos de Teste (com base nos Cenários)

**Status:** ✅ concluída

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

## Cenários selecionados (todos de prioridade Alta)

- **CEN-01** — Cadastro de usuário com dados válidos
- **CEN-03** — Login com e-mail e senha válidos
- **CEN-07** — Reserva de livro disponível dentro do prazo de 7 dias

## Resumo dos 18 Casos de Teste

| Cenário | Positivos | Negativos | Fronteira |
|---|---|---|---|
| CEN-01 | CT-001 (dados válidos), CT-002 (e-mail com subdomínio) | CT-003 (CPF inválido), CT-004 (e-mail duplicado) | CT-005 (senha 8 caracteres), CT-006 (senha 7 caracteres) |
| CEN-03 | CT-007 (login correto), CT-008 (e-mail case-insensitive) | CT-009 (senha incorreta), CT-010 (e-mail não cadastrado) | CT-011 (5ª tentativa - bloqueio), CT-012 (4ª tentativa - ainda permitido) |
| CEN-07 | CT-013 (reservar disponível), CT-014 (consultar reserva ativa) | CT-015 (livro indisponível), CT-016 (limite de reservas simultâneas) | CT-017 (7º dia - último dia válido), CT-018 (8º dia - prazo vencido) |

Cada caso segue o template oficial (ID, Cenário Relacionado, Tipo, Título/Objetivo, Pré-condições, Dados de Teste, Passos para Execução, Resultado Esperado, Pós-condições, Resultado Obtido, Status). Os campos "Resultado Obtido" e "Status" ficam como "Not Executed" nesta atividade — serão preenchidos na Atividade 9 (Execução Controlada).

## Matriz Cenário ↔ Casos de Teste

| ID | Cenário (Atividade 7) | Casos de Teste Associados |
|---|---|---|
| CEN-01 | Cadastro de usuário com dados válidos (Alta) | CT-001, CT-002 (positivos) · CT-003, CT-004 (negativos) · CT-005, CT-006 (fronteira) |
| CEN-03 | Login com e-mail e senha válidos (Alta) | CT-007, CT-008 (positivos) · CT-009, CT-010 (negativos) · CT-011, CT-012 (fronteira) |
| CEN-07 | Reserva de livro disponível dentro do prazo de 7 dias (Alta) | CT-013, CT-014 (positivos) · CT-015, CT-016 (negativos) · CT-017, CT-018 (fronteira) |

> Arquivo final: [`atividade-8/Atividade8_Casos_de_Teste.pdf`](./atividade-8/Atividade8_Casos_de_Teste.pdf)
