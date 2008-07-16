/**
 * 
 */
package edu.ucsd.ccdb.ontomorph2.core.scene.tangible;

import edu.ucsd.ccdb.ontomorph2.core.spatial.OMTVector;
import edu.ucsd.ccdb.ontomorph2.core.spatial.PositionVector;

/**
 * Represents a single point in a Bezier curve.  When it gets repositioned,
 * it updates that point in its parent BezierCurve automatically.
 * 
 * @author Stephen D. Larson (slarson@ncmir.ucsd.edu)
 *
 */
public class CurveAnchorPoint extends Tangible {
	int i = 0;
	Curve3D parentCurve = null;
	
	/**
	 * 
	 * @param curve - the parent curve for this anchor point
	 * @param position - the position of the point
	 * @param i - the index of the point in the curve
	 */
	public CurveAnchorPoint(Curve3D curve, OMTVector position, int i) {
		this.parentCurve = curve;
		this.setCoordinateSystem(curve.getCoordinateSystem());
		this.setRelativePosition(new PositionVector(position));
		this.i = i;
	}
	
	public void move(float dx, float dy, OMTVector constraint)
	{
		super.move(dx,dy,constraint);
		
		parentCurve.setControlPoint(this.i, this.getRelativePosition());
	}
}