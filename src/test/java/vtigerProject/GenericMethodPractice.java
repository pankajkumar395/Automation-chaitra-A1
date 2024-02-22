package vtigerProject;

public class GenericMethodPractice {

	public static void main(String[] args) {//Caller Function
		
		int sum=add(200,700);
		System.out.println(sum);
	}
	public static int add(int a,int b) {//Called Function
		                               /*Not run unless Called */
		int c=a+b;
		return c;
	}
}
