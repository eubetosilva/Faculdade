# Atividade 12 — Bug Hunt: Testes Exploratórios

**Status:** ✅ concluída
**Site escolhido:** [Sauce Demo](https://www.saucedemo.com) — e-commerce de demonstração com usuários diferentes (`standard_user`, `problem_user`, `error_user`, `visual_user`, `performance_glitch_user`, `locked_out_user`), cada um com um comportamento diferente. Escolhido porque os defeitos são reproduzíveis de propósito, trocando só a conta usada no login.

## Técnicas aplicadas

- **Tour pela aplicação** — login com cada usuário e navegação livre por produtos/carrinho/checkout
- **Teste de fluxos alternativos** — filtros de ordenação em ordens não padrão
- **Teste de limites/interrupção** — preenchimento do checkout parando no meio
- **Teste de concorrência/sessão** — repetir um fluxo já concluído com o botão Voltar do navegador

## Os 5 defeitos encontrados

| ID | Título | Severidade | Prioridade |
|---|---|---|---|
| BUG-001 | Imagens dos produtos trocadas (`problem_user`) — todos os itens com a mesma foto | Alta | Alta |
| BUG-002 | Ordenação "Name (Z to A)" não reordena a lista (`problem_user`) | Baixa | Baixa |
| BUG-003 | Campo "Last Name" não aceita digitação no Checkout (`error_user`) — bloqueia 100% da compra | Crítica | Alta |
| BUG-004 | Layout quebrado na tela de produtos (`visual_user`) | Média | Média |
| BUG-005 | Botão Voltar do navegador reexibe tela de pedido já finalizado | Média | Baixa |

Cada defeito foi documentado com o template completo (Ambiente, Pré-condição, Passos para Reprodução, Resultado Esperado/Obtido, Severidade, Prioridade, Evidência).

> Arquivo final: [`atividade-12/Atividade12_Bug_Hunt.docx`](./atividade-12/Atividade12_Bug_Hunt.docx)

**Pendente:** anexar os prints/vídeo reais de cada reprodução (campo "Evidência" de cada defeito) — precisam ser capturados rodando o saucedemo.com ao vivo.
