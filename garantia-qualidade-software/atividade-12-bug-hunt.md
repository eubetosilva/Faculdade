# Atividade 12 — Bug Hunt: Testes Exploratórios

**Status:** ✅ concluída
**Site escolhido:** [Sauce Demo](https://www.saucedemo.com) — e-commerce de demonstração com usuários diferentes (`standard_user`, `problem_user`, `error_user`, `visual_user`, `performance_glitch_user`, `locked_out_user`), cada um com um comportamento diferente. Escolhido porque os defeitos são reproduzíveis de propósito, trocando só a conta usada no login.

Conteúdo original elaborado pelo Armando, com prints reais de cada reprodução, e padronizado no mesmo template (cabeçalho UAM/Anima) usado nas Atividades 13 e 14.

## Os 5 defeitos encontrados

| ID | Usuário | Defeito | Severidade | Prioridade |
|---|---|---|---|---|
| BUG-001 | standard_user | Campo de CEP aceita caracteres alfabéticos | Média | Média |
| BUG-002 | standard_user | Checkout pode ser concluído com carrinho vazio | Alta | Alta |
| BUG-003 | problem_user | Todos os produtos exibem a mesma imagem (cachorro) | Média | Média |
| BUG-004 | error_user | Descrição do produto não é exibida na página de detalhes | Média | Média |
| BUG-005 | visual_user | Preços, imagem e layout inconsistentes na listagem | Média | Média |

Cada defeito documentado com o template completo (Ambiente, Pré-condição, Passos para Reprodução, Resultado Esperado/Obtido, Severidade, Prioridade, Técnica, Status, Evidência em print real).

> Arquivo final: [`atividade-12/Atividade12_Bug_Hunt.docx`](./atividade-12/Atividade12_Bug_Hunt.docx) · [`Atividade12_Bug_Hunt.pdf`](./atividade-12/Atividade12_Bug_Hunt.pdf) · original do Armando: [`Atividade12_Bug_Hunt_original_Armando.pdf`](./atividade-12/Atividade12_Bug_Hunt_original_Armando.pdf)
