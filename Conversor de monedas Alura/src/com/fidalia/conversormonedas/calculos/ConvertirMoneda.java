package com.fidalia.conversormonedas.calculos;

import com.fidalia.conversormonedas.modelos.Moneda;

public class ConvertirMoneda {

    private double ValorConvertido;

    public double getValorConvertido() {
        return ValorConvertido;
    }

    public void incluye (Moneda moneda, Double ars){

    ValorConvertido = moneda.getValoraConvertir() * ars;

    }

}
