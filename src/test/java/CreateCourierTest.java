import io.restassured.RestAssured;
import org.example.Profile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class CreateCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void CreateCourierCorrect() {
       // Profile profile = new Profile("maikl_" + new Random().nextInt(10000),"1234","Misha");
        Profile profile = new Profile("maikl_r34","1234","Misha");
        given().log().all()
                .header("Content-Type", "application/json")
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(profile)
                .when()
                .post("/api/v1/courier")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");
    }

    @Test
    public void CreateCourierCopyLogin() {
        Profile profile = new Profile("maikl_r34","1234","Misha");
        given().log().all()
                .header("Content-Type", "application/json")
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(profile)
                .when()
                .post("/api/v1/courier")
                .then().log().all()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("ok");
    }

    @Test
    public void CreateCourierNoRequiredFieldLogin() {
        Profile profile = new Profile("","noLogin","Misha");
        given().log().all()
                .header("Content-Type", "application/json")
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(profile)
                .when()
                .post("/api/v1/courier")
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("ok");
    }
    @Test
    public void CreateCourierNoRequiredFieldPass() {
        Profile profile = new Profile("noPass","","Misha");
        given().log().all()
                .header("Content-Type", "application/json")
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(profile)
                .when()
                .post("/api/v1/courier")
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("ok");
    }


}
