package com.alura.conversor.principal;

import java.util.Map;

public record Monedas(Map<String, Double> conversion_rates) {

    @Override
    public Map<String, Double> conversion_rates() {
        return conversion_rates;
    }

}
