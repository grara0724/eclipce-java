public class UseBook2 {
	public static void main(String[] args) {
		Book2[] books = new Book2[3];
		books[0] = new Book2("TCP/IP 入門", "吉田茂樹", 2200);
		books[1] = new Book2("XML のすべて", "高橋麻奈", 1800);
		books[2] = new Book2("話せる英文法", "有小山博美", 1500);
		for (Book2 book : books) {
			book.showBook();
		}
	}
}