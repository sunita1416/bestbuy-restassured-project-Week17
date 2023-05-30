package testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //Extract the limit
    @Test
    public void ExtractLimit() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    // Extract the total
    @Test
    public void ExtractTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the name of 5th product
    @Test
    public void ExtractNameOf5Product() {
        String name = response.extract().path("data[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the names of all the products
    @Test
    public void ExtractNameOfAllProducts() {
        List<String> name = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all products : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the productId of all the products
    @Test
    public void ExtractProductIdOfAllProducts() {
        List<Integer> ids = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all products ids: " + ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //Print the size of the data list
    @Test
    public void PrintSizeOfDataList() {
        List<Integer> ids = response.extract().path("data");
        ids.size();
        System.out.println("total size of data list : " + ids.size());
    }

    //Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void GetAllValueOfEnergizerProduct() {
        List<HashMap<String, ?>> descripton = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product description : " + descripton);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
    //Pack)
    @Test
    public void GetModelOfProductNameEnergizer() {
        List<HashMap<String, ?>> model = response.extract().path("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of  model : " + model);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get all the categories of 8th products
    @Test
    public void GetAllCategoriesOf8thProducts() {
        List<HashMap<String, ?>> categories = response.extract().path("data[8].categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all categories: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //. Get categories of the store where product id = 150115
    @Test
    public void GetCategoriesOFGivenProductId() {
        List<Integer> listOfIds = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get all the descriptions of all the products
    @Test
    public void GetDescriptionOFAllProducts() {
        List<String> data = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of data are : " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get id of all the all categories of all the products
    @Test
    public void GetIdOfAllCategoriesProducts() {
        List<Integer> data = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all categories of products: " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the product names Where type = HardGood
    @Test
    public void FindProductNameOfTypeHardGood() {
        List<String> productName = response.extract().path("data.findAll{it.type=='HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All productName: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void FindNumberOfCategoriesOfGivenProductName() {
        List<String> noOfCategories = response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All noOfCategories: " + noOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the createdAt for all products whose price < 5.49
    @Test
    public void FindCreatedAtForAllProductsAtGivenPrice() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All createdAt: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void FindAllCategoriesOfProductEnergizer() {
        List<String> categories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All categories: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the manufacturer of all the products
    @Test
    public void FindManufacturerOfAllProducts() {
        List<String> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All manufacturer: " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the image of products whose manufacturer is = Energizer
    @Test
    public void FindImageOfProductsManufacturerEnergizer() {
        List<HashMap<String, ?>> image = response.extract().path("data.findAll{it.manufacturer =='Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All image: " + image);
        System.out.println("------------------End of Test---------------------------");

    }
    //Find the createdAt for all categories products whose price > 5.99
    @Test
    public void FindCreatedAtCategoriesGivenProductsPrice(){
        List<HashMap<String,?>> createdAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All createdAt: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    // Find the uri of all the products
    @Test
    public void FindUrlOfAllProducts(){
        List<HashMap<String,?>> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All url: " + url);
        System.out.println("------------------End of Test---------------------------");
    }
}
