package CoreJavaBasic;

//inheritence code
public class childClass extends parentClass{
	
	public void engine() {
		System.out.println("This is an engine class");
	}
	
	public void color() {
		System.out.println(color);
	}
	
	public static void main(String[] args) {
		
		childClass obj= new childClass();
		obj.brake();
		obj.color();
		System.out.println(obj.color);
		obj.engine();
		
	}

}
