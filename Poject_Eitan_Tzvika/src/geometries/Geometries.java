package geometries;

import java.util.ArrayList;
import java.util.LinkedList;

import primitives.Point3D;
import primitives.Ray;

/**
 * Collection of geometries
 * @author Tzvika and Eitan
 *
 */
public class Geometries implements Intersectable{

	LinkedList<Intersectable> _geomeries = new LinkedList<Intersectable>();
	
	/**
	 * constructor with some geometries to add to collection
	 * @param geometries
	 */
	public Geometries(Intersectable ... geometries) {	
		add(geometries);
	}
	
	/**
	 * return Arraylist of Intersections points for collection of geometries 
	 * @param intersectoinRay
	 */
	@Override
	public ArrayList<Point3D> findIntersections(Ray intersectionRay) {
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
		//add all the intersection points of all geometries
		for (Intersectable geometry : _geomeries) {
			intersectionPoints.addAll(geometry.findIntersections(intersectionRay));
		}
		return intersectionPoints;
	}
	
	/**
	 * add some geometry to collection
	 * @param geometries the geometries to add
	 */
	public void add(Intersectable ... geometries) {
		for (Intersectable geometry : geometries) {
			_geomeries.add(geometry);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (Intersectable geometry : _geomeries) {
			res.append(geometry.toString() + "\n");
		}
		return res.toString();
	}
}
