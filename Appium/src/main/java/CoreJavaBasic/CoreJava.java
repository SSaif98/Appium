package CoreJavaBasic;

import java.util.ArrayList;

public class CoreJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		String name = "Saif";
		char letter = 'r';
		double desc = 8.9;
		boolean decision = true;
		System.out.println(num + name);
		int[] arr = new int[5];
		arr[0] = 90;
		int[] arr2 = {1,3,4,5,6,7};
		
		System.out.println(arr[0]);
		
//		for(int i=0; i<arr2.length ; i++) {
//			System.out.println(arr2[i]);
//		}
//		for( int s: arr2) {
//			System.out.println(s);
//		}
		for(int i=0; i<arr2.length ; i++) {
			if(arr2[i]%2 == 0) {
				System.out.println(arr2[i]);
				break;
			}
		}
		
		//Array List
		ArrayList<String> a = new ArrayList<String>();
		//Create obj of the class to access the method of the class
		a.add("Test");
		a.add("Test-2");
		System.out.println(a);
		System.out.println(a.get(1));
		a.remove(0);
		System.out.println(a);

		//String literal
		String s = "Saif";
		String s1 = "Saif"; 
		//String is an obj that represents sequence of object
		//if the string is same then it will not create a new variable and have memory allocation
		
		//new
		String s2 = new String("Welcome Back");
		String s3 = new String("Welcome");
		//if the string is same then it will create a new variable and have memory allocation as new keyword is used
		String[] splittedString = s2.split(" ");
		System.out.println(splittedString[0]);
		
		for(int i = s2.length()-1; i>=0; i--) {
			System.out.println(s2.charAt(i));
		}		
		CoreJava obj = new CoreJava();
		CoreJava2 obj2 = new CoreJava2();
		
		System.out.println(obj2.getUserData());
		System.out.println(obj.add(3,7));
		System.out.println(getData());

	}
	
	public int add(int a, int b) {
		 return a+b;
	}
	
	public static String getData() {
		//If the method is static then it will be a class method so we do need to create an obj to access the method outside main block
		return "Saif";
	}

}
