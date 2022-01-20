public class Main {

	static int triangle(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n + triangle(n-1); 
		}
	}
	
	static int count(String str) {
		
		if(str == null || str.equals("")) {
			return 0;
		}
		else {
			
			return 0 + count(str.substring(1));
		}
	}

	public static void main(String [] args) {
	
		System.out.println(count("Aminah"));
		System.out.println((triangle(6)));
	}
}
