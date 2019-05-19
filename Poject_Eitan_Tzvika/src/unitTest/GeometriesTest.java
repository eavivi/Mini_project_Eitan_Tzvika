package unitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import geometries.Geometries;
import geometries.Plane;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * junit class to test the class Geometries
 * @author Tzvika and Eitan
 *
 */
public class GeometriesTest {

	/**
	 * test the function findIntersection
	 */
	@Test
	public void testIntersection() {
		
		Plane p = new Plane(new Point3D(1,0,0), new Point3D(0,1,0), new Point3D(0,0,0));
		Sphere s = new Sphere(new Point3D(0,0,0), 2);
		Geometries geometries = new Geometries(p,s);
		Ray r = new Ray(new Point3D(0,0,-5), new Vector(0,0,1));
		List<Point3D> intersectionWithP = p.findIntersections(r);
		List<Point3D> intersectionWithS = s.findIntersections(r);
		List<Point3D> intersectionWithGeometries = geometries.findIntersections(r);
		//check if all the intersection points of geometries intersection to p or s.
		for (Point3D point : intersectionWithGeometries) {
			assertTrue(intersectionWithP.contains(point) || 
					intersectionWithS.contains(point));
		}
		//check if all the intersection points of p intersection geometries.
		for (Point3D point : intersectionWithP) {
			assertTrue(intersectionWithGeometries.contains(point));
		}
		//check if all the intersection points of s intersection geometries.
		for (Point3D point : intersectionWithS) {
			assertTrue(intersectionWithGeometries.contains(point));
		}
	}

}
