# MER — Sistema de Aluguel de Carro

Modelo Entidade-Relacionamento (notação Chen) para um sistema de locadora de veículos.

## Entidades e atributos

**Cliente**
- PK: `id_cliente`
- nome, cpf/cnpj, telefone, email, endereço, tipo (PF/PJ)

**Veículo**
- PK: `id_veiculo`
- placa, modelo, marca, categoria, ano, cor, status (disponível/alugado/manutenção)

**Locadora**
- PK: `id_locadora`
- nome, endereço, cidade, telefone

**Vendedor** (funcionário que atende a locação)
- PK: `id_vendedor`
- nome, cpf, cargo

## Relacionamento — Aluguel (entidade associativa)

Como conecta mais de duas entidades e tem atributos próprios, `Aluguel` é modelado como entidade associativa, não só um losango de relacionamento:

**Aluguel**
- PK: `id_aluguel`
- FK: `id_cliente`, `id_veiculo`, `id_vendedor`, `id_locadora`
- data_retirada, data_devolucao_prevista, data_devolucao_real
- valor_diaria, valor_total, km_inicial, km_final, status

## Cardinalidades

| Relacionamento | Cardinalidade |
|---|---|
| Cliente → Aluguel | 1:N |
| Veículo → Aluguel | 1:N |
| Vendedor → Aluguel | 1:N |
| Locadora → Aluguel | 1:N |
| Locadora → Veículo | 1:N |
| Locadora → Vendedor | 1:N |

## Versão simplificada

Para um exercício mais simples, o essencial é: `Cliente` + `Veículo` ligados por `Aluguel` (com `data_retirada`, `data_devolucao`, `valor`). `Locadora` e `Vendedor` são opcionais dependendo do escopo pedido.
