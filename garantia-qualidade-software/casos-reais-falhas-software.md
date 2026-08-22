# Casos Reais de Falhas de Software

Estudos de caso usados na Unidade 1 (Fundamentos da Qualidade de Software) para ilustrar o custo real de falta de qualidade.

## Caso 1 — Foguete Ariane 5 (1996): o erro de conversão de dados

**Contexto:** o foguete europeu Ariane 5 explodiu 40 segundos após o lançamento, em sua missão inaugural. Prejuízo de **US$ 370 milhões**.

**Causa raiz:** um erro de software. O sistema de navegação inercial tentou converter um número de ponto flutuante de 64 bits para um inteiro de 16 bits. O valor era grande demais para o inteiro, causando um *overflow* e uma exceção que não foi tratada. O sistema de backup (que deveria ser redundante) compartilhava o mesmo código defeituoso e também falhou.

**Lições aprendidas:**
- A importância de testes de estresse e validação de limites
- Tratamento adequado de exceções e erros
- Redundância só é eficaz se não compartilhar as mesmas falhas
- O custo de um bug pode ser astronômico (literalmente)

## Caso 2 — Therac-25 (1985-1987): o erro que matou pessoas

**Contexto:** um acelerador linear de radioterapia (Therac-25) causou superdosagens de radiação em pacientes, resultando em **pelo menos 6 mortes** e várias pessoas gravemente feridas.

**Causa raiz:** uma *race condition* (condição de corrida) no software. O operador digitava comandos muito rapidamente, e o sistema não estava sincronizado corretamente. A máquina liberava o feixe de elétrons de alta potência sem o acessório de espalhamento, atingindo o paciente com uma dose letal. A interface do usuário não apresentava mensagens de erro claras, e os operadores muitas vezes ignoravam os avisos.

**Lições aprendidas:**
- A qualidade de software pode ser uma questão de vida ou morte
- A importância de testes em sistemas críticos (segurança)
- O design de interface deve prevenir erros, não apenas reportá-los
- A responsabilidade ética do engenheiro de software

## Caso 3 — Knight Capital Group (2012): o erro que custou US$ 440 milhões em 45 minutos

**Contexto:** uma empresa de trading financeiro, Knight Capital, perdeu **US$ 440 milhões em 45 minutos** devido a um bug de software. A empresa quase faliu e acabou sendo adquirida.

**Causa raiz:** um erro em uma atualização de software. Um desenvolvedor modificou o código de um sistema de roteamento de ordens, mas não atualizou uma flag de ativação em um dos 8 servidores. Quando o sistema foi reiniciado, o código antigo e o novo entraram em conflito, enviando ordens de compra e venda em loop, causando milhões de transações errôneas.

**Lições aprendidas:**
- A importância de testes de regressão e integração contínua
- O impacto de deploy mal feito e configuração de servidores
- A necessidade de testes automatizados para detectar regressões
- Rollback e planos de contingência são essenciais

## O padrão comum

Nos três casos, o software **funcionou nos testes** — o problema só apareceu em uma condição real que o ambiente de teste não reproduziu (velocidade real de lançamento, velocidade de digitação de um operador experiente, um servidor específico não atualizado). **Testar bem não garante 100% contra o imprevisto real.**
