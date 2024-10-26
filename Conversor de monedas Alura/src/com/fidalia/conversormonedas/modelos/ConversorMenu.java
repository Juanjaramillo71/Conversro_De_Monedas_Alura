package com.fidalia.conversormonedas.modelos;

import com.fidalia.conversormonedas.calculos.ConvertirMoneda;
import com.fidalia.conversormonedas.servicios.ServicioExchance;
import com.google.gson.Gson;
import java.net.http.HttpClient;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMenu {

    public static void displayConsoleMenu() {
        System.out.println("*******************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println();
        System.out.println("1) Dólar ==> Peso argentino");
        System.out.println("2) Peso argentino ==> Dólar");
        System.out.println("3) Dólar ==> Real brasileño");
        System.out.println("4) Real brasileño ==> Dólar");
        System.out.println("5) Dólar ==> Peso colombiano");
        System.out.println("6) Peso colombiano ==> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("*******************************************************");

    }

    public void menuCase(String nom, String cod_1, String cod_2) {

        System.out.println("Ingrese el valor que desea convertir");
        Scanner scanner = new Scanner(System.in);
        double valor = scanner.nextDouble();
        Moneda miMoneda = new Moneda(nom, cod_1, valor);
        ServicioExchance servicio = new ServicioExchance();
        MonedaExchance resultado = servicio.obtenerTasaDeCambio(cod_1);
        Double tasa = resultado.getTasa(cod_2);

        ConvertirMoneda convertir = new ConvertirMoneda();
        convertir.incluye(miMoneda, tasa);
        //System.out.println("El valor de " + valor + "[" + cod_1 + "]" + "corresponde al valor final de >>>" + convertir.getValorConvertido() + "[" + cod_2 + "]");

        System.out.printf("El valor de %.2f [%s] corresponde al valor final de >>> %.2f [%s]%n", valor, cod_1, convertir.getValorConvertido(), cod_2);


    }


}
