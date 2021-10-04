package app;

public class Rect extends Shape{

	protected int width;
	protected int height;
	public Rect() {
		this(0,0);
	}
	public Rect(int w, int h) {
		width = w;
		height = h;
//		x = 
//		y = 
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setSize(int w, int h) {
		width = w;
		height = h;
	}
	
	public int getSize() {
		return x*y;
	}
	
	public double area() {
		return width*height;
	}
	
	public double circumference() {
		return 2*(width+height);
	}
}
