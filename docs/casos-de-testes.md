# Documentação de Testes — Calculadora de Frete

Este documento detalha as regras de negócio, estratégias de seleção de dados, casos de teste executados e técnicas aplicadas na validação da calculadora de frete do sistema.

---

## 3.1 Regras de negócio

As regras abaixo definem o comportamento esperado do sistema para o cálculo do frete e do valor total da compra:

| Regra | Descrição |
| :--- | :--- |
| **R1** | Compras abaixo de R$ 100,00 possuem frete de R$ 20,00. |
| **R2** | Compras entre R$ 100,00 e R$ 299,99 possuem frete de R$ 10,00. |
| **R3** | Compras a partir de R$ 300,00 possuem frete grátis. |
| **R4** | Valores negativos não são permitidos. |
| **R5** | O total da compra é o valor da compra somado ao frete. |

---

## 3.2 Classes de equivalência

Para otimizar os testes sem precisar testar infinitos números, os valores de entrada foram divididos em grupos (classes) onde o sistema deve apresentar o mesmo comportamento:

| Classe | Valores | Comportamento esperado |
| :--- | :--- | :--- |
| **CE01** | Valores maiores que zero e menores que R$ 100,00 | Frete de R$ 20,00 |
| **CE02** | Valores de R$ 100,00 até R$ 299,99 | Frete de R$ 10,00 |
| **CE03** | Valores de R$ 300,00 ou mais | Frete grátis (R$ 0,00) |
| **CE04** | Valores negativos | Entrada inválida (Mensagem de erro) |

---

## 3.3 Valores-limite

Os valores abaixo foram selecionados por estarem exatamente nas fronteiras (limites) onde ocorre a mudança de regra. O objetivo é verificar se a transição entre as faixas de preço acontece no ponto exato, evitando erros de operadores matemáticos (como usar `<` no lugar de `<=`).

| Valor testado | Resultado esperado |
| :--- | :--- |
| R$ 99,99 | Frete de R$ 20,00 |
| R$ 100,00 | Frete de R$ 10,00 |
| R$ 100,01 | Frete de R$ 10,00 |
| R$ 299,98 | Frete de R$ 10,00 |
| R$ 299,99 | Frete de R$ 10,00 |
| R$ 300,00 | Frete grátis |
| R$ 300,01 | Frete grátis |

---

## 3.4 Casos de teste formais

Abaixo estão os casos de teste executados para validar o funcionamento da calculadora:

| ID | Descrição | Entrada | Resultado esperado | Resultado obtido | Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **CT01** | Compra abaixo de R$ 100 | 50 | Frete 20 | Frete 20 | Aprovado |
| **CT02** | Compra no limite de R$ 100 | 100 | Frete 10 | Frete 10 | Aprovado |
| **CT03** | Compra intermediária | 150 | Frete 10 | Frete 10 | Aprovado |
| **CT04** | Compra no limite de R$ 300 | 300 | Frete 0 | Frete 0 | Aprovado |
| **CT05** | Compra acima de R$ 300 | 500 | Frete 0 | Frete 0 | Aprovado |
| **CT06** | Valor negativo | -10 | Rejeitar | Mensagem de erro | Aprovado |

---

## 3.5 Técnicas utilizadas

Para garantir a qualidade do sistema, diferentes abordagens de teste foram aplicadas:

* **Teste unitário:** É o teste focado na menor parte isolada do código, como uma única função. *Na calculadora:* foi utilizado para testar isoladamente a função que recebe o valor da compra e retorna apenas o valor do frete.
* **Teste parametrizado:** Permite executar o mesmo teste várias vezes utilizando uma lista de diferentes entradas e saídas esperadas, sem repetir código. *Na calculadora:* foi usado para rodar vários valores de compra de uma só vez (como todos os valores-limite) dentro da mesma rotina de teste.
* **Classes de equivalência:** Técnica que divide os dados de entrada em grupos que geram o mesmo resultado, evitando testes redundantes. *Na calculadora:* ajudou a definir as quatro faixas principais (abaixo de 100, entre 100 e 299,99, acima de 300 e negativos) para escolher representantes de cada grupo.
* **Análise de valores-limite:** Foca em testar os valores exatos onde uma regra muda para outra, pois é onde os programadores mais cometem erros. *Na calculadora:* foi aplicada nos pontos de virada R$ 99,99 / R$ 100,00 e R$ 299,99 / R$ 300,00.
* **Teste de integração:** Verifica se diferentes partes do sistema funcionam bem juntas. *Na calculadora:* validou se o módulo que calcula o frete se comunica corretamente com a parte que soma o frete ao valor dos produtos para gerar o total final (Regra R5).
* **Teste de regressão:** Consiste em rodar novamente os testes antigos sempre que o código é modificado, garantindo que nada que já funcionava quebrou. *Na calculadora:* executado após ajustes ou correções no código para confirmar que todas as regras (R1 a R5) continuavam passando.
* **Testes manuais:** São testes feitos diretamente por uma pessoa usando a interface ou o terminal do programa, sem automação. *Na calculadora:* utilizados para digitar valores reais na tela/console e verificar visualmente se as mensagens de erro e os totais apareciam de forma clara para o usuário.
