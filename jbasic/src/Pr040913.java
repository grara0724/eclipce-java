
public class Pr040913 {
	public static void main(String[] args) {
		int a = 8;
		int b = 20;

		b += ++a;
		System.out.println(a);
		System.out.println(b);
	}
}
