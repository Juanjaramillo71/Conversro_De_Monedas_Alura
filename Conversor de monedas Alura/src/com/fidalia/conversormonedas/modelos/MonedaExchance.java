package com.fidalia.conversormonedas.modelos;


import java.util.Map;

public record MonedaExchance( Map<String, Double> conversion_rates) {

    public Double getTasa(String codigoMoneda2) {
        return conversion_rates.get(codigoMoneda2);
    }
}
