package br.com.frete;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FreteIntegracaoTest {
    @Test
    void serviceECalculadoraDevemTrabalharJuntos() {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        FreteService service = new FreteService(calculadora);

        ResumoFrete resultado = service.calcularResumo(new BigDecimal("50.00"));

        assertAll(
            () -> assertEquals(new BigDecimal("50.00"), resultado.valorCompra()),
            () -> assertEquals(new BigDecimal("20.00"), resultado.valorFrete()),
            () -> assertEquals(new BigDecimal("70.00"), resultado.valorTotal())
        );
    }

    @Test
    void componenteRecebidoNulo_deveSerRejeitado() {
        assertThrows(IllegalArgumentException.class, () -> new FreteService(null));
    }
}
