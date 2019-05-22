package elements;

import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;
import primitives.Util;

/**
 * Camera class contains point3D and 3 vectors and sends ray to geometry
 * 
 * @author Tzvika and Eitan
 * 
 */
public class Camera {
	private Point3D _p0; // the center of projection
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;


	/**
	 * constructor gets pointsD and 2 vectors, its check that the 2 vector are
	 * orthogonal and creates vector to right.
	 * 
	 * @param p0
	 * @param vUp
	 * @param vTo
	 */
	public Camera(Point3D p0, Vector vUp, Vector vTo) {
		_p0 = new Point3D(p0);
		_vUp = vUp.normal();
		_vTo = vTo.normal();
		if (_vUp.orthogonal(_vTo))
			_vRight = _vTo.crossProduct(_vUp).normal();
		else
			throw new IllegalArgumentException("Error!!! The vectors vUp and vTo nust be orthogonal");
	}
	// getters

	public Point3D getP0() {

		return _p0;
	}

	public Vector getVUp() {

		return _vUp;
	}

	public Vector getVTo() {

		return _vTo;
	}

	public Vector getVRight() {

		return _vRight;
	}
/**
 * This Function creates ray from camera to view plane
 * @param Nx  the amount of pixels on X axis
 * @param Ny  the amount of pixels on y axis
 * @param i   number of pixel from left side of view plane
 * @param j   number of pixel from up side of view plane
 * @param distance   distance from camera to view plane
 * @param view_width 
 * @param view_height
 * @return ray
 */
	public Ray constructRayThroughPixel(int Nx, int Ny, int i, int j, double distance, double view_width,

			double view_height) {

		Point3D _Pc = this._p0.add(_vTo.product(distance));// _Pc is the center of the view plane
		double _Ry = view_height / Ny;//pixel height

		double _Rx = view_width/ Nx; //  pixel width

		// pixel center calculation:

		double _Yj = ((j - Ny / 2)*_Ry) + (_Ry / 2);// offset by axis Y on view

		double _Xi = ((i - Nx / 2) * _Rx) + (_Rx / 2);// offset by axis X on view

		Point3D _Pij = _Pc;

		if (_Xi != 0)

			_Pij = _Pij.add(_vRight.product(_Xi)); // _Pij is pixel center calculating

		// _Pij=_Pij+(_Xi*_vRight-_Yj*_vUp)

		if (_Yj != 0)

			_Pij = _Pij.add(_vUp.product(-_Yj));


		Vector _Vij = _Pij.subtract(_p0).normal();// _Vij is vector from camera to pixel on the view

		return new Ray(_p0, _Vij);

	}
}
