import java.util.Scanner;

public class Pr041012 {
	public static void main(String[] args) {
		System.out.println("数値を入力してください:");
		int n = new Scanner(System.in).nextInt();
		for (int i = 1; i <= 8; i++) {
			for (int m = 1; m <= n; m++) {
				if (m % 2 == i % 2) {
					System.out.print("□");
				} else {
					System.out.print("■");
				}

			}
			System.out.println(" ");
		}

	}
}