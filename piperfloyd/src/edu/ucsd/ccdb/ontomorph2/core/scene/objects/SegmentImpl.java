package edu.ucsd.ccdb.ontomorph2.core.scene.objects;

import java.awt.Color;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import edu.ucsd.ccdb.ontomorph2.core.semantic.ISemanticThing;
import edu.ucsd.ccdb.ontomorph2.core.semantic.ISemanticsAware;

/**
 * Implementation of ISegment.  Also aware of semantic tags.
 * @author Stephen D. Larson (slarson@ncmir.ucsd.edu)
 * @see ISegment
 * @see ISemanticsAware
 *
 */
public class SegmentImpl extends SceneObject implements ISegment, ISemanticsAware {

	BigInteger _id;
	float[] _proxPoint;
	float[] _distPoint;
	float _proxRad;
	float _distRad;
	BigInteger _segGroupId;
	NeuronMorphology parentCell;
	
	public SegmentImpl(NeuronMorphology parentCell, BigInteger id, float[] proximalPoint, float[] distalPoint, 
			           float proxRadius, float distRadius, BigInteger segGroupId) {
		_id = id;
		_proxPoint = proximalPoint;
		_distPoint = distalPoint;
		_proxRad = proxRadius;
		_distRad = distRadius;
		_segGroupId = segGroupId;
		this.parentCell = parentCell;
	}
	
	public float[] getProximalPoint() {
		return _proxPoint;
	}

	public float[] getDistalPoint() {
		return _distPoint;
	}

	public float getProximalRadius() {
		return _proxRad;
	}

	public float getDistalRadius() {
		return _distRad;
	}

	public BigInteger getSegmentGroupId() {
		return _segGroupId;
	}

	public void select() {
		getParentCell().selectSegment(this);
	}

	public void unselect() {
		getParentCell().unselectSegment(this);
	}

	public boolean isSelected() {
		return getParentCell().getSelectedSegments().contains(this);
	}

	public NeuronMorphology getParentCell() {
		return this.parentCell;
	}
}
