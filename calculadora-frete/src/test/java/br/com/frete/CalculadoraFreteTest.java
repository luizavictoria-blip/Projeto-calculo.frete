package br.com.frete;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {
    private final CalculadoraFrete calculadora = new CalculadoraFrete();

    @Test
    void compraAbaixoDe100_deveCobrar20() {
        assertEquals(new BigDecimal("20.00"), calculadora.calcular(new BigDecimal("50.00")));
    }

    @Test
    void compraEm9999_deveCobrar20() {
        assertEquals(new BigDecimal("20.00"), calculadora.calcular(new BigDecimal("99.99")));
    }

    @Test
    void compraEm100_deveCobrar10() {
        assertEquals(new BigDecimal("10.00"), calculadora.calcular(new BigDecimal("100.00")));
    }

    @Test
    void compraEm10001_deveCobrar10() {
        assertEquals(new BigDecimal("10.00"), calculadora.calcular(new BigDecimal("100.01")));
    }

    @Test
    void compraEm29999_deveCobrar10() {
        assertEquals(new BigDecimal("10.00"), calculadora.calcular(new BigDecimal("299.99")));
    }

    @Test
    void compraEm300_deveTerFreteGratis_regressaoDoLimite() {
        assertEquals(BigDecimal.ZERO, calculadora.calcular(new BigDecimal("300.00")));
    }

    @Test
    void compraAcimaDe300_deveTerFreteGratis() {
        assertEquals(BigDecimal.ZERO, calculadora.calcular(new BigDecimal("500.00")));
    }

    @Test
    void compraZero_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(BigDecimal.ZERO));
    }

    @Test
    void compraNegativa_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(new BigDecimal("-10.00")));
    }

    @Test
    void compraNula_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(null));
    }
}
