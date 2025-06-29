package Task2_REST_API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class RestApiClient {
    public static void main(String[] args) {
        try {
            // API endpoint for random user data
            String apiUrl = "https://randomuser.me/api/";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray results = jsonResponse.getJSONArray("results");
                JSONObject user = results.getJSONObject(0);

                // Extract user details
                JSONObject name = user.getJSONObject("name");
                String fullName = name.getString("title") + " " + name.getString("first") + " " + name.getString("last");
                String email = user.getString("email");
                String country = user.getJSONObject("location").getString("country");
                String phone = user.getString("phone");

                // Display user details
                System.out.println("--- Random User Details ---");
                System.out.println("Name    : " + fullName);
                System.out.println("Email   : " + email);
                System.out.println("Country : " + country);
                System.out.println("Phone   : " + phone);
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 