package br.com.frete;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FreteServiceTest {
    private final FreteService service = new FreteService(new CalculadoraFrete());

    @Test
    void deveCalcularCompraFreteETotal() {
        ResumoFrete resumo = service.calcularResumo(new BigDecimal("150.00"));

        assertAll(
            () -> assertEquals(new BigDecimal("150.00"), resumo.valorCompra()),
            () -> assertEquals(new BigDecimal("10.00"), resumo.valorFrete()),
            () -> assertEquals(new BigDecimal("160.00"), resumo.valorTotal())
        );
    }

    @Test
    void compraDe300_deveManterTotalSemFrete_regressao() {
        ResumoFrete resumo = service.calcularResumo(new BigDecimal("300.00"));

        assertEquals(new BigDecimal("300.00"), resumo.valorTotal());
        assertEquals(BigDecimal.ZERO, resumo.valorFrete());
    }
}
