package files;

import java.util.ArrayList;

public class Profilepage {
	public static void main(String[] args) {
		int [] a= {10,20,30,40};
		
		System.out.println(a[0] + a[2]);
		for(int i =0;i<a.length;i++){
			
			System.out.println(a[i]);
			
			
		}
		
		
		
		//String
		
	String student[]={"Varun","Lisa","Sarang","geetha"};
	
	
	for(int count=0;count<student.length;count++){
		
		System.out.println(student[count]);
		
		if (student[count].equals("Sarang")){
			System.out.println("the total marks is 40");
		}
			
	}
	
	String browser[]={"Chrome","firefox","opera","Bravo"};
	
	for(int j=0;j<browser.length;j++){
		
		System.out.println(browser[j]);
		if(browser[j].equals("Chrome")){
			System.out.println("Launch chrome browser");
		}else if(browser[j].equals("firefox")){
			System.out.println("Launch firefox browser");
		}else if(browser[j].equals("opera")){
			System.out.println("Launch opera browser");
		}else if(browser[j].equals("IE")){
			System.out.println("Launch IE browser");

		}else{
			System.out.println("selected wrong browser");
		}
	}
	
	// Object array to handle different kind of data
	
	Object arr[]={"Lisa",12.33,'f',true};
	for(int k=0;k<arr.length;k++){
	
	System.out.println(arr[k]);
		
	
	}
	//ArrayList
	
	ArrayList<String> arrlist=new ArrayList<String>();
	arrlist.add("Lisa");
	arrlist.add("Geetha");
	arrlist.add("Pallavi");
	arrlist.add("Ramesh");
	
	System.out.println(arrlist);
	
	System.out.println(arrlist.get(2));
	
	for(int h=0;h<arrlist.size();h++){
		
		System.out.println(arrlist.get(h));
		
	}
	
	//Object array to find different kind of data
	ArrayList<Object> employeeList=new ArrayList<Object>();
	employeeList.add("Tom");
	employeeList.add(25);
	employeeList.add(true);
	employeeList.add(12.33);
	
	System.out.println(employeeList);
	
		
		
		

	}


		
	
	
	
	
	}	
	
	
	

