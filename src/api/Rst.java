package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Body;
import files.Resuablemethods;
public class Rst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String a =	given().queryParam("key","qaclick123").header("Content-Type","application/json").
		body(Body.addbody()).
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).extract().response().asString();
		//System.out.println(a);
		
		JsonPath js = new JsonPath(a);
		String placeid = js.get("place_id");
		//System.out.println(placeid);
		
		//update place
		String pl = "rahul, USA";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").
		body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\""+pl+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").
		when().put("/maps/api/place/update/json").
		then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
		//get place
		String updatedgetplace = given().log().all().queryParam("key","qaclick123").queryParam("place_id", placeid).
		when().get("/maps/api/place/get/json").
		then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		System.out.println(updatedgetplace);
		
		JsonPath gt =Resuablemethods.rawtojson(updatedgetplace);
		String upadd = gt.get("address");
		System.out.println(upadd);
		Assert.assertEquals(upadd,pl);
		
		
		
		
	}

}
