# Casos de teste e técnicas

## Classes de equivalência
- CE01 inválida: valor nulo, zero ou negativo — rejeitado.
- CE02 válida: maior que zero e menor que R$ 100 — frete de R$ 20.
- CE03 válida: R$ 100 até menos de R$ 300 — frete de R$ 10.
- CE04 válida: R$ 300 ou mais — frete grátis.

## Valores-limite
- R$ 99,99 / R$ 100,00 / R$ 100,01
- R$ 299,99 / R$ 300,00 / R$ 300,01

## Casos cobertos nos testes automatizados
- Valores representativos das classes válidas.
- Limites exatos e valores imediatamente abaixo/acima.
- Valores inválidos: nulo, zero e negativo.
- Serviço calculando frete e total.
- Integração entre serviço e calculadora.
