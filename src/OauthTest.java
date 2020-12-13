import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import Pojo.Api;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class OauthTest {

	public static void main(String[] args) {
		
		
	String[] expectedList={"Soap UI Webservices Testing","Cypress","Protactor"};	
		
		
	// response type will be class type	
		// our response is json - we should explicitly mention to rest assured to convert json to java object
		
		
		GetCourse  gc= given().queryParam("access_token", "accessToken").expect().defaultParser(Parser.JSON).when()
				.get("https//rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		
		
		System.out.println(gc.getLinkedin());
		System.out.println(gc.getInstructor());
	// hardcodeway of geting title from api	
String apicoursetitle		=gc.getCourses().getApi().get(1).getCoursetitle();
	List<Api>  apicourse	=gc.getCourses().getApi();
	// get the size to create the for loop
	
	for(int i=0; i<apicourse.size();i++){
	  String title    = apicourse.get(i).getCoursetitle();
		System.out.println(title);
		
		if (apicourse.get(i).getCoursetitle().equalsIgnoreCase("SoapUI Webservices Testing")){
			System.out.println(apicourse.get(i).getPrice());
		}
	}
	
	// how to get all corse tile from webautomation	
	// how to convert to arraylist and compare expected versus actual value
	ArrayList<String> a=new ArrayList<String>();
List<WebAutomation>	w =gc.getCourses().getWebautomation();
	for(int i =0;i<w.size();i++){
	
	a.add(w.get(i).getCoursetitle());
	
	//System.out.println(webautomationtitle);
}
//convert array to arraylist
	List<String> expectedlist=Arrays.asList(expectedList);
	
		
		
		Assert.assertTrue(a.equals(expectedlist));
	}

}
