package com.fidalia.conversormonedas.principal;

import com.fidalia.conversormonedas.modelos.MonedaExchance;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el codigo");
        var busqueda = lectura.nextLine();

        String direccion = "https://v6.exchangerate-api.com/v6/9ad04438b72dfa3ae17623fe/latest/"+ busqueda;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

       System.out.println(response.body());

       Gson gson = new Gson();
       //gson.fromJson(json);
        MonedaExchance miMonedaEx = gson.fromJson(json, MonedaExchance.class);
        System.out.println(miMonedaEx);

    }
}

