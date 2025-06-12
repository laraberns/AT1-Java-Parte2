package infnet.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StatusClient {

    public static void main(String[] args) {
        getStatus();
    }

    private static void getStatus() {
        try {
            System.out.println("========== GET /status ==========");

            URL url = new URL("http://localhost:7002/status");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;

                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }

                    System.out.println("Resposta do servidor:");
                    System.out.println(response.toString());
                }
            } else {
                System.out.println("Erro ao buscar status: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
