public class Pr041004 {
	public static void main(String[] args) {
		int a = 10;
		int b = 8;
		int c = 6;
		if (a > b && b > c) {
			System.out.println("aが最大です。");
		} else if (b > c) {
			System.out.println("bが最大です。");
		} else {
			System.out.println("cが最大です。");
		}
	}
}