package unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class to test the functions in class Sphere
 * @author Tzvika and Eitan
 *
 */
public class SphereTest {

	/**
	 * test the function getNormal
	 */
	@Test
	public void testNormal() {
		//in the sphere the normal of all Points that intersect the x-axis is (1,0,0) or (-1,0,0) 
		//Ditto y-axis (0,1,0) or (0,-1,0)
		//Ditto z-axis (0,0,1) or (0,0,-1)
		Sphere s = new Sphere(new Point3D(0,0,0), 2);
		assertEquals(new Vector(1,0,0),s.getNormal(new Point3D(2,0,0)));
		assertEquals(new Vector(0,1,0),s.getNormal(new Point3D(0,2,0)));
		assertEquals(new Vector(0,0,-1),s.getNormal(new Point3D(0,0,-2)));
	}
	
	/**
	 * test the function findIntersection
	 */
	@Test
	public void testIntersection() {
		Sphere s = new Sphere(new Point3D(0,0,0), 2);
		Ray r1 = new Ray(new Point3D(0,0,-5), new Vector(0,0,1));
		List<Point3D> points1 = s.findIntersections(r1);
		assertTrue("the intersection of Ray: {(0,0,-5) + t(0,0,1)} "
				+ "with the sphere x^2+y^2+z^2=4 is (0,0,-2) , (0,0,2)",
				points1.size() == 2 
				&& points1.get(0).equals(new Point3D(0,0,-2))
				&& points1.get(1).equals(new Point3D(0,0,2)));
		Ray r2 = new Ray(new Point3D(0,0,0), new Vector(0,0,1));
		List<Point3D> points2 = s.findIntersections(r2);
		assertTrue("the intersection of Ray: {(0,0,0) + t(0,0,1)} "
				+ "with the sphere x^2+y^2+z^2=4 is (0,0,2)",
				points2.size() == 1
				&& points2.get(1).equals(new Point3D(0,0,2)));
		Ray r3 = new Ray(new Point3D(3,0,0), new Vector(0,0,1));
		assertTrue("there havn't intersection of Ray: {(3,0,0) + t(0,0,1)} "
				+ "with the sphere x^2+y^2+z^2=4",s.findIntersections(r3).isEmpty());
		
		
	}
}
