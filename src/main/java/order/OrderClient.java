package order;

import client.Client;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient extends Client {
    private static String PATH = "/api/v1/orders/";


    public ValidatableResponse create(Order order) {
        return given()
                .spec(getSpec())
                .log().all()
                .body(order)
                .when()
                .post(PATH)
                .then()
                .log().all();
    }

    public ValidatableResponse returnOrderList() {
        return given()
                .spec(getSpec())
                .log().all()
                .when()
                .get(PATH)
                .then()
                .log().all();
    }
}
