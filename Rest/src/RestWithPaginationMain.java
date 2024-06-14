import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// free API Doc -https://www.instantwebtools.net/fake-rest-api#read-passenger-paginated
// API endpoint - https://api.instantwebtools.net/v1/passenger?page=1&size=100

public class RestWithPaginationMain {
    public static void main(String[] args) throws IOException {
        // Create a neat value object to hold the URL
        int startPage =0, totalPage =0;
        do {
            URL url = new URL("https://api.instantwebtools.net/v1/passenger?page="+startPage+"1&size=100");

            // Open a connection(?) on the URL(?) and cast the response(??)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");

            // This line makes the request
            InputStream responseStream = connection.getInputStream();

            // Manually converting the response body InputStream to APOD using Jackson
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(responseStream, Response.class);
            //TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
            //List<User> users = mapper.readValue(responseStream, typeReference);
            //users.forEach(System.out::println);
            // Finally we have the response
            //System.out.println(apod);
            System.out.println(response.data);
            totalPage = response.totalPages;
            startPage++;
        } while (startPage<=totalPage);
    }
}