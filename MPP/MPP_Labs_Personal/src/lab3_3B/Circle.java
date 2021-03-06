package lab3_3B;

public class Circle {

	private Cylinder cylinder;
	
	public Circle(double radius) {
		cylinder = new Cylinder(radius,0);
	}
	
	/**
	 * formula: PI.r²
	 * @return
	 */
	public double computeArea() {
		return Math.pow(cylinder.getRadius(),2) * Math.PI;
	}

}
