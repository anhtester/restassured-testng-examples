package anhtester.com.testcases;

import anhtester.com.data.reqres.PostData;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.restassured.http.ContentType;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPatchRequests {

    Logger log = LogManager.getLogger(TestPatchRequests.class);
    private static final String URL = "https://reqres.in";

    @DataProvider(name = "patchData")
    public Iterator<Object[]> patchData() {
        final List<Object[]> patchData = new ArrayList<>();
        patchData.add(new Object[]{2, "Michael", "QA Lead"});
        patchData.add(new Object[]{958, "Yuan", "Project Architect"});
        return patchData.iterator();
    }

    @Test(dataProvider = "patchData")
    public void patchRequestTests(final int id, final String name, final String job) {

        final PostData postData = new PostData(name, job);
        final String response = given().contentType(ContentType.JSON)
                .body(postData)
                .when()
                .patch(URL + "/api/users/" + id)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("name", equalTo(name))
                .and()
                .assertThat()
                .body("job", equalTo(job))
                .and()
                .extract()
                .response()
                .body()
                .asString();

        this.log.info(response);

    }

}