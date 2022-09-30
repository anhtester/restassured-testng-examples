package anhtester.com.testcases;

import anhtester.com.data.reqres.AuthenticationPojo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

import org.json.JSONObject;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class TestAuthentication {

    private static final String URL = "https://reqres.in";
    Logger log = LogManager.getLogger(TestAuthentication.class);

    @DataProvider
    public Iterator<Object[]> getAuthenticationData() {
        final List<Object[]> getTestData = new ArrayList<>();
        getTestData.add(new Object[]{"eve.holt@reqres.in", "pistol"});
        return getTestData.iterator();
    }

    @Test(dataProvider = "getAuthenticationData")
    public void testAuthenticationToken(String email, String password) {
        final AuthenticationPojo requestBody = new AuthenticationPojo(email, password);

        given().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .log()
                .all()
                .post(URL + "/api/register")
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all()
                .body("id", notNullValue())
                .and()
                .body("token", notNullValue());

    }

    public static Map<String, Object> getToken(String email, String password) {
        final AuthenticationPojo requestBody = new AuthenticationPojo(email, password);
        final String response = given().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .log()
                .all()
                .post(URL + "/api/register")
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all()
                .body("id", notNullValue())
                .and()
                .body("token", notNullValue())
                .and()
                .extract()
                .response()
                .asString();

        final JSONObject responseObject = new JSONObject(response);
        final Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("id", responseObject.getInt("id"));
        responseMap.put("token", responseObject.getString("token"));
        return responseMap;
    }

    @Test(dataProvider = "getAuthenticationData")
    public void testAuthToken(String email, String password) {
        log.info("Token is" + getToken(email, password).get("token")
                .toString());

    }

}