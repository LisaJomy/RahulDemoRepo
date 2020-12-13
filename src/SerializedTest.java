import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializedTest {

	public static void main(String[] args) {
		
		AddPlace p = new AddPlace(); 
		p.setAccuracy(50);
		p.setAddress("29,side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline house");
	
		
		// if types is list - should create the object of list
	List<String> typelist=new ArrayList<String>();
	
	typelist.add("shoe park");
	typelist.add("shop");
	p.setTypes(typelist);
	
	// location - location is expecting location class object
	Location l= new Location();
	l.setLng(-38.1234);
	l.setLat(34.56789);
	
	p.setLocation(l);
		RestAssured.baseURI="http://rahulshettyacademy.com";
	Response res=given().queryParam("key", "qaclick123")
	.body(p)
	.when()
	.post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();

String response	=res.asString();
	System.out.println(response);
	}

}
