# Atividade 1 — Diagnóstico de Qualidade: App 99

**Status:** ✅ concluída e entregue

> ⚠️ O RA do Alberto estava com um dígito errado no PDF original (12525178736). Corrigido para **12525178737** na planilha em [`atividade-1/Atividade1_99_QualidadeSoftware_RA_corrigido.xlsx`](./atividade-1/Atividade1_99_QualidadeSoftware_RA_corrigido.xlsx) — exportar essa versão em PDF antes de reenviar ao Ulife.

Análise do aplicativo 99 (mobilidade urbana) com base na ISO/IEC 25010.

## 1. Identificação

- **Software:** 99 — aplicativo de mobilidade urbana
- **Desenvolvedor:** 99 Tecnologia (grupo DiDi)
- **Propósito:** conectar passageiros a motoristas parceiros para corridas de carro/moto, além de serviços como pagamentos digitais (99Pay)

## 2. Atributos de Qualidade (ISO 25010)

| Atributo | Nota | Justificativa |
|---|---|---|
| Funcionalidade | 4 | Cumpre a proposta de solicitar corrida, estimar rota e preço e efetuar pagamento; em algumas situações a rota sugerida pode não ser a melhor |
| Confiabilidade | 3 | Em geral estável, mas pode perder conexão ou ter dificuldade de atualização em locais com sinal fraco; cancelamentos afetam a previsibilidade |
| Usabilidade | 5 | Interface simples e intuitiva, poucos passos para solicitar a corrida |
| Eficiência | 4 | Localiza motoristas e calcula rotas com rapidez, mas o uso contínuo de GPS consome bateria e dados |
| Manutenibilidade | 4 | Como usuário não é possível avaliar o código diretamente; updates frequentes sugerem correções ativas |
| Portabilidade | 5 | Disponível para Android e iOS, funções principais consistentes nos dois sistemas |
| Segurança | 4 | Possui autenticação, compartilhamento de rota e recursos de emergência; dados de localização e pagamento sempre exigem cuidado |

**Média das notas: 4.1**

## 3. Experiência do Usuário

- **Geral:** boa; prático no dia a dia, principalmente para corridas
- **Situação positiva:** fácil solicitar e acompanhar a chegada do motorista
- **Situação negativa:** motoristas demoram a atualizar status; app às vezes não encontra motorista durante 10+ minutos

## 4. Impacto do Software

- **Usuários:** frota limitada fora de São Paulo/Grande ABC afeta acessibilidade
- **Empresa:** impacto via órgãos reguladores (Procon, Reclame Aqui)
- **Sociedade:** muita gente depende do app para mobilidade — indisponibilidade ampla afetaria deslocamento e segurança dos usuários
