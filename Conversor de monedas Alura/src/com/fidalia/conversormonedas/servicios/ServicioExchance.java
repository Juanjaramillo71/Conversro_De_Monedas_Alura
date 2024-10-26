package com.fidalia.conversormonedas.servicios;
import com.fidalia.conversormonedas.modelos.MonedaExchance;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioExchance {
    private static final String API_KEY = "9ad04438b72dfa3ae17623fe";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient client;
    private final Gson gson;

    public ServicioExchance() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public MonedaExchance obtenerTasaDeCambio(String codigoMoneda) {
        try {
            String url = BASE_URL + API_KEY + "/latest/" + codigoMoneda;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            // Para debugging
            //System.out.println("Respuesta de la API: " + json);

            return gson.fromJson(json, MonedaExchance.class);

        } catch (Exception e) {
            System.err.println("Error al obtener tasa de cambio: " + e.getMessage());
            throw new RuntimeException("Error al consultar el servicio de tipo de cambio", e);
        }
    }

}
