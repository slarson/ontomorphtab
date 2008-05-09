package edu.ucsd.ccdb.ontomorph2.core.spatial;

import com.jme.math.Matrix3f;

public interface IRotation {
	
		public edu.ucsd.ccdb.ontomorph2.core.scene.ISlide lnkISlide = null;
	public float getX();
	public float getY();
	public float getZ();
	public Matrix3f asMatrix3f();

}
