public class Main {
	
	static String reverse(String words) {
		
		String reversed = "";
		for(int i=words.length()-1;i>=0;i--){
			reversed += words.charAt(i);
		}
		return reversed;
	}

	public static void main(String [] args){
		System.out.println(reverse("Hello"));
	}

}
