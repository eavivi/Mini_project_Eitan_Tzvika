package geometries;

import primitives.Ray;

/**
 * Cylinder is tube with limit (height)
 * @author Tzvika and Eitan
 * the cylinder height to represent the limit
 */
public class Cylinder extends Tube{

	protected double _height;

	/* Constructor */
	
	/**
	 * constructor with radius , ray and height
	 * @param radius the radius of cylinder
	 * @param ray the ray of cylinder (in middle of cylinder)
	 * @param height the limit of cylinder
	 */
	public Cylinder(double radius, Ray ray, double height) {
		super (radius, ray);
		this._height = height;

	}

	/* Getter */

	/**
	 * getter for the limit (height)
	 * @return
	 */
	public double getHeight() { 
		return _height;
	}
	
	/*    Administration    */
	
	
}
