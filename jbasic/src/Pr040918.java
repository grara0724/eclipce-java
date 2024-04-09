
public class Pr040918 {
	public static void main(String[] args) {
		//0~9までのランダムな数字を代入してくれる命令		
		int a = new java.util.Random().nextInt(10);
		System.out.println("a = " + a);
		if (a % 2 == 0) {
			System.out.println("aは偶数です");
		} else {
			System.out.println("aは奇数です");

		}

	}
}
