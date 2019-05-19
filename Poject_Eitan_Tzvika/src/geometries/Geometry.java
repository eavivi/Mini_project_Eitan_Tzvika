package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * geometry interface to represent some geometry
 * @author צביקה
 *
 */
public interface Geometry extends Intersectable{
	/**
	 * normal to geometry in some point
	 * @param p the point
	 * @return
	 */
	Vector getNormal(Point3D p);
}
