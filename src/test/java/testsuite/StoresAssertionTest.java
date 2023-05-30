package testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

//1. Verify the if the total is equal to 1561
//2. Verify the if the stores of limit is equal to 10
//3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
//4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
//5. Verify the storied=7 inside storeservices of the third store of second services
//6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
//7. Verify the state = MN of forth store
//8. Verify the store name = Rochester of 9th store
//9. Verify the storeId = 11 for the 6th store
//10. Verify the serviceId = 4 for the 7th store of forth service

public class StoresAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    //1.Verify the if the total is equal to 1561
    @Test
    public void test001() {
        response.body("total", equalTo(1561));
    }

    // 2.Verify that the products of limit is equal to 10
    @Test
    public void test002() {
        response.body("limit", Matchers.equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void test003() {
        response.body("data.name", hasItem("Inver Grove Heights"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void test004() {
        response.body("data.name", hasItems("Roseville", "Burnsville", "Maplewood"));
    }
    //5.Verify the storied=7 inside storeservices of the third store of second services

    @Test
    public void test005() {
        response.body("data[2].services[1].storeservices", hasEntry("storeId", 7));
    }

    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void test006() {
        response.body("data.findAll{it.name=='Roseville'}", hasItem(hasEntry("createdAt", "2016-11-17T17:57:05.853Z")));

    }

    //7. Verify the state = MN of forth store
    @Test
    public void test007() {
        response.body("data.findAll{it.id==4}", hasItem(hasEntry("state", "MN")));
    }

    //8. Verify the store name = Rochester of 9th store
    @Test
    public void test008() {
           response.body("data.findAll{it.id==14}", hasItem(hasEntry("name", "Rochester")));
    }

    //9. Verify the storeId = 11 for the 6th store
    @Test
    public void test009() {
        response.body("data[6].id", equalTo(12));
    }

    //10. Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void test010() {
       // response.body("data[7].services[4].id", equalTo(7));
        response.body("data[4].services[4].storeservices", hasEntry("storeId", 10));

    }

}






