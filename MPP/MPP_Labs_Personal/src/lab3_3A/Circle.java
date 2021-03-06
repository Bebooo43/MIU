package lab3_3A;

public class Circle extends Cylinder{
	
	public Circle(double radius) {
		super(radius,0);
	}
	
	/**
	 * formula: PI.r²
	 * @return
	 */
	public double computeArea() {
		return Math.pow(getRadius(),2) * Math.PI;
	}
}
