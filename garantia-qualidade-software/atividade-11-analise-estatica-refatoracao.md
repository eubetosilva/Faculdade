# Atividade 11 — Análise Estática e Refatoração no VS Code

**Status:** ✅ concluída (parcial — ver pendência)
**Atividade individual.** Código: `ProcessadorPagamento.java` (processamento de pagamentos credito/debito/pix).

## 9 problemas identificados (mínimo pedido: 8)

| ID | Ferramenta | Tipo | Severidade | Descrição |
|---|---|---|---|---|
| 1 | Checkstyle | Estilo | Baixa | Import com `.*` em vez de imports explícitos |
| 2 | Checkstyle | Manutenibilidade | Baixa | Falta Javadoc na classe |
| 3 | Checkstyle | Manutenibilidade | Baixa | Falta Javadoc no método `processar()` |
| 4 | Checkstyle | Estilo | Média | Indentação / aninhamento excessivo |
| 5 | SonarLint | Complexidade | Alta | Complexidade ciclomática alta, 4 níveis de `if` aninhado |
| 6 | SpotBugs | Bug | Alta | Comparação de Strings com `==` em `validarSenha()` |
| 7 | Semgrep | Segurança | Crítica | Senha hardcoded (`"admin123"`) |
| 8 | SonarLint | Manutenibilidade | Média | Números mágicos (0.05, 0.02) sem constante |
| 9 | SonarLint | Duplicação | Média | Blocos de crédito/débito com a mesma estrutura repetida |

## Refatoração aplicada

Early Return, Extract Method (`validarEntradas()`, `calcularTaxa()`), `==` → `.equals()` via hash, senha validada por SHA-256 em vez de comparação direta, constantes nomeadas no lugar dos números mágicos, Javadoc adicionado, indentação padronizada, imports explícitos.

Resultado: 0 problemas de Checkstyle/SpotBugs/Semgrep, complexidade ciclomática e aninhamento reduzidos, nenhuma constante mágica restante.

> Arquivo final: [`atividade-11/Atividade11_Analise_Estatica_Refatoracao.docx`](./atividade-11/Atividade11_Analise_Estatica_Refatoracao.docx) · [PDF](./atividade-11/Atividade11_Analise_Estatica_Refatoracao.pdf)

**Pendente:** os 2 prints do painel Problems (antes/depois da refatoração) — precisam ser capturados rodando o VS Code de verdade com as extensões (Checkstyle, SpotBugs, Semgrep, SonarLint) instaladas.
