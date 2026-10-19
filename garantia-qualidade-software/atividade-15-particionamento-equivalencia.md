# Atividade 15 — Particionamento de Equivalência

**Status:** ✅ concluída
**Objetivo:** definir classes de equivalência (válidas e inválidas) para os campos de um formulário de cadastro (Nome, E-mail, CPF, Idade, Telefone, Senha), com um valor representativo e o resultado esperado (Aceitar/Rejeitar) para cada classe.

## Resumo

- **Nome:** válido, <3 caracteres, >50 caracteres, com números, com caracteres especiais
- **E-mail:** válido, sem @, sem domínio válido
- **CPF:** válido, com letras, com caracteres especiais
- **Idade:** válida, ≤18, ≥118
- **Telefone:** válido, com letras, com mais de 11 dígitos
- **Senha:** válida, sem caracteres especiais, <6 caracteres, sem maiúsculas, sem números

22 classes ao todo, cobrindo bem as variações mais comuns de validação de cada campo.

**Observação:** nos valores de Idade (-50 e 1972), o representante mistura o teste da classe (≤18 / ≥118) com um formato implausível (negativo / ano). Funciona, mas um valor mais direto (15 / 130) deixaria mais claro qual regra está sendo testada.

> Arquivo final: [`atividade-15/Atividade15_Particionamento_Equivalencia.docx`](./atividade-15/Atividade15_Particionamento_Equivalencia.docx) · [PDF](./atividade-15/Atividade15_Particionamento_Equivalencia.pdf) · [original do grupo](./atividade-15/Atividade15_original.pdf)
