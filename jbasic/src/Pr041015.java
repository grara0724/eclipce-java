import java.util.Scanner;

public class Pr041015 {
	public static void main(String[] args) {
		System.out.println("一つ目の値を入力してください。");
		int a = new Scanner(System.in).nextInt();

		System.out.println("二つ目の値を入力してください。");
		int b = new Scanner(System.in).nextInt();

		System.out.println("三つ目の値を入力してください。");
		int c = new Scanner(System.in).nextInt();

		int sum = (int) summ(a, b, c);
		System.out.println("三つの数字の合計は" + sum + "です。");

	}

	static double summ(int d, int e, int f) {
		int result = d + e + f;
		return result;
	}

}