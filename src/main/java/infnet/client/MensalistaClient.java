package infnet.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MensalistaClient {

    public static void main(String[] args) {
        postMensalista();
        getMensalistas();
        getMensalistaById(1234);
    }

    private static void postMensalista() {
        try {
            System.out.println("========== POST Mensalista ==========");

            URL url = new URL("http://localhost:8000/funcionarios/mensalista");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = """
            {
                "matricula": 6789,
                "nome": "Cecilia Ferreira",
                "cargo": "Arquiteta",
                "salario": 7896.0
            }
            """;

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("POST - Código de resposta: " + responseCode);

            connection.disconnect();

            System.out.println("=====================================\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getMensalistas() {
        try {
            System.out.println("========== GET Todos Mensalistas ==========");

            URL url = new URL("http://localhost:8000/funcionarios/mensalistas");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("GET - Código de resposta: " + responseCode);

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
                System.out.println("Erro ao buscar mensalistas: " + responseCode);
            }

            connection.disconnect();

            System.out.println("==========================================\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getMensalistaById(long id) {
        try {
            System.out.println("========== GET Mensalista por ID ==========");

            URL url = new URL("http://localhost:8000/funcionarios/mensalista/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("GET by ID - Código de resposta: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;

                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }

                    System.out.println("Resposta do servidor (por ID):");
                    System.out.println(response.toString());
                }
            } else {
                System.out.println("Erro ao buscar mensalista por ID: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
