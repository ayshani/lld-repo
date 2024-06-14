import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

// free API -https://jsonplaceholder.typicode.com/users
//https://jsonplaceholder.typicode.com/
// Code - https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
//https://github.com/mjg123/java-http-clients/blob/master/src/main/java/com/twilio/JavaHttpURLConnectionDemo.java
public class RestWithoutPaginationMain {
    public static void main(String[] args) throws IOException {
        // Create a neat value object to hold the URL
        //URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        URL url = new URL("https://jsonplaceholder.typicode.com/users");

        // Open a connection(?) on the URL(?) and cast the response(??)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

        // This line makes the request
        InputStream responseStream = connection.getInputStream();

        // Manually converting the response body InputStream to APOD using Jackson
        ObjectMapper mapper = new ObjectMapper();
        //APOD apod = mapper.readValue(responseStream, APOD.class);
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
        List<User> users = mapper.readValue(responseStream, typeReference);
        users.forEach(System.out::println);
        // Finally we have the response
        //System.out.println(apod);

    }
}