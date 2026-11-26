# Regras de negócio — Calculadora de Frete

| Código | Regra | Resultado |
|---|---|---|
| R1 | Compra maior que R$ 0 e menor que R$ 100 | Frete R$ 20 |
| R2 | Compra de R$ 100 até menos de R$ 300 | Frete R$ 10 |
| R3 | Compra igual ou maior que R$ 300 | Frete grátis |
| R4 | Compra nula, zero ou negativa | Rejeitar com erro |
| R5 | Total da compra | Valor da compra + frete |

Valores monetários são representados com `BigDecimal` para evitar problemas de precisão de ponto flutuante.
