package swapiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSwapi {

    @Test(priority = 0)
    public void validateStatusCode() {
        given().
                baseUri("https://swapi.dev/").
        when().
                get("api/people/").
        then().
                log().all().
        assertThat().
                statusCode(200);
    }

    @Test(priority = 1)
    public void verifyHeightMoreThan200AndNames() {
        Response res = given().
                baseUri("https://swapi.dev/").
        when().
                get("api/people/").
        then().
                extract().
                response();

        List<String> name = new LinkedList<String>(Arrays.asList(res.path("results.name").toString().replace("[","").replace(" ","").replace("]","").split(",")));
        List<Integer> height = (Arrays.asList(res.path("results.height").toString().replace("[","").replace(" ","").replace("]","").split(","))).stream().map(Integer::parseInt).collect(Collectors.toList());

        int sizeList = name.size();
        int remove = 0;
        for(int i = 0; i < sizeList; i++) {
            if(height.get(remove) < 200) {
                name.remove(remove);
                height.remove(remove);
            }else {
                remove++;
            }
        }
        assertThat(height.size(), equalTo(1));
        assertThat(name, hasItems("DarthVader"));
        assertThat(height, everyItem(greaterThan(200)));
    }

    @Test(priority = 3)
    public void verifyTotalNumberPeople() {
       given().
                baseUri("https://swapi.dev/").
        when().
                get("api/people/").
        then().
                log().all().
        assertThat().
                body("results.size()", equalTo(10));
    }
}
