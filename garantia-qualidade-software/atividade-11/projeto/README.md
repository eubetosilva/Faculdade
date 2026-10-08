# Atividade 11 - Analise estatica e refatoracao

Entregaveis: `antes/` (codigo original, compilavel), `depois/src/ProcessadorPagamento.java` (codigo refatorado), `config/` (regras fixas para reproduzir as analises), `relatorios/` (XML, JSON, logs e resumo das ferramentas), `testes/` (regressao), e `Relatorio-AT11.pdf` (tabelas preenchidas).

## Reproduzir

No Mac que recebeu esta atividade, abra `antes/` ou `depois/` no VS Code e confira `.vscode/settings.json`. O Java 21, Extension Pack for Java, Checkstyle for Java, SpotBugs, Semgrep e SonarQube for IDE foram instalados. A pasta precisa estar confiavel no VS Code para ativar as extensoes.

Para repetir compilacao, analises e testes do projeto completo execute `python3 validar.py` no terminal desta pasta. O script usa Checkstyle 9.3 (o jar local da extensao), SpotBugs 4.10.4 e Semgrep 1.179.0, mais duas regras locais Semgrep explicitamente documentadas em `config/semgrep.yaml`. As mesmas versoes e regras sao aplicadas ao codigo original e refatorado.

No painel Problems do VS Code, o Checkstyle reporta 5 ocorrencias no original e 0 no refatorado. Os contadores pontuais de Semgrep e SpotBugs estao preservados em `relatorios/`. O SonarQube for IDE e a linguagem Java podem gerar diagnosticos suplementares; a tabela compara apenas a ferramenta indicada em cada coluna.

## Criterios

A atividade solicita quatro espacos, mas o perfil Google original usa dois. `config/google-4-espacos.xml` preserva as regras Google e ajusta apenas a indentacao para quatro espacos, como pede o roteiro. O projeto usa exatamente essa configuracao nas duas versoes. `config/google-original.xml` tambem permite reproduzir a contagem sem ajuste, que nao e a usada na comparacao principal.

O exemplo do PDF troca SHA-256 simples por SHA-256, mas ainda guarda `admin123` e considera uma senha fixa hardcoded. A refatoracao remove qualquer senha padrao do codigo; recebe hash e salt do cadastro e verifica com PBKDF2-HMAC-SHA256, salt aleatorio e 600.000 iteracoes. Isso segue a recomendacao publicada pela OWASP (Password Storage Cheat Sheet). A configuracao de hash precisa vir do cadastro e armazenamento seguro em uma aplicacao real.

A atividade original exige cartao de 16 caracteres para todas as formas, inclusive PIX. Essa regra foi preservada para a comparacao de comportamento, e a limitacao esta documentada no Javadoc. O formato monetario tambem segue o exemplo academico.

## Arquivos

- `antes/src/ProcessadorPagamento.java`: codigo extraido do AT11.pdf; preservado como referencia local.
- `depois/src/ProcessadorPagamento.java`: versao refatorada, com early returns, metodo extraido, constantes, Javadoc, quatro espacos e verificacao de senha sem segredo fixo.
- `testes/TesteAt11.java`: 230 verificacoes, incluindo 168 combinacoes de pagamento comparadas a versao original, 40 combinacoes de desconto, fronteiras e validacao de credencial. A senha do teste e aleatoria, em memoria, e nao e gravada no projeto.
- `Relatorio-AT11.pdf`: registro de problemas e comparacao antes/depois.
- `relatorios/antes-checkstyle.xml` e `relatorios/depois-checkstyle.xml`: problemas de estilo usados na tabela.
- `relatorios/antes-spotbugs.xml` e `relatorios/depois-spotbugs.xml`: resultados de bytecode.
- `relatorios/antes-semgrep.json` e `relatorios/depois-semgrep.json`: resultados das regras locais.
- `relatorios/antes-metricas.xml` e `relatorios/depois-metricas.xml`: complexidade, profundidade e numeros magicos.
