package br.com.frete;

import java.math.BigDecimal;

public record ResumoFrete(BigDecimal valorCompra, BigDecimal valorFrete, BigDecimal valorTotal) {
}
