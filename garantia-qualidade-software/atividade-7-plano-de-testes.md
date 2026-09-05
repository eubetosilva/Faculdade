# Atividade 7 — Plano de Testes

**Status:** ✅ concluída

**Sistema:** Sistema de Gestão de Biblioteca Digital (mesmo da Atividade 4)

**Objetivo oficial:** Elaborar um Plano de Testes completo incluindo a definição de Cenários de Teste de alto nível, que servirão de base para os Casos de Teste da Atividade 8.

**Template (7 seções):** Escopo · Estratégia · Ambiente · Responsáveis · Riscos · Critérios de Entrada/Saída · Cenários de Teste (mínimo 8, com prioridade Alta/Média/Baixa)

## Resumo do conteúdo

- **Escopo:** 7 itens testados (cadastro, login, busca, reserva, histórico, administração, performance) + 3 itens fora de escopo com justificativa (pagamento/multas, integração externa, pentest)
- **Estratégia:** 5 níveis de teste (Unidade, Integração, Sistema/E2E, Aceitação/UAT, Não funcional)
- **Ambiente:** homologação p/ 500 usuários, navegadores, SO, PostgreSQL, massa de dados, ferramentas
- **Responsáveis:** Líder de Testes, Analista de Testes/QA, Desenvolvedor(a), Product Owner/Professor(a)
- **Riscos:** 5 riscos mapeados (performance, dados inconsistentes, atraso de ambiente, indisponibilidade do banco, race condition na reserva) com plano de mitigação
- **Critérios de Entrada/Saída:** ambiente configurado + massa validada + casos revisados → 100% cenários Alta aprovados + zero defeitos críticos + cobertura ≥ 90%
- **12 Cenários de Teste** (acima do mínimo de 8), cobrindo todas as funcionalidades + o requisito de performance

> Arquivo final: [`atividade-7/Atividade7_Plano_de_Testes.pdf`](./atividade-7/Atividade7_Plano_de_Testes.pdf)
