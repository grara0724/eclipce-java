
public class Square {

	private int height;
	private int width;
	static int side = 4;

	public Square(int h, int w) {
		height = h;
		width = w;
	}

	public Square(int h) {
		this(h, 1);

	}

	int area() {
		int ar = height * width;
		return ar;

	}

	void showArea() {
		System.out.println("四角形の辺の数は" + 4 + "です  \r\n  s1   高さ: " + height + " 幅: " + width + " 面積: " + area());
	}
	//
	//	public int getHeight() {
	//		return height;
	//	}
	//
	//	public void setHeight(int height) {
	//		this.height = height;
	//	}
	//
	//	public int getWidth() {
	//		return width;
	//	}
	//
	//	public void setWidth(int width) {
	//		this.width = width;
	//	}
	//
}
