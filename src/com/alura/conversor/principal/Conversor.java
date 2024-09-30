package com.alura.conversor.principal;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Monedas conversorMonedas() {


            String enlace = "https://v6.exchangerate-api.com/v6/0fd922dbffb7294d086df908/latest/USD";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enlace))
                    .build();

        try {

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (Exception e) {

            throw new RuntimeException("Ocurrio un error" + e.getMessage());

        }
    }
}
