package lab5.prob2;

public final class Triangule implements IShape{

	private final double base, height;
	
	public Triangule(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}
	public double getHeight() {
		return height;
	}
	@Override
	public double computeArea() {
		return height*(base/2);
	}

}
