package geometries;
import primitives.Util;;

/**
 * abstract class to all geometry classes with field radius
 * @author Tzvika and Eitan
 * 
 */
public abstract class RadialGeometry implements Geometry {
	
	protected double _radius;
	
	/*    Constructors    */
	
	/**
	 * Constructor with radius
	 * @param radius
	 */
	public RadialGeometry(double radius) {
		if (Util.isZero(radius) || radius < 0)
			throw new IllegalArgumentException("radius must be a positive number");
		this._radius = radius;
	}
	
	/*    Getters    */
	
	/**
	 * getter for radius
	 * @return
	 */
	public double getRadius() {
		return _radius;
	}
	
}
