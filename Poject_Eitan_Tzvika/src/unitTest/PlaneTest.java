package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class to test the functions in class Plane
 * @author Tzvika and Eitan
 *
 */
public class PlaneTest {

	/**
	 * test the function getNormal
	 */
	@Test
	public void testNormal() {
		Plane p1 = new Plane(new Point3D(1,0,0), new Point3D(0,1,0), new Point3D(0,0,0));
		assertEquals("the normal of all points in the plane z=0 is (0,0,1)",
				new Vector(0,0,1), p1.getNormal(new Point3D(3,4,0)));
		Plane p2 = new Plane(new Point3D(1,0,0), new Point3D(0,0,0), new Point3D(0,0,1));
		assertEquals("the normal of all points in the plane y=0 is (0,1,0)",
				new Vector(0,1,0), p2.getNormal(new Point3D(3,0,45)));
		Plane p3 = new Plane(new Point3D(0,0,0), new Point3D(0,1,0), new Point3D(0,0,1));
		assertEquals("the normal of all points in the plane x=0 is (1,0,0)",
				new Vector(1,0,0), p3.getNormal(new Point3D(0,43,12)));
	}
	
	/**
	 * test the function findIntersection
	 */
	@Test
	public void testIntersection() {
		Plane p = new Plane(new Point3D(1,0,0), new Point3D(0,1,0), new Point3D(0,0,0));
		Ray r1 = new Ray(new Point3D(0,0,-5), new Vector(0,0,1));
		assertEquals("the intersection of Ray: {(0,0,-5) + t(0,0,1)} with plan z=0 is (0,0,0)",
				new Point3D(0,0,0), p.findIntersections(r1).get(0));
		Ray r2 = new Ray(new Point3D(0,0,1), new Vector(0,0,1));
		assertTrue("there haven't intersection of Ray: {(0,0,1) + t(0,0,1)} with plan z=0",
				p.findIntersections(r2).isEmpty());
		Ray r3 = new Ray(new Point3D(0,0,-1), new Vector(0,1,1));
		assertEquals("the intersection of Ray: {(0,0,-1) + t(0,1,1)} with plan z=0 is (0,1,0)",
				new Point3D(0,1,0), p.findIntersections(r3).get(0));
	}
}
