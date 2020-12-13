import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class Sumvalidation {
	
@Test
public void sumCouPric(){
	
	JsonPath js= new JsonPath(payload.coursesPrice());
	  int pamount    =  js.get("dashboard.purchaseAmount");
	  System.out.println(pamount);
	int count=	js.getInt("courses.size()");
	
	int sum=0;
	for(int i =0; i<count;i++){
		
	
		int prices	=js.get("courses["+i+"].price");
		int copies	= js.get("courses["+i+"].copies");
		int amount= prices* copies;
			sum=sum+amount;
			
		}
	System.out.println(sum);
	
	//Assert.assertEquals(sum, pamount);
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
