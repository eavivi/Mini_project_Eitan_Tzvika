package geometries;

import java.util.Collections;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * Interface describes a body that can be known 
 * whose points intersection with a particular ray
 * @author Tzvika and Eitan
 */
public interface Intersectable {
	/**
	 * the intersection of body with some ray 
	 * @param intersectionRay the ray of intersection
	 * @return arrayList of points that intersection
	 */
	public List<Point3D> findIntersections(Ray intersectionRay);
	public static final List<Point3D> EMPTY_LIST = Collections.EMPTY_LIST;
}
