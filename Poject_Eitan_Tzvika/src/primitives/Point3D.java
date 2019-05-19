package primitives;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * Point in 3D (x,y,z)
 * @author Tzvika and Eitan
 *
 */
public class Point3D {
	
	Coordinate _x;
	Coordinate _y;
	Coordinate _z;
	
	/**
	 * static Point to represent the point (0,0,0)
	 */
	public static Point3D ZERO = new Point3D(0,0,0);
	
	/*    Constructors    */
	
	/**
	 * constructor with the three coordinates
	 * @param x coordinate in axis-x
	 * @param y coordinate in axis-y
	 * @param z coordinate in axis-z
	 */
	public Point3D(Coordinate x, Coordinate y,Coordinate z) {
		this._x = new Coordinate(x);
		this._y = new Coordinate(y);
		this._z = new Coordinate(z);
	}
	
	/**
	 * constructor with three numbers
	 * @param x number in axis-x
	 * @param y number in axis-y
	 * @param z number in axis-z
	 */
	public Point3D(double x, double y, double z) {
		this(new Coordinate(x), new Coordinate(y), new Coordinate(z));
	}
	
	/**
	 * copy constructor
	 * @param other point to copy
	 */
	public Point3D(Point3D other) {
		this(other._x, other._y, other._z);
	}
	
	/*    Getters    */
	
	/**
	 * getter for Coordinate x
	 * @return 
	 */
	public Coordinate getX() {
		return _x;
	}
	
	/**
	 * getter for Coordinate y
	 * @return 
	 */
	public Coordinate getY() {
		return _y;
	}
	
	/**
	 * getter for Coordinate z
	 * @return 
	 */
	public Coordinate getZ() {
		return _z;
	}
	
	/*    Administration    */
	
	@Override public boolean equals(Object obj) { 
		if (this == obj) return true; 
		if (obj == null) return false; 
		if (!(obj instanceof Point3D)) return false;
		Point3D other = (Point3D)obj; 
		return _x.equals(other._x) && 
				_y.equals(other._y) && 
				_z.equals(other._z);
	}
	
	@Override
	public String toString() {
		return "(" + _x + ", " + _y + ", " + _z + ")";
	}
	
	/**
	 * subtract with other point
	 * @param other the other point to subtract
	 * @return the vector between the points
	 */
	public Vector subtract(Point3D other) {
		return new Vector(_x.subtract(other._x).get(),
				_y.subtract(other._y).get(),
				_z.subtract(other._z).get());
	}
	
	/**
	 * add to point a vector
	 * @param v the vector to add
	 * @return the new point p + v
	 */
	public Point3D add(Vector v) {
		return new Point3D(_x.add(v._head._x), _y.add(v._head._y), _z.add(v._head._z));
	}
	
	/**
	 * distance^2 between two points
	 * @param other the other point
	 * @return 
	 */
	public double distance2(Point3D other) {
		return _x.subtract(other._x).multiply(_x.subtract(other._x))
				.add(_y.subtract(other._y).multiply(_y.subtract(other._y)))
				.add(_z.subtract(other._z).multiply(_z.subtract(other._z))).get();
	} 
	
	/**
	 * the distance between two point
	 * @param other the other point
	 * @return
	 */
	public double distance(Point3D other) {
		return Math.sqrt(this.distance2(other));
	}
	
	
}
