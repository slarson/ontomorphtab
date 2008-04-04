package edu.ucsd.ccdb.ontomorph2.core;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import com.jme.math.FastMath;
import com.jme.math.Vector3f;

import edu.ucsd.ccdb.ontomorph2.view.ViewImpl;

public class SceneImpl extends Observable implements IScene {

	ArrayList<ISlide> slides = null;
	Set<ICell> cells = null;
	
	public SceneImpl() {
		slides = new ArrayList<ISlide>();
		cells = new HashSet<ICell>();
	}
	
	public void load() {
		//temporary hack to load a mockup
		URL sliceLoc = SceneImpl.class.getClassLoader().getResource("slice.jpg");
		SlideImpl slide1 = new SlideImpl(sliceLoc, null, null);
		SlideImpl slide2 = new SlideImpl(sliceLoc, new PositionImpl(0,0,2), null);
		slides.add(slide1);
		slides.add(slide2);
		
		CellImpl cell1 = new CellImpl();
		URL cell1URL = SceneImpl.class.getClassLoader().getResource("1220882a.morph.xml");
		cell1.setMorphologyViaURL(cell1URL);
		cell1.getMorphology().setPosition(new PositionImpl(3,3,3));
		cell1.getMorphology().setRotation(new RotationImpl(FastMath.DEG_TO_RAD*-90, new Vector3f(0,1,0)));
		cell1.getMorphology().setScale(0.01f);
		cells.add(cell1);
		changed();
	}

	public void save() {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ISlide> getSlides() {
		return slides;
	}
	
	public Set<ICell> getCells() {
		return cells;
	}

	 public void changed () {       
		  setChanged();                 
		  notifyObservers();            
	 }    
	
}
