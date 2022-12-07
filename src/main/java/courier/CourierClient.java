package courier;

import client.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient extends Client {

    private static final String COURIER_PATH = "api/v1/courier/";
    private static final String COURIER_LOGIN = "api/v1/courier/login";

    @Step("Создание нового курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .spec(getSpec())
                .log().all()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then()
                .log().all();
    }

    @Step("Авторизация курьера в системе")
    public ValidatableResponse loginCourier(CourierCredentials courierCredentials) {
        return given()
                .header("Content-type", "application/json")
                .spec(getSpec())
                .log().all()
                .body(courierCredentials)
                .when()
                .post(COURIER_LOGIN)
                .then()
                .log().all();
    }


    @Step("Удаление курьера")
    public ValidatableResponse deleteCourier(int courierId) {
        return given()
                .spec(getSpec())
                .when()
                .delete(COURIER_PATH + courierId)
                .then()
                .log().all();
    }
}