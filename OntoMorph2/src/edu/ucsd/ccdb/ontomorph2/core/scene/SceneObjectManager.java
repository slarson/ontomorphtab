package edu.ucsd.ccdb.ontomorph2.core.scene;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.ucsd.ccdb.ontomorph2.core.semantic.ISemanticThing;
import edu.ucsd.ccdb.ontomorph2.core.semantic.ISemanticsAware;
import edu.ucsd.ccdb.ontomorph2.util.MyNode;


/**
 * Keeps lists of all scene objects.
 * 
 * @author Stephen D. Larson (slarson@ncmir.ucsd.edu)
 *
 */
public class SceneObjectManager {

	

	ArrayList<Slide> slides = null;
	Set<INeuronMorphology> cells = null;
	Set<Curve3D> curves = null;
	Set<Surface> surfaces = null;
	Set<DataMesh> meshes = null;
	Set<IVolume> volumes = null;
	/**
	 * Holds singleton instance
	 */
	private static SceneObjectManager instance;
	
	private SceneObjectManager() {
		slides = new ArrayList<Slide>();
		cells = new HashSet<INeuronMorphology>();
		curves = new HashSet<Curve3D>();
		surfaces = new HashSet<Surface>();
		meshes = new HashSet<DataMesh>();
		volumes = new HashSet<IVolume>();
	}

	public void addSlide(ISceneObject s) {
		slides.add((Slide) s);
		
	}

	public void addCell(ISceneObject s) {
		cells.add((INeuronMorphology) s);
	}
	
	public MyNode getCellTree() {
		MyNode root = new MyNode("Cells", null);
		
		for (INeuronMorphology n : getCells()) {
			MyNode node = new MyNode(n.getName(), n);
			
			for (ISemanticThing t : ((ISemanticsAware)n).getAllSemanticThings()) {	
				node.children.add(new MyNode(t.getLabel(), t));
			}
			
			root.children.add(node);
		}
				
		return root;
	}

	public void addVolume(ISceneObject s) {
		volumes.add((IVolume) s);
	}

	public Set<IVolume> getVolumes() {
		return volumes;
	}

	public Set<INeuronMorphology> getCells() {
		return cells;
	}

	public ArrayList<Slide> getSlides() {
		return slides;
	}

	public void addMesh(ISceneObject s) {
		meshes.add((DataMesh) s);
	}

	public Set<DataMesh> getMeshes() {
		return meshes;
	}

	public Set<Curve3D> getCurves() {
		return curves;
	}

	public Set<Surface> getSurfaces() {
		return surfaces;
	}

	public void addCurve(Curve3D curve1) {
		curves.add(curve1);
	}

	/**
	 * Returns the singleton instance.
	 @return	the singleton instance
	 */
	static public SceneObjectManager getInstance() {
		if (instance == null) {
			instance = new SceneObjectManager();
		}
		return instance;
	}

	public void addSurface(Surface surf2) {
		surfaces.add(surf2);
	}

}