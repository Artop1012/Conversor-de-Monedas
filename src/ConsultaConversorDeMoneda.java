import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversorDeMoneda {
    public Moneda buscaConversion(String monedaActual, String monedaACambiar) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b3016aa9d0652c0654c36871/pair/"
                + monedaActual + "/" + monedaACambiar);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa tipo de monedas.");
        }
    }
}
