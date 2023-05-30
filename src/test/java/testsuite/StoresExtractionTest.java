package testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
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
    //Extract the limit
    @Test
    public void test001ExtractTheValueOfLimit() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " +limit);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract the total
    @Test
    public void test002ExtractTheTotal(){
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " +total);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract the name of 5th store
    @Test
    public void test003ExtractTheName(){
        String storeName = response.extract().path("data[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5th store : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }
    //Extract the names of all the store
    @Test
    public void test004ExtractNameOfAllStore(){
        List<Integer> allStoreName = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");

    }
   // Extract the storeId of all the store
    @Test
    public void extractAllStoreId() {
        List<Integer> allStoreID = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store id : " + allStoreID);
        System.out.println("------------------End of Test---------------------------");
    }
    //Print the size of the data list
    @Test
    public void printSizeOfDataList(){
        List<Integer> dataList = response.extract().path("data");
        dataList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //Get all the value of the store where store name = St Cloud
    @Test
    public void GetAllValueOfStoreName() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");

        System.out.println("---------------------StartingTest-----------------------");
        System.out.println("The value of the store where store name : " + values);
        System.out.println("----------------------End of test------------------------");
    }
// Get the address of the store where store name = Rochester
@Test
public void GetAddressOfStore() {
    List<HashMap<String, ?>> Address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Address of store: " + Address);
    System.out.println("------------------End of Test---------------------------");
}
// Get all the services of 8th store
    @Test
    public void GetAllServicesOfStore(){
        List<HashMap<String, ?>> services = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Services of 8th store: " + services);
        System.out.println("------------------End of Test---------------------------");
    }
//Get storeservices of the store where service name = Windows Store
    @Test
    public void GetStoreServices(){
        List<String> storeServices = response.extract().path("data.services.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeservices: " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //Get all the storeId of all the store
    @Test
    public void GetAllStoreId(){
        List<Integer> total = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeId: " + total);
        System.out.println("------------------End of Test---------------------------");
    }
    //Get id of all the store
    @Test
    public void GetIdOfAllStore(){
        List<Integer> allStoreID=response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeId: " + allStoreID);
        System.out.println("------------------End of Test---------------------------");
    }
//Find the store names Where state = ND
    @Test
    public void FindStoreName(){
        List<String> storeName = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeservices: " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }
//Find the Total number of services for the store where store name = Rochester
    @Test
    public void FinfTotalNumberOfServices(){
        List<String> numOfServices = response.extract().path("data.findAll{it.name=='Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeservices: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
//Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void CreatedAtServices(){
        List<String> numOfServices = response.extract().path("data.findAll{it.services=='Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");

    }
//Find the name of all services Where store name = “Fargo”
    @Test
    public void FindAllServicesOFStoreFargo(){
        List<String> numOfServices = response.extract().path("data.findAll{it.name=='Fargo'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
//Find the zip of all the store
    @Test
    public void FindZopOfAllStore(){
        List<Integer> numOfServices = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
// Find the zip of store name = Roseville
    @Test
    public void FindZipOfStoreNameRoseVille(){
        List<Integer> numOfServices = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
// Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void FindStoreServicesDetails(){
        List<?> numOfServiceId = response.extract().path("data.findAll{it.name=='Magnolia Home Theater'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServiceId);
        System.out.println("------------------End of Test---------------------------");
    }
    //Find the lat of all the stores
    @Test
    public void FindLatOfAllStores(){
        List<Integer> numOfServices = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    }












