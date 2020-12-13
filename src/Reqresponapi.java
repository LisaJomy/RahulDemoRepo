import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

	import java.util.ArrayList;
	import java.util.List;

public class Reqresponapi {
	
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
		
		//ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).		
RequestSpecification req =new RequestSpecBuilder().setBaseUri("http://www.rahulshettyacademy.com").addQueryParam("Key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
//		
//			RestAssured.baseURI="http://rahulshettyacademy.com";
//		Response res=given().queryParam("key", "qaclick123")
	
ResponseSpecification responsespec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();		
 RequestSpecification res = given().spec(req)
		.body(p);

	Response response = res
						.when()
						.post("/maps/api/place/add/json")
						.then().spec(responsespec).extract().response();// what you get back after response

	String resp1	=response.asString();
		System.out.println(resp1);
		}

	}

	


