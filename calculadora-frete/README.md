# Calculadora de Frete

Projeto acadêmico para a disciplina de Testes de Software. Aplicação Java simples para calcular frete com base no valor de uma compra, com testes automatizados.

## Integrantes
- Preencher com os nomes dos integrantes

## Regras de negócio
- Compra maior que R$ 0,00 e menor que R$ 100,00: frete de R$ 20,00.
- Compra de R$ 100,00 até menos de R$ 300,00: frete de R$ 10,00.
- Compra igual ou maior que R$ 300,00: frete grátis.
- Valores nulos, iguais a zero ou negativos são inválidos.
- O total é o valor da compra somado ao frete.

## Tecnologias
- Java 17
- Maven
- JUnit 5
- GitHub Actions

## Estrutura
- `CalculadoraFrete`: aplica as regras e calcula o frete.
- `FreteService`: integra a calculadora e calcula o total.
- `Main`: interação simples no console.
- `src/test`: testes unitários, parametrizados e de integração.

## Executar
Requer Java 17 e Maven.

```bash
mvn test
```

Para executar a aplicação:
1. Compile: `mvn package`
2. Execute a classe `br.com.frete.Main` pelo IntelliJ (ou configure a execução pelo Maven/IDE).

## Técnicas de teste demonstradas
- Particionamento de equivalência
- Análise de valores-limite
- Casos positivos e negativos
- Testes unitários (JUnit 5)
- Teste parametrizado (`@ParameterizedTest` / `@CsvSource`)
- Teste de integração entre `FreteService` e `CalculadoraFrete`
- Teste de regressão para a regra do limite de R$ 300,00

## Qualidade não funcional
Consulte `docs/testes-nao-funcionais.md` para critério de desempenho e confiabilidade.

## Segurança / uso indevido
Entradas nulas, zero e negativas são rejeitadas. Texto não numérico digitado no console é tratado sem encerrar a aplicação abruptamente.

## Integração contínua
GitHub Actions executa `mvn test` ao enviar commits para `main` e em Pull Requests para `main`.
