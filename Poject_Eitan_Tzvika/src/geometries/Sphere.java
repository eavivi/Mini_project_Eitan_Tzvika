package geometries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;

/**
 * sphere in 3D
 * 
 * @author Tzvika and Eitan the sphere have center point and radius that
 *         represent the distance of all points in the sphere from center
 */
public class Sphere extends RadialGeometry {// ביטלתי סטר ועידכנתי בנאי

	Point3D _center;

	/* Constructors */

	/**
	 * constructor with center and radius
	 * 
	 * @param center
	 * @param radius
	 */

	public Sphere(Point3D center, double radius) {
		super(radius);
		this._center = new Point3D(center);
	}

	/* Getter */

	/**
	 * getter for the center point
	 * 
	 * @return
	 */
	public Point3D getCenter() {
		return _center;
	}

	/* Administration */

	@Override
	public Vector getNormal(Point3D p) {
		return p.subtract(_center).normal();
	}

	@Override
	public List<Point3D> findIntersections(Ray intersectionRay) {
		Point3D p0 = intersectionRay.getP0();
		Vector vectorDirection = intersectionRay.getDirection();
		//if p0 is center of sphere then the intersection point is p0 + radius*vectorDirection
		if (p0.equals(_center))
			return new ArrayList<Point3D>(Collections.singletonList(p0.add(vectorDirection.product(_radius))));
		Vector d = p0.subtract(_center);
		//a,b,c below represent the t that p0+t*vectorDirection intersection the sphere when at^2+bt+c=0
		double a = vectorDirection.dotProduct(vectorDirection);
		double b = 2*vectorDirection.dotProduct(d);
		double c = d.dotProduct(d) - _radius*_radius;
		double discriminant = b*b - 4*a*c;
		//3 case:
		//discriminant < 0 => the Ray not intersect the sphere
		//discriminant = 0 => the Ray just touch the sphere
		//discriminant > 0 => the Ray intersect the sphere in 2 points
		//but we use just t >= 0
		//so create list and add just appropriate points
		if (discriminant < 0)
			return EMPTY_LIST;
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
		double t1 = (-b + discriminant)/(2*a);
		if (t1 >= 0)
			intersectionPoints.add(p0.add(vectorDirection.product(t1)));
		double t2 = (-b - discriminant)/(2*a);
		if (discriminant > 0 && t2 >= 0)
			intersectionPoints.add(p0.add(vectorDirection.product(t2)));
		return intersectionPoints;
	}
}
