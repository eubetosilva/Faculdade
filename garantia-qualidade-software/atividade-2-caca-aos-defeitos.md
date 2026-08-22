# Atividade 2 — Caça aos Defeitos

**Status:** ✅ concluída (6 defeitos, 3 sites)

Sites explorados: **Academy Bugs**, **The Internet**, **Sauce Demo**.

## Resumo dos defeitos

| ID | Título | Tipo | Impacto |
|---|---|---|---|
| #001 | Compartilhamento não abre rede social | Funcional | Baixo |
| #002 | Artigos direcionam para página de erro | Funcional | Alto |
| #003 | Pesquisa de produto leva a erro | Funcional | Alto |
| #004 | Imagens de exemplo não carregam | Interface / Conteúdo | Médio |
| #005 | Erro de digitação intermitente | Conteúdo | Baixo |
| #006 | Produtos exibem a mesma imagem incorreta | Interface / Conteúdo | Médio |

## Defeito escolhido para apresentação (3 min): #002

- **Contexto:** no Academy Bugs, a página de artigos exibe imagens, títulos e o link "Read More", indicando que o usuário pode acessar o conteúdo completo
- **Reprodução:** ao clicar em qualquer um desses elementos, o site não abre o artigo e leva a uma página de erro
- **Gravidade:** alta — a função principal da área de artigos fica indisponível
- **Correção sugerida:** revisar os links/identificadores dos artigos, garantir que cada card aponte para uma rota existente, incluir teste automatizado que valide todas as URLs publicadas

## Conclusão

O defeito #002 é o mais grave entre os encontrados porque impede completamente o acesso aos artigos e afeta diretamente a funcionalidade do site.

> Relatório completo (todas as 6 tabelas de defeito com passos, comportamento esperado/observado e evidências) nos arquivos entregues no Ulife.
