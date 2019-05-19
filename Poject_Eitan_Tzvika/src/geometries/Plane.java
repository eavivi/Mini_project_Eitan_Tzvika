package geometries;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import static primitives.Util.*;
import primitives.Vector;

/**
 * plane in 3D
 * 
 * @author Tzvika and Eitan the plane represented by three points
 */

public class Plane implements Geometry {

	private Point3D _point;
	protected Vector _normalVec;

	protected Point3D _p1;
	protected Point3D _p2;
	protected Point3D _p3;

	/* Constructor */

	/**
	 * Constructor with the 3 points
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	/*
	 * if two or more points are equal than _direct1 or _direct2 or _normalVec are
	 * zero and plane must include three different points
	 */
	public Plane(Point3D p1, Point3D p2, Point3D p3) {

		this._point = new Point3D(p1);
		Vector direct1 = p1.subtract(p2);
		Vector direct2 = p1.subtract(p3);
		this._normalVec = new Vector(direct1.crossProduct(direct2)).normal();
		_p1 = new Point3D(p1);
		_p2 = new Point3D(p2);
		_p3 = new Point3D(p3);
	}

	/* Getters */

	/**
	 * getter for one of points in the plane
	 * 
	 * @return
	 */
	public Point3D getPoint() {
		return _point;
	}

	/**
	 * getter for normal to plane
	 * 
	 * @return
	 */
	public Vector getNormalVector() {
		return _normalVec;
	}

	/* Administration */

	@Override
	public Vector getNormal(Point3D p) {
		return _normalVec;
	}
	
	/**
	 * check if some point is on the plane
	 * @param p the point to check
	 * @return
	 */
	public boolean onThePlan(Point3D p) {
		//if p is on the plane then point=p or normal*(point-p)=0
		return _point.equals(p) || isZero(_normalVec.dotProduct(_point.subtract(p)));
	}

	@Override
	public List<Point3D> findIntersections(Ray intersectionRay) {
		Vector vectorDirection = intersectionRay.getDirection();
		Point3D p0 = intersectionRay.getP0();
		//if normal and vector direction are orthogonal then the ray is parallel to plane so no intersection points
		if (_normalVec.orthogonal(vectorDirection))
			return EMPTY_LIST;
		//if p0 is in the plane p0 is the only intersection point
		if (onThePlan(p0))
			return new ArrayList<Point3D>(Collections.singletonList(p0));
		//t below is the scalar that need to intersection, so if t >= 0 then p0 is "before" the plane
		double t = _normalVec.dotProduct(_point.subtract(p0))/_normalVec.dotProduct(vectorDirection);
		if (t >= 0){
			Point3D p = p0.add(vectorDirection.product(t));
			return new ArrayList<Point3D>(Collections.singletonList(p));
		}
		//otherwise p0 is after the plane
		return EMPTY_LIST;
	}

}
