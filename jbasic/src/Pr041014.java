import java.util.Scanner;

public class Pr041014 {
	public static void main(String[] args) {
		System.out.println("一つ目の値を入力してください。");
		double a = new Scanner(System.in).nextDouble();
		System.out.println("二つ目の値を入力してください。");
		double b = new Scanner(System.in).nextDouble();

		double c = aaa(a, b);
		System.out.println("一つ目の数字割る二つ目の数字は" + c + "です。");
	}

	static double aaa(double d, double e) {
		double result = d / e;
		return result;
	}

}