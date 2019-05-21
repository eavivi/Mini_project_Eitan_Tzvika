package elements;

import primitives.Color;

	public class AmbientLight {

		private Color _color;

		private double Ka;

		public Color get_color() {

			return _color;

		}

		public double getKa() {

			return Ka;

		}

		public AmbientLight(Color _Ia, double _Ka) {

			_color = new Color(_Ia);

			Ka = _Ka;

		}

		public Color getIntensity() {

			return new Color(_color.scale(Ka));

		}

	}


