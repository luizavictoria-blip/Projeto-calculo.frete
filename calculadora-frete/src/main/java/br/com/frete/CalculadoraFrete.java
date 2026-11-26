package br.com.frete;

import java.math.BigDecimal;

public class CalculadoraFrete {
    private static final BigDecimal LIMITE_100 = new BigDecimal("100.00");
    private static final BigDecimal LIMITE_300 = new BigDecimal("300.00");
    private static final BigDecimal FRETE_20 = new BigDecimal("20.00");
    private static final BigDecimal FRETE_10 = new BigDecimal("10.00");

    public BigDecimal calcular(BigDecimal valorCompra) {
        if (valorCompra == null || valorCompra.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da compra deve ser maior que zero.");
        }

        if (valorCompra.compareTo(LIMITE_100) < 0) {
            return FRETE_20;
        }
        if (valorCompra.compareTo(LIMITE_300) < 0) {
            return FRETE_10;
        }
        return BigDecimal.ZERO;
    }
}
