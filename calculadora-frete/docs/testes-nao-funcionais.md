# Testes não funcionais

## Desempenho
**Risco/preocupação:** cálculo de frete deve ser rápido para uma entrada individual.

**Medição:** medir o tempo de execução do método de cálculo com `System.nanoTime()` em execução local.

**Critério de aceitação sugerido:** cálculo individual deve terminar em menos de 100 ms no ambiente de execução da equipe.

**Observação:** este critério é uma verificação simples para o trabalho acadêmico, não um benchmark formal.

## Confiabilidade
**Preocupação:** as regras devem produzir o resultado correto e entradas inválidas devem ser rejeitadas.

**Verificação:** execução da suíte automatizada JUnit.

**Critério de aceitação:** todos os testes da suíte devem passar; entradas nulas, zero e negativas não podem gerar cálculo de frete válido.
