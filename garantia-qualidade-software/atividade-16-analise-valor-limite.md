# Atividade 16 — Análise de Valor Limite

**Status:** ✅ concluída
**Objetivo:** testar os campos do mesmo formulário de cadastro (Atividade 15) nos valores-limite (logo abaixo, no limite e logo acima dos limites mínimo/máximo), comparando o resultado esperado com o resultado obtido ao rodar o sistema.

## Resumo

| Campo | Limite | Valor | Resultado |
|---|---|---|---|
| Nome | Inferior | "U" (1 caractere) | Rejeitou ✅ |
| Nome | Superior | "U" × 49 | Aceitou ✅ |
| Nome | Superior | "U" × 51 | Rejeitou ✅ |
| Idade | Inferior | 2 | Rejeitou ✅ |
| Idade | Superior | 117 | Aceitou ✅ |
| Telefone | Inferior | 11 dígitos (inválido) | Rejeitou ✅ |
| Senha | Inferior | 0 (vazia) | Rejeitou ✅ |

**7 de 7 verificações bateram** — resultado obtido igual ao esperado em todos os casos.

**Observações:**
- A linha de Telefone ficou com a coluna "Valor" um pouco confusa (mistura "Inválido" com o número 11) — vale revisar o que exatamente foi testado.
- Nome e Idade testaram os dois limites (inferior e superior); Telefone e Senha só testaram o limite inferior. Se der tempo, vale completar o limite superior desses dois campos também.

> Arquivo final: [`atividade-16/Atividade16_Analise_Valor_Limite.docx`](./atividade-16/Atividade16_Analise_Valor_Limite.docx) · [PDF](./atividade-16/Atividade16_Analise_Valor_Limite.pdf) · [original do grupo](./atividade-16/Atividade16_original.pdf)
