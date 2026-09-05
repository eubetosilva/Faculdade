# Aula 4 — Plano, Cenários e Casos de Teste

## Ciclo de Testes (5 etapas, contínuo)

1. **Planejar** — definir objetivos, escopo, estratégia e recursos de teste
2. **Projetar Testes** — criar cenários, casos de teste e dados necessários
3. **Preparar Ambiente** — configurar ambiente, ferramentas e dados de teste
4. **Executar Testes** — executar os casos de teste e registrar os resultados
5. **Avaliar Resultados** — analisar resultados, identificar defeitos e riscos

→ **Melhoria Contínua**: feedback pra melhorar o produto e o processo de testes (volta pro passo 1)

**Por que é um ciclo?** Porque o processo não termina na execução — resultados geram feedback: defeitos são corrigidos, novos testes são criados, testes anteriores são executados novamente. Testar não é só procurar erros; é um processo contínuo de verificação e melhoria.

## Os 3 artefatos (e como se relacionam)

| Artefato | Nível | Pergunta que responde |
|---|---|---|
| **Plano de Teste** | Estratégia/Gerencial | Como vamos organizar a qualidade? |
| **Cenário de Teste** | Visão de Negócio | O QUE precisa ser testado? |
| **Caso de Teste** | Detalhamento Técnico | COMO testar exato: passos, dados e resposta? |

### Plano de Teste (Test Plan)
Documento estratégico e gerencial que planeja, orienta e organiza todo o processo de testes. Responde: o que será testado, como, por quem, em qual ambiente, com quais critérios de sucesso.

Seções: Escopo · Estratégia e Abordagem · Ambiente e Ferramentas · Riscos e Contingências · Critérios de Aceitação (Entrada e Saída).

### Cenário de Teste
Descrição em alto nível de uma condição/funcionalidade/fluxo que precisa ser testado — sem se preocupar com o "como" ainda. Objetivo: mapear fluxos de negócio, garantir que nenhuma regra importante fique sem cobertura. Sucinto, compreensível por desenvolvedores, testadores, gestores e clientes.

Exemplo: *Cenário 1: Transferência via Pix com saldo suficiente.*

### Caso de Teste (Test Case)
Artefato operacional e detalhado, derivado de um Cenário de Teste. Instrui o testador (ou script automatizado) sobre como executar a validação.

**3 abordagens de elaboração:**
- **Positivos (Happy Path):** fluxo principal, dados válidos, condições normais
- **Negativos:** fluxos alternativos/exceção, dados inválidos/incompletos
- **Fronteira (Boundary/Valor Limite):** valores nas extremidades (mínimo, máximo, no limite, abaixo/acima do limite)

**Estrutura padrão de um Caso de Teste:**

| Campo | Descrição |
|---|---|
| ID do Caso de Teste | Identificador único |
| Cenário de Teste Relacionado | ID/título do cenário do qual deriva |
| Título / Objetivo | Ação específica que o caso valida |
| Pré-condições | Estado que deve existir ANTES de rodar o teste |
| Dados de Teste | Informações exatas de entrada |
| Passos para Execução | Sequência passo a passo |
| Resultado Esperado | Comportamento que o software deve apresentar |
| Pós-condições | Estado que deve existir DEPOIS do teste |
| Resultado Obtido | (preenchido na execução) |
| Status | (preenchido na execução) |

**Pré-condição vs. Pós-condição:** pré = o que precisa existir ANTES (ex: ter saldo em conta); pós = o que deve mudar/ser preservado DEPOIS (ex: saldo deduzido, log criado).

## Execução Controlada

1. **Resultado Esperado × Resultado Obtido** — a divergência entre os dois caracteriza uma falha/defeito (bug)
2. **Evidências** (Prints, Logs, Vídeos) — prova documental do comportamento, garante auditabilidade
3. **Status da Execução:**
   - **Passed (Passou):** resultado obtido = esperado
   - **Failed (Falhou):** diverge do esperado, gera relatório de defeito
   - **Blocked (Bloqueado):** não pôde ser concluído por fator externo (ex: botão quebrado, servidor caiu)
   - **Not Executed (Não Executado):** planejado mas ainda não rodado
4. **Rastreabilidade de execução:** `Requisito → Critérios de Aceitação → Caso de Teste → Resultado/Bug` — permite responder "se o CT-005 falhou, qual requisito ficou comprometido?" e garante que nenhum requisito fique sem teste associado.

## Cadeia de Causa e Efeito (ISO/IEC/IEEE 24765, 29119-1, Glossário ISTQB)

```
[ERRO HUMANO] → cometido por um ser humano → [DEFEITO/BUG] → fica oculto no código → [FALHA]
  (Ação/Equívoco)                            (Imperfeição no artefato)      (Comportamento visível)
```

- **Erro (Error/Mistake):** ação humana incorreta (desenvolvedor, analista, designer). Ex: usar `>` em vez de `>=` no limite de idade.
- **Defeito (Defect)/Bug:** imperfeição física ou lógica no artefato, decorrente de um erro. "Bug" é só a gíria de mercado pra "Defeito" — mesma coisa. Pode ficar oculto por meses sem ser executado.
- **Falha (Failure):** desvio visível no comportamento do software em relação ao esperado, durante a execução. É quando o sistema "quebra", responde errado ou paralisa.

## Conclusão da aula

Plano de Teste (documento gerencial) → Cenário de Teste (visão de negócio, alto nível) → Caso de Teste (detalhamento técnico) → Execução Controlada (rodar, registrar resultado obtido × esperado, evidenciar, rastrear).
