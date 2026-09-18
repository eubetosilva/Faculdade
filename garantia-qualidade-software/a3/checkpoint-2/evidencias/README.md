# Evidências — Checkpoint 2

Prints capturados rodando o sistema localmente (Angular + backend Docker), confirmando os defeitos listados na Matriz de Rastreabilidade e na Análise de Riscos.

| Evidência | Defeito confirmado | Item relacionado |
|---|---|---|
| [`specialties-cirurgiao-duplicado.jpg`](./specialties-cirurgiao-duplicado.jpg) | Tela "Specialties" com `cirurgião` cadastrado duas vezes | `specialities types` — duplicação de disciplinas |
| [`veterinarians-ian-furtado-duplicado.jpg`](./veterinarians-ian-furtado-duplicado.jpg) | Tela "Veterinarians" com `ian furtado` cadastrado duas vezes, ambos com a especialidade `dentistry` | `vet types` — duplicação de veterinários |
| [`pet-types-snake-duplicado-e-numerico.jpg`](./pet-types-snake-duplicado-e-numerico.jpg) | Tela "Pet Types" com `snake` duplicado e `snake 123` (número aceito no nome) | `pet types` — duplicação **e** `pet types alphanumeric` — caractere numérico aceito |
| [`terminal-sistema-rodando-docker-angular.jpg`](./terminal-sistema-rodando-docker-angular.jpg) | Terminal mostrando `ng serve` (Angular) e o backend Spring Boot subindo via Docker na porta 9966 (H2 database, Tomcat) | Evidência de que o ambiente do Checkpoint 1 está de fato funcional |
