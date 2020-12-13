import io.restassured.RestAssured;

import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReusableMethod;
import files.payload;

import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) {
		
		//validate if ad place api is working as expected
		// set the base URI
		// given- provide all the inputs- precondition - given belong to static package
		// when - submit the API  - All the methods go in when -- resourse and http method goes under when method
		// Then -validate the response
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response	=given().log().all().
		queryParam("key","qaclick123").
		header("Content-Type","application/json").
		body(payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("App"))
		.header("Server","Apache/2.4.18(Ubuntu)").extract().response().asString();
		System.out.println(response);
		
		JsonPath js= new JsonPath(response);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		// we can validate the body using hamcrest matchers or We can validate the  responseheaders also	
		// what we give anything after then is a output validation
		
		
		//update place_id
		String newadress="Sumer walk, USA";
		
		given().log().all().
		queryParam("key","qaclick123").
		header("Content-Type","application/json").
		body("{\r\n" + 
				"    \"place_id\":\""+placeid+"\",\r\n" + 
				"    \"address\":\""+newadress+"\",\r\n" + 
				"    \"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//Get place
		
	String getplaceresponse 	=given().log().all().
		queryParam("key","qaclick123").queryParam("place_id",placeid).when().get("maps/api/place/get/json").then().log().all().assertThat()
		.statusCode(200).extract().response().asString();
		//very important converting string to Json 
		//JsonPath js1= new JsonPath(getplaceresponse );
		JsonPath js1=ReusableMethod.rawToJason(getplaceresponse);
		String  actualadress=js1.getString("address");// the value you want to extract from address
		System.out.println(actualadress);
		
		Assert.assertEquals(actualadress, newadress);//1st from response 2nd parameter is what we sent
		
	// we should assert and see wheather we get actual address	
	}

}
