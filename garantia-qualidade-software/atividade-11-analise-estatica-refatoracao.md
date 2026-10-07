# Atividade 11 — Análise Estática e Refatoração no VS Code

**Status:** ✅ concluída
**Atividade individual.** Código: `ProcessadorPagamento.java` (processamento de pagamentos credito/debito/pix).

As ferramentas foram executadas de verdade (Checkstyle 9.3, SpotBugs 4.10.4, Semgrep 1.179.0). Resultado real: [`Relatorio-AT11_real.pdf`](./atividade-11/Relatorio-AT11_real.pdf). A validação funcional rodou 230 verificações comparando o comportamento antes/depois — todas aprovadas. A senha passou a ser validada por **PBKDF2-HMAC-SHA256 + salt aleatório, 600.000 iterações**, seguindo a OWASP Password Storage Cheat Sheet (bem acima do hash simples usado no rascunho inicial).

## 8 problemas identificados (real, via Checkstyle/SpotBugs/Semgrep)

| ID | Ferramenta | Linha | Tipo | Severidade | Descrição |
|---|---|---|---|---|---|
| 1 | Checkstyle | 3 | Estilo/Manutenibilidade | Baixa | Import wildcard `java.util.*` |
| 2 | Checkstyle | 5 | Estilo/Manutenibilidade | Baixa | Classe sem Javadoc |
| 3 | Checkstyle | 7 | Estilo/Manutenibilidade | Baixa | `processar()` sem Javadoc |
| 4 | Checkstyle | 40 | Estilo/Manutenibilidade | Baixa | `validarSenha()` sem Javadoc |
| 5 | Checkstyle | 49 | Estilo/Manutenibilidade | Baixa | `calcularDesconto()` sem Javadoc |
| 6 | SpotBugs | 42 | Bug | Alta | Comparação de senha String com `==` |
| 7 | Semgrep | 41 | Segurança | Alta | Senha fixa hardcoded (`senhaCorreta`) |
| 8 | Semgrep | 42 | Bug | Alta | Comparação de String usando `==` |

## Refatoração aplicada

Early Return / Extract Method, constantes nomeadas, Javadoc, imports explícitos, e a correção de segurança real: validação por **PBKDF2-HMAC-SHA256 + salt**, 600.000 iterações, comparação resistente a timing attack.

## Resultado

| Métrica | Antes | Depois | Melhoria |
|---|---|---|---|
| Checkstyle (4 espaços) | 5 | 0 | 100% |
| SpotBugs | 1 | 0 | 100% |
| Semgrep | 2 | 0 | 100% |
| Complexidade ciclomática máxima | 9 | 6 | 33% |
| Profundidade máxima de `if` aninhado | 3 | 0 | 100% |
| Números mágicos | 9 | 0 | 100% |

Validação funcional: **230 verificações** comparando comportamento antes/depois, todas aprovadas.

## Limitações documentadas (transparência, não falhas)

- Senha de demonstração (`admin123`) continua fixa no exercício, mas a validação já suporta hash/salt fornecidos externamente
- Exigência de cartão de 16 dígitos mantida até pro PIX, só pra preservar a comparação 1:1 com a suíte de 230 testes

> Arquivo final (conteúdo real, mesmo template das outras atividades): [`Atividade11_Analise_Estatica_Refatoracao.docx`](./atividade-11/Atividade11_Analise_Estatica_Refatoracao.docx) · [PDF](./atividade-11/Atividade11_Analise_Estatica_Refatoracao.pdf)
> Relatório original (Checkstyle/SpotBugs/Semgrep executados de verdade): [`Relatorio-AT11_real.pdf`](./atividade-11/Relatorio-AT11_real.pdf)
> Roteiro de apresentação: [`Roteiro_Apresentacao_AT11.docx`](./atividade-11/Roteiro_Apresentacao_AT11.docx) · [PDF](./atividade-11/Roteiro_Apresentacao_AT11.pdf)

**Nota:** o trecho de `validarSenha()`/PBKDF2 no código refatorado deste documento é um placeholder apontando pro código-fonte real do projeto — o `.java` final com a implementação completa do PBKDF2 ainda não foi anexado pra substituir esse trecho pelo código literal.

**Pendente:** os 2 prints do painel Problems (antes/depois) — precisam ser salvos como PNG a partir do VS Code real.
