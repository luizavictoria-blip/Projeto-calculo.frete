package br.com.frete;

import java.math.BigDecimal;

public class FreteService {
    private final CalculadoraFrete calculadoraFrete;

    public FreteService(CalculadoraFrete calculadoraFrete) {
        if (calculadoraFrete == null) {
            throw new IllegalArgumentException("A calculadora de frete é obrigatória.");
        }
        this.calculadoraFrete = calculadoraFrete;
    }

    public ResumoFrete calcularResumo(BigDecimal valorCompra) {
        BigDecimal frete = calculadoraFrete.calcular(valorCompra);
        BigDecimal total = valorCompra.add(frete);
        return new ResumoFrete(valorCompra, frete, total);
    }
}
