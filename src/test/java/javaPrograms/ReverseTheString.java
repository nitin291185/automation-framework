package javaPrograms;

public class ReverseTheString {

	public static void main(String[] args) {
		  String s = "Nitin learns java";
	        String rev = "";

	        for (int i = s.length() - 1; i >= 0; i--) {
	            rev = rev + s.charAt(i);
	        }

	        System.out.println("Original: " + s);
	        System.out.println("Reversed: " + rev);
	}
}
