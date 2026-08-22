# Resumo — ISO/IEC 9126 e ISO/IEC 25010

> Guia de estudo interativo (passo a passo, com checklist): https://claude.ai/code/artifact/decbf31c-0fd5-442f-8878-175bdcec1800

## ISO/IEC 9126 (modelo antigo — 6 características)

Mnemônico: **F-C-U-E-M-P**

1. **Funcionalidade** — faz o que deveria fazer
2. **Confiabilidade** — não falha, se recupera
3. **Usabilidade** — fácil de usar
4. **Eficiência** — usa bem tempo e recursos
5. **Manutenibilidade** — fácil de corrigir e alterar
6. **Portabilidade** — fácil de mudar de ambiente

Cada uma se divide em subcaracterísticas, e todas têm um subitem final de "Conformidade".

Também define: **qualidade interna** (olha o código) vs. **externa** (olha o software rodando), e o ciclo de vida: **processo → interna → externa → em uso**.

## ISO/IEC 25010 (versão usada em aula — 9 características)

Os 8 nomes originais + **Capacidade de Interação** (nova em 2023).

| # | Característica | Pergunta-chave | Exemplo |
|---|---|---|---|
| 1 | Adequação Funcional | O software faz o que deveria fazer? Atende às necessidades? | Função de busca encontra produtos corretamente |
| 2 | Confiabilidade | O software funciona sem falhas? É estável? | Sistema não trava durante o uso |
| 3 | Usabilidade | O software é fácil de aprender e usar? | Interface intuitiva, botões bem posicionados |
| 4 | Eficiência de Desempenho | O software é rápido e usa recursos adequadamente? | Páginas carregam em menos de 3 segundos |
| 5 | Segurança | O software protege dados e resiste a ataques? | Dados criptografados, autenticação de usuários |
| 6 | Compatibilidade | O software se integra bem com outros sistemas? | Funciona com APIs externas, compartilha dados |
| 7 | Manutenibilidade | O software é fácil de modificar e corrigir? | Código organizado, fácil de adicionar novas funções |
| 8 | Portabilidade | O software funciona em diferentes ambientes? | Funciona no Chrome, Firefox, Edge e em celulares |
| 9 | **Capacidade de Interação** (nova, 2023) | Quão bem os usuários conseguem interagir com o software? | Acessibilidade para pessoas com deficiência |

> Nota: a norma oficial completa (ISO.org) descreve uma reestruturação um pouco diferente (renomeia Usabilidade→Capacidade de Interação, Portabilidade→Flexibilidade, e adiciona Safety como 9ª característica). A tabela acima segue a versão simplificada usada em aula, que é a que vale pra prova.
