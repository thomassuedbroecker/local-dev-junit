package authortests;

// The Author data structure class from the microservice
import com.ibm.authors.Author;

// Java
import java.net.URI;

// JSON-B
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

// MicroProfile
import org.eclipse.microprofile.rest.client.RestClientBuilder;

// JUnit
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Test_GetAuthors {

    @ParameterizedTest(name = "{index} => name=''{0},{1}''")
    @CsvSource({"Thomas,Thomas Suedbroecker",
                "Niklas,Niklas Heidloff",
                "Michael,Michael Heinrich"
              })  
    public void testGetAuthor(
            final String nameAuthor, final String expectedResult) {

        final String BASE_URL = "http://localhost:3000/api/v1/";
        final URI baseURI = URI.create(BASE_URL);

        // Prepare test
        System.out.println("[JUNIT-TEST] -> Create RestClient");
        final AuthorTestClient authorClient = RestClientBuilder.newBuilder().baseUri(baseURI)
                .build(AuthorTestClient.class);

        // Execute test
        System.out.println("[JUNIT-TEST] -> Execute test and invoke GetAuthor with parameter value: " + nameAuthor);

        // pure getAuthors response result
        final String response = authorClient.getAuthor(nameAuthor);
        System.out.println("[JUNIT-TEST] -> The getAuthor response : " + response);

        // use the getAuthors response to create a json and the a Author class instance
        System.out.println("[JUNIT-TEST] -> Create Jsonb config based on Adapter");
        final JsonbConfig config = new JsonbConfig().withAdapters(new AuthorJsonbAdapter());
        System.out.println("[JUNIT-TEST] -> Create Jsonb Object");
        final Jsonb jsonb = JsonbBuilder.create(config);
        System.out.println("[JUNIT-TEST] -> Create Author class instance using Jsonb Object from the response");
        final Author author_json = jsonb.fromJson(response, Author.class);
        System.out.println("[JUNIT-TEST] -> Created author_json.class : " + author_json.toString());
        System.out.println(
                "[JUNIT-TEST] -> Access the Auther class instance - author_json.name : " + author_json.getName());

        // verify response with JUnit
        System.out.println("[JUNIT-TEST] -> Verify");
        assertEquals(expectedResult, author_json.getName());
    }
}