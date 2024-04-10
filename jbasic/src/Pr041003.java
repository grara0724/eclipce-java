public class Pr041003 {
	public static void main(String[] args) {
		int age = 23;
		boolean members = false;
		int fee = 0;
		if (age >= 20 && members == true) {
			fee = 1100;
		} else if (age >= 20 && members == false) {
			fee = 1500;
		} else if (members == true) {
			fee = 500;
		} else {
			fee = 800;
		}
		System.out.println("料金は" + fee + "です。");
	}
}
