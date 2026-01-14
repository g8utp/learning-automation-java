package swagTests.api;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class ReqresApiTest {

    @Test
    public void checkUsersList(){
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("title", containsString("sunt aut facere"));
    }
    @Test
    public void createPost(){
        PostData data = new PostData("My Title", "My Body", 1 );
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/posts")
                .then()
                .log().all()
                .statusCode(201)
                .body("title", equalTo("My Title"))
                .body("body", equalTo("My body"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());
    }
    public static class PostData{
        public String title;
        public String body;
        public int userId;

        public PostData(String title, String body, int userId){
            this.title = title;
            this.body = body;
            this.userId = userId;
        }
    }
}

