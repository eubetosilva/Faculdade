# Atividade 3 — Diagnóstico de Qualidade

**Status:** ✅ concluída

Continuação da Atividade 2 (Caça aos Defeitos): relatório técnico avaliando a qualidade dos sites testados (Academy Bugs, The Internet, Sauce Demo) e propondo melhorias priorizadas com base nos 6 defeitos documentados.

## 1. Objetivo

Avaliar a qualidade dos sites analisados na atividade anterior, entender quais defeitos mais prejudicam a experiência do usuário, definir prioridade de correção e propor melhorias.

## 2. Sites avaliados

| Site | Defeitos | Principais problemas | Avaliação |
|---|---|---|---|
| Academy Bugs | 3 | Artigos com erro; pesquisa de produtos com erro; botões de compartilhamento sem funcionamento | Qualidade baixa nas funcionalidades testadas |
| The Internet | 2 | Imagens que não carregam; erro de digitação intermitente | Qualidade moderada |
| Sauce Demo | 1 | Produtos com a mesma imagem incorreta | Qualidade moderada |

## 3. Priorização dos problemas

| Prioridade | ID | Site | Problema | Tipo | Impacto |
|---|---|---|---|---|---|
| 1 | #002 | Academy Bugs | Artigos levam para página de erro | Funcional | Alto |
| 2 | #003 | Academy Bugs | Pesquisa de produto leva para erro | Funcional | Alto |
| 3 | #006 | Sauce Demo | Produtos com imagem incorreta | Interface/Conteúdo | Médio |
| 4 | #004 | The Internet | Imagens não carregam | Interface/Conteúdo | Médio |
| 5 | #001 | Academy Bugs | Botões de compartilhamento não funcionam | Funcional | Baixo |
| 6 | #005 | The Internet | Erro de digitação intermitente | Conteúdo | Baixo |

## 4. Recomendações gerais

1. Testar as principais funções antes da publicação (pesquisa, links, abertura de páginas, finalização de compras)
2. Utilizar testes automatizados para verificar links e funções importantes
3. Verificar se imagens e recursos existem e carregam corretamente
4. Testar novamente após cada correção (regressão)
5. Priorizar funcionalidades principais nos testes

## 5. Conclusão

Os três sites apresentam problemas diferentes de qualidade. O Academy Bugs teve os problemas mais graves (falhas em funções importantes). The Internet teve problemas mais ligados a apresentação/conteúdo. Sauce Demo teve principalmente um problema visual. Correções devem seguir a ordem de impacto: primeiro o que impede funcionalidades principais, depois interface, por último baixo impacto. Testes automatizados e de regressão ajudam a evitar reincidência.

> Relatório completo (avaliação detalhada por site + plano de melhorias) no [arquivo final](./atividade-3/Atividade3_Diagnostico_Qualidade.docx).

> ⚠️ Atenção ao entregar: o arquivo ainda está com o nome de arquivo "Atividade_2..." por engano — o conteúdo interno já diz "ATIVIDADE 3" corretamente. Renomeie o arquivo antes de subir no Ulife pra não confundir com a Atividade 2.
