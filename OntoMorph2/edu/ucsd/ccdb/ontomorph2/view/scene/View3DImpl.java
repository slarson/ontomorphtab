package edu.ucsd.ccdb.ontomorph2.view.scene;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jme.math.Vector3f;
import com.jme.scene.Node;

import edu.ucsd.ccdb.ontomorph2.core.scene.IMesh;
import edu.ucsd.ccdb.ontomorph2.core.scene.INeuronMorphology;
import edu.ucsd.ccdb.ontomorph2.core.scene.ISlide;
import edu.ucsd.ccdb.ontomorph2.core.scene.MeshImpl;
import edu.ucsd.ccdb.ontomorph2.core.scene.SlideImpl;
import edu.ucsd.ccdb.ontomorph2.core.spatial.CurveImpl;
import edu.ucsd.ccdb.ontomorph2.core.spatial.ICurve;
import edu.ucsd.ccdb.ontomorph2.core.spatial.IPosition;
import edu.ucsd.ccdb.ontomorph2.core.spatial.IRotation;
import edu.ucsd.ccdb.ontomorph2.core.spatial.ISurface;
import edu.ucsd.ccdb.ontomorph2.core.spatial.RotationImpl;
import edu.ucsd.ccdb.ontomorph2.core.spatial.SurfaceImpl;

public class View3DImpl extends Node implements IView3D {
	
	private Node slidesNode = null;
	private Node cellsNode = null;
	private Node curvesNode = null;
	private Node surfacesNode = null;
	private Node meshesNode = null;
	private Set<INeuronMorphologyView> cells = null;
	
	public View3DImpl() {
		slidesNode = new Node();
		cellsNode = new Node();
		curvesNode = new Node();
		surfacesNode = new Node();
		meshesNode = new Node();
		cells = new HashSet<INeuronMorphologyView>();
		this.attachChild(slidesNode);
		this.attachChild(cellsNode);
		this.attachChild(curvesNode);
		this.attachChild(surfacesNode);
		this.attachChild(meshesNode);
	}
	
	public void setSlides(List<ISlide> slides) {
		slidesNode.detachAllChildren();
		for(ISlide slide : slides){
			URL imageURL = slide.getImageURL();
			IPosition position = slide.getPosition();
			IRotation rotation = slide.getRotation();
			slidesNode.attachChild(new SlideViewImpl(imageURL, position, rotation));
		}
	}
	
	public void setCells(Set<INeuronMorphology> cells) {
		cellsNode.detachAllChildren();
		for(INeuronMorphology cell : cells) {
			INeuronMorphologyView cellView = new NeuronMorphologyViewImpl(cell);
			Node n = cellView.getNode();
			cellsNode.attachChild(n);
			this.cells.add(cellView);
		}
	}

	public void setCurves(Set<ICurve> curves) {
		curvesNode.detachAllChildren();
		for(ICurve curve : curves) {
			curvesNode.attachChild((CurveImpl)curve);
		}
		
	}

	public void setSurfaces(Set<ISurface> surfaces) {
		surfacesNode.detachAllChildren();
		for(ISurface surf : surfaces) {
			surfacesNode.attachChild((SurfaceImpl)surf);
		}
	}

	public Set<INeuronMorphologyView> getCells() {
		return this.cells;
	}

	public void setMeshes(Set<IMesh> meshes) {
		meshesNode.detachAllChildren();
		for(IMesh mesh : meshes) {
			MeshViewImpl meshView = new MeshViewImpl(mesh);
			meshesNode.attachChild(meshView.getNode());
		}
	}

}
