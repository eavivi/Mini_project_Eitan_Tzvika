package geometries;

import java.util.ArrayList;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * tube is non limit Cylinder
 * @author Tzvika and Eitan
 * the tube have ray and radius that represent the distance between all point in tube and the ray
 */
public class Tube extends RadialGeometry {

	protected Ray _Ray;

	/*    Constructors    */

	/**
	 * constructor with ray and radius
	 * @param ray
	 * @param radius
	 */
	public Tube(Double radius, Ray ray) {
		super(radius);
		this._Ray = ray;
	}

	/*    Getters    */

	/**
	 * getter for the ray of tube
	 * @return
	 */
	public Ray getRay() {
		return _Ray;
	}

	@Override
	public Vector getNormal(Point3D p) {
		double t = _Ray.getDirection().dotProduct(p.subtract(_Ray.getP0()));
		Point3D center = _Ray.getP0().add(_Ray.getDirection().product(t));	
		return p.subtract(center).normal();
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray intersectionRay) {
		// TODO Auto-generated method stub
		return null;
	}
}
