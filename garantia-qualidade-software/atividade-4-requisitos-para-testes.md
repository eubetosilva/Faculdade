# Atividade 4 — Requisitos → Testes

**Status:** ✅ concluída

**Sistema avaliado:** Sistema de Gestão de Biblioteca Digital (10 RF + 6 RNF) — [requisitos originais](./atividade-4/requisitos-biblioteca-digital.pdf)

**Objetivo:** transformar requisitos funcionais e não funcionais em condições verificáveis de qualidade e critérios de aceitação testáveis.

**Formato:** dupla, entrega individual no Ulife, PDF, 40 min.

> Arquivo final (pronto para entregar no Ulife): [`atividade-4/Atividade4_Requisitos_para_Testes.pdf`](./atividade-4/Atividade4_Requisitos_para_Testes.pdf) · também disponível em [.docx](./atividade-4/Atividade4_Requisitos_para_Testes.docx) editável.

## Etapas

1. Leitura dos Requisitos — ler e compreender os requisitos fornecidos
2. Classificação e Análise — classificar cada requisito e analisar se está bem especificado
3. Elaboração dos Critérios de Aceitação — transformar cada requisito em critérios testáveis

## Template de entrega

| Requisito | Tipo (RF/RNF) | Está Bem Especificado? | Critérios de Aceitação | Observações |
|---|---|---|---|---|
| RF-001 | RF | Sim/Não | CA-01: ... / CA-02: ... / CA-03: ... | |
| RF-002 | RF | Sim/Não | CA-01: ... | |

## Exemplo de resposta esperada (dado no material)

| Requisito | Tipo | Está Bem Especificado? | Critérios de Aceitação |
|---|---|---|---|
| RF-001 | RF | Não (não especifica formato do e-mail, requisitos de senha) | CA-01: Login com e-mail e senha válidos → redireciona para dashboard · CA-02: Login com e-mail inválido → exibe "Usuário não encontrado" · CA-03: Login com senha inválida → exibe "Senha incorreta" · CA-04: Login com campos vazios → exibe "Preencha todos os campos" · CA-05: Login com e-mail sem @ → exibe "E-mail inválido" |
| RNF-001 | RNF | Não (não define o que é "degradação significativa") | CA-01: Sistema responde em ≤ 5 segundos com 1.000 usuários simultâneos · CA-02: Taxa de erro ≤ 1% durante pico de 1.000 usuários |

## Próximos passos

1. Baixar o PDF de requisitos da atividade no Ulife
2. Classificar cada requisito (RF/RNF) e avaliar especificação
3. Escrever critérios de aceitação testáveis pra cada um
