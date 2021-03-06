package lab5.prob2;

public final class Rectangle implements IShape{

	private final double width, length;
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
	@Override
	public double computeArea() {
		return width * length;
	}

}
