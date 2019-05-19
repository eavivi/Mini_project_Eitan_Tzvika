package primitives;


//import primitives.Vector;

/**
 * Ray in 3D
 * @author Tzvika and Eitan
 * the ray have start Point(p0) and direction vector
 */
public class Ray {

	Point3D _p0;
	Vector _direction;
	
	/*    Constructor    */
	
	/**
	 * Constructor with start point and direction vector
	 * @param p0 start point
	 * @param direction direction vector
	 */
	
	public Ray(Point3D p0, Vector direction) { 
		this._p0= new Point3D(p0);
		this._direction= new Vector(direction);
	}
	
	/*    Getters    */
	
	/**
	 * getter of start point
	 * @return
	 */
	public Point3D getP0() {
		return _p0;
	}
	
	/**
	 * getter of direction vector
	 * @return
	 */
	public Vector getDirection() {
		return _direction;
	}
}
