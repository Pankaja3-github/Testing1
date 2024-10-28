package DDT;

public class Program014_DebuggingEx1 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		int temp;
		temp = a;
		a=b;
		b=temp;
		System.out.println(a);
		System.out.println(b);
	}
}
