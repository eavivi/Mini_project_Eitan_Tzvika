package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class to test the functions in class Tube
 * @author Tzvika and Eitan
 *
 */
public class TubeTest {

	/**
	 * test the function getNormal
	 */
	@Test
	public void testNormal() {
		//in the tube x^2+y^2=1, the normals of all Points that intersect the x-axis is (1,0,0) or (-1,0,0) 
		//Ditto y-axis (0,1,0) or (0,-1,0)
		Tube t = new Tube(1.0, new Ray(new Point3D(0,0,0), new Vector(0,0,1)));
		assertEquals(new Vector(1,0,0), t.getNormal(new Point3D(1,0,3)));
		assertEquals(new Vector(0,1,0), t.getNormal(new Point3D(0,1,45)));
		assertEquals(new Vector(0,-1,0), t.getNormal(new Point3D(0,-1,12)));
		assertEquals(new Vector(-1,0,0), t.getNormal(new Point3D(-1,0,32)));
	}

}
