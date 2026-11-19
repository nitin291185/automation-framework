package javaPrograms;

public class TryFinallly {

	public static void main(String[] args) {
	       try {
	            System.out.println("Outer try");

	            try {
	                System.out.println("Inner try");
	            }
	            finally {
	                System.out.println("Inner finally");
	            }

	        }
	        finally {
	            System.out.println("Outer finally");
	        }

	}

}
