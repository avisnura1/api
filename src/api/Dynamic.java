package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Body;
import files.Resuablemethods;

public class Dynamic {

	@Test
	public void addbook() {
	RestAssured.baseURI="http://216.10.245.166";
	given().header("Content-Type","application/json").body(Body.addbook()).when().post("Library/Addbook.php").then().statusCode(200).
	extract().response();
	}
}
