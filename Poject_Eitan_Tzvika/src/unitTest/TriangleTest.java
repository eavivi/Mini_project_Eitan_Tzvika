package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * junit class to test the class Triangle
 * @author Tzvika and Eitan
 *
 */
public class TriangleTest {

	/**
	 * test the function findIntersection
	 */
	@Test
	public void testIntersection() {
		Triangle t = new Triangle(new Point3D(1,0,0), new Point3D(0,1,0), new Point3D(0,0,0));
		Ray r1 = new Ray(new Point3D(0,0,-5), new Vector(0,0,1));
		assertTrue("the intersection of Ray: {(0,0,-5) + t(0,0,1)} "
				+ "with triangle {(1,0,0),(0,1,0),(0,0,0)} is (0,0,0)",
				t.findIntersections(r1).isEmpty());
		Ray r2 = new Ray(new Point3D(3,3,0), new Vector(0,0,1));
		assertTrue("there havn't intersection of Ray: {(3,3,0) + t(0,0,1)} "
				+ "with triangle {(1,0,0),(0,1,0),(0,0,0)}",
				t.findIntersections(r2).isEmpty());
	}

}
