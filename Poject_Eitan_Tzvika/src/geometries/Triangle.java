package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * Triangle in 3D
 * 
 * @author Tzvika and Eitan the triangle thre 3D points (p1,p2,p3)
 */
public class Triangle extends Plane {

	/* Constructors */

	/**
	 * Constructor with three points
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		super(p1, p2, p3);
	}

	/* Getters */

	/**
	 * getter for the first point
	 * 
	 * @return
	 */
	public Point3D getP1() {
		return _p1;
	}

	/**
	 * getter for the second point
	 * 
	 * @return
	 */
	public Point3D getP2() {
		return _p2;
	}

	/**
	 * getter for the third point
	 * 
	 * @return
	 */
	public Point3D getP3() {
		return _p3;
	}

	@Override
	public List<Point3D> findIntersections(Ray intersectionRay) {
		List<Point3D> intersectionPoints = super.findIntersections(intersectionRay);
		if (intersectionPoints.isEmpty())
			return EMPTY_LIST;
		Point3D p = intersectionPoints.get(0);
		Point3D p0 = intersectionRay.getP0();
		Vector v = intersectionRay.getDirection();
		Vector v1, v2, v3;

		try {
			v1 = _p1.subtract(p0);
			v2 = _p2.subtract(p0);
			v3 = _p3.subtract(p0);
		} catch (Exception e) {
			// 
			return EMPTY_LIST;
		}
		
		if (isZero(v1.dotProduct(_normalVec))) {
			p0 = p0.add(v);
			v1 = _p1.subtract(p0);
			v2 = _p2.subtract(p0);
			v3 = _p3.subtract(p0);
		}
		
		Vector N1 = v1.crossProduct(v2).normal();
		Vector N2 = v2.crossProduct(v3).normal();
		Vector N3 = v3.crossProduct(v1).normal();
		
		double d1 = v.dotProduct(N1), d2 = v.dotProduct(N2), d3 = v.dotProduct(N3);
		// if one or more is zero the point is outside triangle
		if (Util.isZero(d1) || Util.isZero(d2) || Util.isZero(d3))
			return EMPTY_LIST;
		// if d1,d2,d3 have same sign the point in inside triangle
		if ((d1 > 0 && d2 > 0 && d3 > 0) || (d1 < 0 && d2 < 0 && d3 < 0))
			return intersectionPoints;
		// otherwise
		return EMPTY_LIST;
	}
	
}
