package anhtester.com.testcases;

import anhtester.com.utils.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetRequests {

    private static final String URL = "https://reqres.in/api/users/";

    @DataProvider(name = "getUserData")
    public Iterator<Object[]> getUsers() {
        final List<Object[]> getData = new ArrayList<>();
        getData.add(new Object[]{2});
        return getData.iterator();
    }

    @Test(dataProvider = "getUserData")
    public void getRequestTest(final int userId) {
        given().when()
                .get(URL + userId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data.id", equalTo(userId));

        final int statusCode = given().when()
                .get(URL + userId)
                .statusCode();
        Log.info(statusCode);

        final String responseBody = given().when()
                .get(URL + userId)
                .getBody()
                .asString();
        Log.info(responseBody);
    }

    @Test(dataProvider = "getUserData")
    public void getRequestTestWithQueryParam(final int userPage) {
        given().when()
                .queryParam("page", userPage)
                .get(URL)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("page", equalTo(userPage));

        final String responseBody = given().when()
                .queryParam("page", userPage)
                .get(URL)
                .getBody()
                .asString();
        Log.info(responseBody);
    }

}