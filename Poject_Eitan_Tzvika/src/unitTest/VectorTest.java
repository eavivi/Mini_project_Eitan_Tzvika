//Tzvika Schwartz 	305260135
//Eitan Avivi		305359531

package unitTest;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;
import primitives.Vector;
import primitives.Util;

/**
 * class to test the functions in class Vector
 * 
 * @author Tzvika and Eitan
 *
 */
public class VectorTest {

	// static random to use in test functions
	static Random r = new Random();

	/**
	 * test didn't can generate vector 0
	 */
	@Test
	public void testFailZero() {
		try {
			new Vector(0, 0, 0);
			fail("didn't throw Illegel Argument Exception");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	/**
	 * test the function add
	 */
	@Test
	public void testAdd() {
		for (int i = 0; i < 3; i++) {
			int[] numbers = randomes(6);
			try {
				Vector v1 = new Vector(numbers[0], numbers[1], numbers[2]);
				Vector v2 = new Vector(numbers[3], numbers[4], numbers[5]);
				Vector v3 = new Vector(numbers[0] + numbers[3], numbers[1] + numbers[4], numbers[2] + numbers[5]);
				assertEquals("v1+v2 need to be " + v3 + " and not " + v1.add(v2), v3, v1.add(v2));
			} catch (IllegalArgumentException e) {
				// in case vector 0
				assertTrue(true);
			}
		}
	}

	/**
	 * test the function subtract
	 */
	@Test
	public void testSubtract() {
		for (int i = 0; i < 3; i++) {
			int[] numbers = randomes(6);
			try {
				Vector v1 = new Vector(numbers[0], numbers[1], numbers[2]);
				Vector v2 = new Vector(numbers[3], numbers[4], numbers[5]);
				Vector v3 = new Vector(numbers[0] - numbers[3], numbers[1] - numbers[4], numbers[2] - numbers[5]);
				assertEquals("v1-v2 need to be " + v3 + " and not " + v1.subtract(v2), v3, v1.subtract(v2));
			} catch (IllegalArgumentException e) {
				// in case vector 0
				assertTrue(true);
			}
		}
	}

	/**
	 * test the function dotProduct
	 */
	@Test
	public void testDotProduct() {
		// check two vectors in same direction
		Vector v1 = new Vector(1, 1, 1);
		Vector v2 = new Vector(2, 2, 2);
		assertTrue("" + v1 + "*" + v2 + " need to be 6 and not " + v1.dotProduct(v2), 6 == v1.dotProduct(v2));

		// check two vectors in opposite directions
		Vector v3 = new Vector(1, 1, 1);
		Vector v4 = new Vector(-1, -1, -1);
		assertTrue("" + v3 + "*" + v4 + " need to be -3 and not " + v3.dotProduct(v4), -3 == v3.dotProduct(v4));

		// check two orthogonal vectors
		Vector v5 = new Vector(1, 0, 0);
		Vector v6 = new Vector(0, 1, 0);
		assertTrue("" + v5 + "*" + v6 + " need to be 0 and not " + v5.dotProduct(v6), 0 == v5.dotProduct(v6));
	}

	/**
	 * test the function crossProduct
	 */
	@Test
	public void testCrossProduct() {
		// check two vectors in same direction
		Vector v1 = new Vector(1, 1, 1);
		Vector v2 = new Vector(2, 2, 2);
		try {
			Vector v3 = v1.crossProduct(v2);
			fail("vectors in same direction not have a cross product");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}

		// check two vectors in opposite directions
		Vector v4 = new Vector(1, 1, 1);
		Vector v5 = new Vector(-1, -1, -1);
		try {
			Vector v6 = v4.crossProduct(v5);
			fail("vectors in opposite direction not have a cross product");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}

		// check some two orthogonal vectors
		Vector v6 = new Vector(1, 0, 0);
		Vector v7 = new Vector(0, 1, 0);
		Vector v8 = new Vector(0, 0, 1);
		assertEquals("" + v6 + "x" + v7 + " need to be " + v8 + "and not " + v6.crossProduct(v7), v8,
				v6.crossProduct(v7));
	}

	/**
	 * test the function length
	 */
	@Test
	public void testLength() {
		assertTrue(5 == new Vector(3, 4, 0).length());
		assertTrue(10 == new Vector(8, 0, 6).length());
		assertTrue(Util.isZero(Math.sqrt(50) - new Vector(4, 5, -3).length()));
	}

	/**
	 * test the function normal
	 */
	@Test
	public void testNormal() {
		// the length of normal is always 1
		for (int i = 0; i < 3; i++) {
			int[] numbers = randomes(3);
			try {
				Vector v = new Vector(numbers[0], numbers[1], numbers[2]);
				assertTrue("the length of normal must be one" + v.normal().length(), Util.isOne(v.normal().length()));
			} catch (IllegalArgumentException e) {
				// in case vector 0
				assertTrue(true);
			}
		}
	}

	/**
	 * test the function product in scalar
	 */
	@Test
	public void testProduct() {
		assertEquals(new Vector(3, -12, 4.5), new Vector(-1, 4, -1.5).product(-3));
		// the length(ax,ay,az) = abs(a) length(x,y,z)
		for (int i = 0; i < 3; i++) {
			int[] numbers = randomes(4);
			try {
				Vector v = new Vector(numbers[0], numbers[1], numbers[2]);
				assertEquals("the length of product(a) must be abs(a)*length", v.product(numbers[3]).length(),
						Math.abs(numbers[3]) * v.length(), 0.00001);
			} catch (IllegalArgumentException e) {
				// in case vector 0
				assertTrue(true);
			}
		}

	}

	/**
	 * help function that lottery random numbers in range [-100,100]
	 * 
	 * @param count the count of numbers to lottery
	 * @return array of the lottery numbers
	 */
	private int[] randomes(int count) {
		int res[] = new int[count];
		for (int i = 0; i < count; i++) {
			res[i] = r.nextInt(201) - 100;
		}
		return res;
	}

}
