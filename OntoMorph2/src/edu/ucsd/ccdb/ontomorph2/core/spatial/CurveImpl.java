package edu.ucsd.ccdb.ontomorph2.core.spatial;

import java.awt.Color;

import com.jme.curve.BezierCurve;
import com.jme.curve.Curve;
import com.jme.math.FastMath;
import com.jme.math.Matrix3f;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;

import edu.ucsd.ccdb.ontomorph2.util.ColorUtil;

public class CurveImpl extends BezierCurve implements ICurve{

	ColorRGBA color = null;
	float delta = 0.1f;
	private Vector3f _modelBinormal = null;
	
	public CurveImpl(String arg0, Vector3f[] arg1) {
		super(arg0, arg1);
	}

	/**
	 * Set the color of the curve.
	 */
	public void setColor(Color color) {
		this.setSolidColor(ColorUtil.convertColorToColorRGBA(color));
	}
	
	/**
	 * compute a very small vector that is 
	 * approximately tangent to the point of 'time' given
	 * @param time
	 * @return - the tangent Vector3f
	 */
	public Vector3f getTangent(float time) {
		Vector3f p1 = getPoint(getTimeMinusDelta(time));
		Vector3f p2 = getPoint(getTimePlusDelta(time));
		return p2.subtract(p1).normalize();
	}
	
	/**
	 * computes a very small vector that is approximately normal 
	 * to the point of 'time' given
	 * @param time
	 * @return - the tangent Vector3f
	 */
	public Vector3f getNormal(float time) {
		
		Vector3f px = getPoint(getTimeMinusDelta(time));
		Vector3f py = getPoint(getTimePlusDelta(time));
		
		Vector3f pe = getPoint(time);
		Vector3f pf = new Vector3f((py.x - px.x)/2+px.x, (py.y - px.y)/2+px.y, (py.z - px.z)/2+px.z);

		return pf.subtract(pe).normalize();
	}
	
	private float getTimeMinusDelta(float time) {
		if (time - delta < 0) {
			return 0;
		}
		return time-delta;
	}
	
	private float getTimePlusDelta(float time) {
		if (time + delta >= 1) {
			return 0.999f;
		}
		return time+delta;
	}

	public Curve asBezierCurve() {
		return this;
	}
	
	/**
	 * The model binormal sets a vector direction that is 
	 * defined as the standard for object that are rotated
	 * with respect to this curve.  Because the dot and cross 
	 * products are only defined within 0-180 degrees, this is 
	 * necessary to keep cells rotating around curves in the
	 * appropriate manner
	 * 
	 * @param binormal
	 */
	public void setModelBinormal(Vector3f binormal) {
		this._modelBinormal = binormal;
	}
	
	/**
	 * Sets the model binormal simply by defining the up vector and the time
	 * 
	 * @param up
	 * @param time
	 * @see setModelBinormal
	 */
	public void setModelBinormalWithUpVector(Vector3f up, float time) {
		this._modelBinormal = this.getTangent(time).cross(up).normalize();
	}
	
	/**
	 * returns the orientation of an object that is following this curve, 
	 * at a given time and precision, given an up vector
	 */
	public Matrix3f getOrientation(float time, float precision, Vector3f up) {
		if (up == null) {
			return getOrientation(time, precision);
		}
		Matrix3f rotation = new Matrix3f();

		//calculate tangent
		Vector3f tangent = getPoint(time).subtract(getPoint(time + precision));
		tangent = tangent.normalize();

		//calculate binormal
		Vector3f binormal = tangent.cross(up);
		binormal = binormal.normalize();
		if (_modelBinormal != null) {
			if (_modelBinormal.angleBetween(binormal) < FastMath.PI / 2) {
				binormal.negateLocal();
			}
		}

		//calculate normal
		Vector3f normal = binormal.cross(tangent);
		normal = normal.normalize();

		rotation.setColumn(0, tangent);
		rotation.setColumn(1, normal);
		rotation.setColumn(2, binormal);

		return rotation;
	}

}