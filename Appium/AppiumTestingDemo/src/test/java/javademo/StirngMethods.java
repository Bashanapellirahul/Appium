package javademo;

public class StirngMethods {

	public static void main(String[] args) {
		
		StirngMethods a = new StirngMethods();
		a.name();
	
		
		String name = "rahul,bashanapelli,rahul";
		
		String [] splittedstring = name.split(",");	
		
		for(int i=0; i<3; i++) {		//iterating over the string to create list of array
			
			System.out.print(splittedstring[i]);
			
		}
		
		
		System.out.println();
		
		String s = "rahul bashanapelli selenium";
		
		for(int i = 0; i<s.length();i++) {
			System.out.println(s.charAt(i));
		}
		
		
		System.out.println();
		String s1 = "RAHUL";
		
		for(int i=s1.length()-1;i >= 0;  i--) {			//iterating over the string to reverse it
			
			
			System.out.println(s1.charAt(i));
			
		}
		
		

	}
	public void name() {
		
		System.out.println("this is name method");
		
	}

}
