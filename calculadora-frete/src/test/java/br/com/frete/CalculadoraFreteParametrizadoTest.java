package br.com.frete;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraFreteParametrizadoTest {
    private final CalculadoraFrete calculadora = new CalculadoraFrete();

    @ParameterizedTest
    @CsvSource({
        "50.00, 20.00",
        "99.99, 20.00",
        "100.00, 10.00",
        "150.00, 10.00",
        "299.99, 10.00",
        "300.00, 0.00",
        "300.01, 0.00",
        "1000.00, 0.00"
    })
    void deveCalcularFreteParaVariosValores(String compra, String freteEsperado) {
        assertEquals(
                0,
                new BigDecimal(freteEsperado).compareTo(
                        calculadora.calcular(new BigDecimal(compra))
                )
        );
    }
}
