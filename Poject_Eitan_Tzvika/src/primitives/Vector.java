package primitives;

import java.lang.reflect.Constructor;
import static primitives.Util.*;

/**
 * vector in 3D  
 * @author Tzvika and Eitan
 * vector between first of construction and the point head
 */
public class Vector {
	
	Point3D _head;
	
	/*    Constructors    */
	
	/**
	 * Constructor with Point head
	 * @param head the head point 
	 */
	public Vector(Point3D head) {
		//vector 0 is illegal
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("" + head + " can't be a head of vector");
		this._head = new Point3D(head);
	}
	
	/**
	 * Copy Constructor
	 * @param other the other vector to copy
	 */
	public Vector(Vector other) {
		this(other._head);
	}
	
	/**
	 * Constructor with three numbers of the head point
	 * @param x the number of head point in axis-x
	 * @param y the number of head point in axis-y
	 * @param z the number of head point in axis-z
	 */
	public Vector(double x, double y, double z) {
		this(new Point3D(x,y,z));
	}
	
	/*    Getters    */
	
	/**
	 * getter for head point
	 * @return
	 */
	public Point3D getHead() {
		return _head;
	}
	
	/*    Administration    */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false; 
		if (!(obj instanceof Vector)) return false;
		Vector other = (Vector)obj;
		return this._head.equals(other._head);
	}
	
	@Override
	public String toString() {
		String point = _head.toString();
		return "<" + point.substring(1,point.length()-1) + ">";
		//(a,b,c) => <a,b,c>
	}
	
	/**
	 * add vectors
	 * @param other the other vector to add
	 * @return 
	 */
	public Vector add(Vector other) {
		return new Vector(_head.add(other));
	}
	
	/**
	 * subtract vectors
	 * @param other the other vector to subtract
	 * @return
	 */
	public Vector subtract(Vector other) {
		return _head.subtract(other._head);
	}
	
	/**
	 * product in scalar 
	 * @param a the number to scale with
	 * @return (x*a, y*a, z*a)
	 */
	public Vector product(double a) {
		return new Vector(_head._x.get()*a, _head._y.get()*a,_head._z.get()*a);
	}
	
	/**
	 * dot product between two vectors
	 * @param other the other vector(x2,y2,z2) product 
	 * @return  x1*x2+y1*y2+z1*z2
	 */
	public double dotProduct(Vector other) {
		return _head._x.multiply(other._head._x)
				.add(_head._y.multiply(other._head._y))
				.add(_head._z.multiply(other._head._z)).get();
	}
	
	/**
	 * cross Product between two vectors
	 * @param other the other vector(x2,y2,z2) product 
	 * @return <y1*z2-y2*z1, x1*z2-x2*z1, x1*y2-x2*y1>
	 */
	public Vector crossProduct(Vector other) {
		Coordinate cx = _head._y.multiply(other._head._z)
				.subtract(_head._z.multiply(other._head._y));
		Coordinate cy = new Coordinate(-1)
				.multiply(_head._x.multiply(other._head._z)
				.subtract(_head._z.multiply(other._head._x)));
		Coordinate cz = _head._x.multiply(other._head._y)
				.subtract(_head._y.multiply(other._head._x));
		return new Vector(new Point3D(cx,cy,cz));
	}
	
	/**
	 * the length of vector
	 * @return sqrt(x^2+y^2+z^2)
	 */
	public double length() {
		return _head.distance(Point3D.ZERO);
	}
	
	/**
	 * the length^2 of vector
	 * @return x^2+y^2+z^2
	 */
	public double length2() {
		return _head.distance2(Point3D.ZERO);
	}
	
	/**
	 * normal of vector
	 * @return vector in same direction with length = 1
	 */
	public Vector normal() {
		return this.product(1/length());
	}
	
	/**
	 * check if other parallel to this
	 * @param other the other vector to check if it parallel
	 * @return 
	 */
	public boolean parallel(Vector other) {
		//if parallel then cross product create vector zero, so it throw exception
		try {
			this.crossProduct(other);
		}
		catch (Exception e) {
			return true;
		}
		return false;
	}
	
	/**
	 * check if other orthogonal to this
	 * @param other the vector to check orthogonalization
	 * @return
	 */
	public boolean orthogonal(Vector other) {
		//if orthogonalization then dot product is 0
		return isZero(this.dotProduct(other));
	}
}
