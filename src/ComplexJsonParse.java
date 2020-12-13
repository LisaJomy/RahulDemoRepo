import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(payload.coursesPrice());
		
	// print the number of courses returned by 	
		
		
int count=	js.getInt("courses.size()");
		
System.out.println(count);	
//print purchase amount	
int purchseamount=js.getInt("dashboard.purchaseAmount");
System.out.println(purchseamount);


//Print title of the first course

String title=js.get("courses[0].title");
System.out.println(title);

// print all course titles and respective prices

for(int i =0; i<count;i++){
	
String coursesT	=js.get("courses["+i+"].title");
int prices	=js.getInt("courses["+i+"].price");
	System.out.println(coursesT);
	// system .out.println accepts only string argument- doest matter what data type convert that to string
	System.out.println(js.get("courses["+i+"].price").toString());
	System.out.println(prices);
	
}
// print the number of copies sold by RPA Course
// the array is dynamic we cannot say the particular course lies on specific date
//we have scan the entire array and if the tilte is RPA then get the copies nad print it
for(int i =0; i<count;i++){
	
String coursesT	=js.get("courses["+i+"].title");
if (coursesT.equalsIgnoreCase("RPA")){
	
int copies=js.getInt("courses["+i+"].copies");	
	System.out.println(copies);
	break;
	
	// verify if sum of all course prices matches the p[urchase amount
	
	
}
	
}



	}
	
	
	

}
