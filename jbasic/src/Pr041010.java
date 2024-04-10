import java.util.Scanner;

public class Pr041010 {
	public static void main(String[] args) {
		System.out.println("数値を入力してください:");
		int n = new Scanner(System.in).nextInt();
		int sum = 1;
		while (n > 0) {
			sum *= n;
			n--;
		}
		System.out.println("n! = " + sum);
	}
}
