
public class Pr041011 {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int sum = 1;
		for (int c = 1; c <= b; c++) {
			sum *= a;
		}

		System.out.println(a + "の" + b + "乗は" + sum + "です");
	}
}