# Conceitos — Usuário vs. Tester, e Documentação de Requisitos

## Usuário vs. Tester

| | Usuário | Tester |
|---|---|---|
| Objetivo | Completar a tarefa | Encontrar defeitos |
| Postura | Construtiva | "Destrutiva" (de propósito) |
| Método | Uso natural, espontâneo | Planejado, com casos de teste |
| Erro encontrado | Por acaso | De propósito, buscado |
| Conhecimento | Não precisa saber como funciona por dentro | Conhece técnicas (caixa-preta, caixa-branca) e critérios de qualidade |

**Por que os dois importam:** nenhum substitui o outro. Por isso existe o **Teste de Aceitação**: é quando o usuário real testa o sistema para validar se ele atende à necessidade dele, mesmo depois de já ter passado por todos os testes técnicos do tester. O tester garante que "o sistema funciona certo"; o usuário garante que "o sistema resolve o meu problema".

## Documentação de requisitos como proteção

**A pergunta central:** como você prova para o cliente que ele não pediu aquilo que está reclamando agora?

**O processo:**
1. Antes de desenvolver, fazer o **levantamento de requisitos**
2. Mostrar para o cliente e perguntar: "é isso que você precisa?"
3. Ele aprova
4. Desenvolver baseado no que foi **aprovado e documentado**

**Por que isso protege os dois lados:** se lá na frente o sistema falha ou o cliente reclama ("você não me falou disso"), existe **prova documentada** do que foi combinado. Sem isso, vira "ele disse, ela disse".

**Conexão com o Plano de Testes:**
- O plano de testes deve ser baseado nos requisitos que o cliente aprovou
- Isso cria **rastreabilidade**: testa-se exatamente o que foi combinado — nem mais, nem menos
- Isso também vira prova: "eu testei o que você aprovou"

**Limite importante:** mesmo com requisitos bem documentados e testados, o ambiente de teste é controlado — uma condição real de uso pode não aparecer durante o desenvolvimento (ver [casos reais de falhas](./casos-reais-falhas-software.md), especialmente Ariane 5 e Therac-25).
