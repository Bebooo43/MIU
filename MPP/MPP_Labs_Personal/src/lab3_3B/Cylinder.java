package lab3_3B;

public class Cylinder {

	private double radius;
	private double height;
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	/**
	 * formula: PI.r².h
	 * @return
	 */
	public double computeVolume() {
		return (Math.PI * Math.pow(radius, 2)) * height;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
