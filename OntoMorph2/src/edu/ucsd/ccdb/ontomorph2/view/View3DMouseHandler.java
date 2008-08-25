package edu.ucsd.ccdb.ontomorph2.view;

import java.math.BigInteger;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import com.jme.bounding.BoundingVolume;
import com.jme.input.KeyInput;
import com.jme.input.MouseInput;
import com.jme.input.action.InputActionEvent;
import com.jme.input.action.MouseInputAction;
import com.jme.intersection.PickData;
import com.jme.intersection.PickResults;
import com.jme.intersection.TrianglePickResults;
import com.jme.math.Ray;
import com.jme.math.Vector2f;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.scene.Geometry;
import com.jme.scene.Line;
import com.jme.scene.batch.GeomBatch;
import com.jme.scene.shape.Sphere;

import edu.ucsd.ccdb.ontomorph2.core.scene.TangibleManager;
import edu.ucsd.ccdb.ontomorph2.core.scene.tangible.ICable;
import edu.ucsd.ccdb.ontomorph2.core.scene.tangible.NeuronMorphology;
import edu.ucsd.ccdb.ontomorph2.core.scene.tangible.Tangible;

import edu.ucsd.ccdb.ontomorph2.core.spatial.DemoCoordinateSystem;
import edu.ucsd.ccdb.ontomorph2.core.spatial.RotationVector;

import edu.ucsd.ccdb.ontomorph2.util.FocusManager;
import edu.ucsd.ccdb.ontomorph2.util.Log;
import edu.ucsd.ccdb.ontomorph2.util.OMTVector;
import edu.ucsd.ccdb.ontomorph2.view.gui2d.ContextMenu;
import edu.ucsd.ccdb.ontomorph2.view.scene.NeuronMorphologyView;
import edu.ucsd.ccdb.ontomorph2.view.scene.TangibleView;

/**
 * Handles selection and manipulation of TangibleViews within the 3D world using the mouse.
 * 
 * @author caprea
 *
 */
public class View3DMouseHandler extends MouseInputAction {
	
//	==================================
	// DECLARES
	// - used for manipulating the objects, setting the mode says what you're doing with dragging
	//==================================
	public static final int METHOD_NONE = 0;
	public static final int METHOD_PICK = 1;
	public static final int METHOD_MOVE = 2;
	public static final int METHOD_SCALE = 4;
	public static final int METHOD_ROTATEX = 8;
	public static final int METHOD_ROTATEY = 16;
	public static final int METHOD_ROTATEZ = 32;
	public static final int METHOD_LOOKAT = 64;
	public static final int METHOD_MOVE_FREE = 100;	//not constrained by the coordinate system
	
	

	private static int manipulation = METHOD_PICK; //use accesor
	

	//For dealing with Mouse Events, track previous time and dragging
	boolean dragMode = false;
	long prevPressTime = 0;
	long dblClickDelay = 600;//in milliseconds (1000 = 1 sec)
	
	
	public void performAction( InputActionEvent evt ) 
    {
		//example code for jesus
		//if FocusManager.getInstance().isWidgetActive() return;
		if (FocusManager.get().isWidgetFocused())
		{
			System.out.println("trapped mouse event");
			return;
		}
		
		
    	if (evt.getTriggerPressed()) //
    	{
    		//+++++ BUTTON PRESSED  ++++++
    		//=========== MOUSE DOWN ========================
    		//double-click versus single-click belongs in child method
    		dragMode = true;	//begin assuming drag (deactive drag in upMouse event)
    		if (View.getInstance().getDebugMode()) Log.warn("mouse press");
    		
    		//pafind the index of which button pressed
    		for (int b = 0; b < MouseInput.get().getButtonCount(); b++)
    		{
    			if (MouseInput.get().isButtonDown(b))
    			{
    				onMousePress(b);
    				b = MouseInput.get().getButtonCount()+1; //all done
    			}
    		}
    	}
    	else
    	{
    		//+++++ BUTTON RELEASED (not pressed) ++++++
    		/*
    		 (enjoy a drink now and then), 
    		 will frequently check credit at 
    		 (moral) bank (hole in the wall), 
    		 */
    		boolean pushed = false;
    		int b= 0;
    		for (b=0; !pushed && b < MouseInput.get().getButtonCount(); b++)
    		{
    			if ( MouseInput.get().isButtonDown(b))
    			{
    				pushed = true;
    			}
    		}
    		//============ DRAG =========================
    		if (pushed && dragMode)
    		{
    			if (View.getInstance().getDebugMode()) Log.warn("mouse drag");
    			onMouseDrag();
    		}
    		//============ MOUSE UP/RELEASE =============
    		else if (!pushed && dragMode)	
    		{
    			dragMode = false;
    			if (View.getInstance().getDebugMode()) Log.warn("mouse release");
    			onMouseRelease();
    		}
    		//============ MOVE - MOUSE EVENT DEFAULT =======
    		else	
    		{
    			//System.out.println("mouse move/wheel");
    			onMouseMove();
    			onMouseWheel();
    		}
    	}
    }
	
	 
	/**
	 * Child method from handleMouseInput
	 */ 
	private void onMouseDrag()
	{
		
		boolean mouseLook = false;
		int numMouseBut = MouseInput.get().getButtonCount();
		
		//====================================
		//	MIDDLE MOUSE
		//====================================
		//mouse look trumps all other actions
    	
    	//middle click manipulates camera OR leftANDright mouse button
		//mouselook is true if there is a middle mouse button and it's pressed down
		if ( numMouseBut >= 2 ) if (MouseInput.get().isButtonDown(2)) mouseLook = true;
		 
		//mouselook is also true if left mouse and right mouse are pressed
		if ( MouseInput.get().isButtonDown(0) && MouseInput.get().isButtonDown(1) ) mouseLook = true;
		
		if (mouseLook)
		{
			//find mouse change
			float mx = MouseInput.get().getXDelta() / 100.0f;
			float my = MouseInput.get().getYDelta() / 100.0f;

			View.getInstance().getCamera().turnClockwise(mx);
			View.getInstance().getCamera().turnUp(my);
		}
		else if (MouseInput.get().isButtonDown(0)) //left 
		{
			//dragging
			manipulateCurrentSelection();
		}
	}
	
	/**
	 * Child method from handleMouseInput
	 * still need to check which buttons are pressed
	 */ 
	private void onMousePress(int buttonIndex)
	{
		{
			//	RIGHT CLICK
			if (1 == buttonIndex) //right
			{	
				//MouseInput.get().setCursorVisible(false); //hide mouse cursor
				doPick();
				ContextMenu.getInstance().displayMenuFor(MouseInput.get().getXAbsolute(),
						MouseInput.get().getYAbsolute(),TangibleManager.getInstance().getSelected());
			}
			else if (0 == buttonIndex) //left
			{
				//MouseInput.get().setCursorVisible(true); //show mouse cursor
				doPick();
			}
		
		
			long timenow = System.currentTimeMillis();
		
			//+Double+
			//check double click
			if (timenow < prevPressTime + dblClickDelay) 
			{
				onMouseDouble(buttonIndex);
			}
			prevPressTime = timenow;
		}	
	}
	
	private void onMouseRelease()
	{
		//fugacious method
	}
	
	private void onMouseDouble(int buttonIndex)
	{
		if (0 == buttonIndex) //left 
		{
			PickResults pr = getPickResults();
			//findCenter(pr.getPickData(0).getTargetMesh());
		}
		 
		Log.warn("Double click (" + buttonIndex + ") @ " + System.currentTimeMillis());
	}
	
	/**
	 * for debugging, remove this function
	 * ca: still working on it as of 08/22/08
	 *
	 */
	private OMTVector findCenter(GeomBatch queryMesh)
	{
		//This function is just a guesstimate, for a more accurate approach rewrite this to follow 
		//Calculating Properties of Polyhedra from Mathemetics for Comptuer Graphics (Hearn baker), pg817
		ArrayList<OMTVector> ovs = findVertices(queryMesh);
		
		//variables for the sums
		float sx = 0;
		float sy = 0;
		float sz = 0;
		long count = 0;
		
		DemoCoordinateSystem d = new DemoCoordinateSystem();
		
		
		//print normals buffer
		Geometry mother = queryMesh.getParentGeom();
		FloatBuffer fbNorms = mother.getBinormalBuffer(0);

		Tangible src = TangibleManager.getInstance().getSelectedRecent();
		
		OMTVector poscent = new OMTVector(queryMesh.getModelBound().getCenter());
		
		OMTVector left =  new OMTVector(View.getInstance().getCamera().getCamera().getLeft());
		OMTVector up =  new OMTVector(View.getInstance().getCamera().getCamera().getUp());	//must also offset a point by second dimension such that it makes a plane
		OMTVector dir = new OMTVector(View.getInstance().getCamera().getCamera().getDirection());
		
		OMTVector posa = new OMTVector(left.add(up).mult(-6f));
		OMTVector posb = new OMTVector(left.mult(-5f));
		
		
		OMTVector average = null;
		count = 0;
		for (int i=0; i < ovs.size(); i++)
		{
			OMTVector v = ovs.get(i);
			sx += v.getX();
			sy += v.getY();
			sz += v.getZ();
			
			Sphere s = View.getInstance().createSphere(v);
			if ( i == 1 ) 
			{
				//you must apply the coords then translate
				d.applyToSpatial(s);
				s.setLocalTranslation(v);
				s.setSolidColor(ColorRGBA.red);
			}
			View.getInstance().createDebugRay(posa, posb);
			
			System.out.println(v + " A " + s.getLocalTranslation() + " B " + s.getWorldTranslation() + " C " + s.getCenter());
			count++;		//incriment number of vertexs
		}
		
		//only create the vector if something useful will come of it (if center exists)
		//avoids 1/0 as an added bonus :)
		if (count > 0)
		{
			average = new OMTVector(sx/count,sy/count,sz/count);
		}
		
		return average;
	}
	
	
	/**
	 * Generates a list of OMTVectors that represent the points of the GeometryBatch's vertices
	 * @param jmeMesh the {@link GeomBatch} which has 3Dvertices
	 * @return an ArrayLIst of {@link OMTVector}s, or null if there was an error calculating them
	 * @author caprea
	 */
	private ArrayList<OMTVector> findVertices(GeomBatch jmeMesh)
	{
//		note: GeomMesh.gettris() is useless (ca)
		FloatBuffer fbVerts = jmeMesh.getVertexBuffer();
		ArrayList<OMTVector> omtPoints = new ArrayList<OMTVector>();
		DemoCoordinateSystem dcoords = new DemoCoordinateSystem();
		
		//Early exit for erroneous calls to this function
		if (jmeMesh == null) return null;
		
		try
		{
			//Loop through the FloatBuffer vertices, taking 3 elements at a time for each new OMT Vector
			for (int i=0; i < ((fbVerts.limit() + 1) / 3); i++)	//to get accurate size incriment by one then divide by three to get: # of vects
			{
				//take three elements from the buffer to make a 3D vector
				OMTVector n = new OMTVector(fbVerts.get(3*i), fbVerts.get(3*i+1), fbVerts.get(3*i+2));
				n.addLocal(dcoords.getOriginVector());
				omtPoints.add(n);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error: Exception calculating vertices for JME Mesh (invalid number of vertices?)");
			omtPoints = null;	//clear the list if there was a problem
		}
		
		return omtPoints;
	}
	
	/**
	 * Exists only for possible future expansion
	 * 
	 */
	private void onMouseMove()
	{	
		/*
		 * ca: I can't think of anything that would be appropriate here, except a poem
		 * 
			Presently my soul grew stronger; hesitating then no longer,
 			`Sir,' said I, `or Madam, truly your forgiveness I implore;
 			But the fact is I was napping, and so gently you came rapping,
 			And so faintly you came tapping, tapping at my chamber door,
 			That I scarce was sure I heard you' - here I opened wide the door; -
 			Darkness there, and nothing more.
		 */
	}
	
	/**
	 * Child method from handleMouseInput
	 */ 
	private void onMouseWheel()
	{
		//====================================
    	//	WHEEL
    	//====================================
		{
			float dx=MouseInput.get().getWheelDelta() / (View.getInstance().getKeyPressActionRate() * 20); //scale it by some factor so it's less jumpy
			if (dx != 0)	
			{
				//zoom camera if Z press
				if ( KeyInput.get().isKeyDown(KeyInput.KEY_Z) )
				{
					View.getInstance().getCamera().zoomIn(dx);	
				}
				//move camera if Z NOT pressed
				else
				{
					View.getInstance().getCamera().moveForward(dx);
				}
			}
		}
	}

	private void doPick() 
	{
		
//		get the tangible picked
		ArrayList<Tangible> pickedlist = psuedoPick(KeyInput.get().isControlDown(), true);   
		
		boolean shift = KeyInput.get().isShiftDown();
		
		//enable multiselect if shift is down
		if ( shift ) TangibleManager.getInstance().setMultiSelect(true);
		
		//decide how to select it, is this multi select, deselect, etc?
		if (pickedlist.size() == 0 && !shift) //nothing was picked so do deselect
		{
			//if there are no results, unselect everything
			TangibleManager.getInstance().unselectAll();
		}
		else if (pickedlist.size() > 0)
		{			
			pickedlist.get(0).select();	//select the closest one
		}
		
		//turn off multiselection
		TangibleManager.getInstance().setMultiSelect(false);
	}
	

	/**
	 * Mouse picking (selection) workhorse
	 * Facilitates mouse picking, but does NOT actually select the object, that must be done elsewhere.
	 * Example: selecting the Tangible that is returned from this function
	 * @param modifyControl changes picking behavior (such as in the case of selecting subcomponents; false to select cables, true to select cells)
	 * @param useRanking If true, omits lower-ranking {@link TangibleView}s from the pick results, such that a cell behind a curve would be selected instead of curve. False for unintelligent pickResults 
	 * @return an ArrayList {@link Tangible}, of all camera-ray-intersected Tangibles where element (0) is the closest to the camera 
	 */
	public ArrayList<Tangible> psuedoPick(boolean modifyControl, boolean useRanking)
	{
		Tangible chosenOne= null;
		PickResults rawresults = getPickResults();
		PickData singleResult = null;
		ArrayList<Tangible> possible = new ArrayList<Tangible>();
		
		//omit lower-ranked items if using ranking
		if ( rawresults.getNumber() > 0 && useRanking) rawresults = reorderPickPriority(rawresults);
		
//		Find out the tangible for the geometry that was decided on
		
		//if ( rawresults.getNumber() > 0)
		for ( int r=0; r < rawresults.getNumber(); r++)
		{
			TangibleView tv = null;
			singleResult = rawresults.getPickData(r);	//find the geomtry
			tv = TangibleViewManager.getInstance().getTangibleView(singleResult.getTargetMesh().getParentGeom()); //get a tanview instance that is mapped to the selected geomtry
			
			//special case for NeuronMorphologies because they have subcomponents
			//TODO: should probably bring this piece of code inside NeuronMorphologyView via 
			//some kind of action handler because this is kind of a hack
			if (tv instanceof NeuronMorphologyView && !modifyControl) //if control down proceed to the default case selection, otherwise return the part
			{
				NeuronMorphologyView nmv = (NeuronMorphologyView) tv;
				{
					//otherwise just select the part itself
					BigInteger id = nmv.getCableIdFromGeometry(singleResult.getTargetMesh().getParentGeom());
					ICable c = ((NeuronMorphology)nmv.getModel()).getCable(id);
					chosenOne = (Tangible) c;
				}
			}
			else if ( tv != null)
			{//CATCH ALL case for all other TangibleViews
				chosenOne = tv.getModel();
			}
			
			possible.add(chosenOne);	//add to the list of possible picks
		}
	
		possible = removeDuplicates(possible);
	
		return possible;
	}

	
	public ArrayList<Tangible> removeDuplicates(ArrayList<Tangible> list)
	{
		ArrayList<Tangible> edited = new ArrayList<Tangible>();
		Tangible single = null;
		
		//loop through and copy over the elements in list only if they do not already exist
		for (int i = 0; i < list.size(); i++)
		{
			single = list.get(i);
		
			//if the new list already contains the object don't add it
			if ( !edited.contains(single) ) edited.add(single);
		}
		
		return edited;
	}
	
	
	private PickResults reorderPickPriority(PickResults results)
	{
		PickData decision = null;
		PickResults reorder = new TrianglePickResults();
		
		//setup
		int cnt = results.getNumber();
		int highP = TangibleView.P_UNKNOWN;
		reorder.clear();
		reorder.setCheckDistance(true);
		
		//===== loop through all the item in results
		//===== find the highest priority item
		for (int i=0; i < cnt; i++)
		{
			GeomBatch obj = results.getPickData(i).getTargetMesh();
			TangibleView tv = TangibleViewManager.getInstance().getTangibleView(obj.getParentGeom());
			if ( tv != null)
			{
				int p = tv.pickPriority;
				if ( p > highP ) highP = p;	
			}
		}
		
		//===== get all instances of THAT item
			//copy all of those that belong to highP to reorder
		for (int i =0; i < cnt; i++)
		{
			GeomBatch obj = results.getPickData(i).getTargetMesh();
			TangibleView tv = TangibleViewManager.getInstance().getTangibleView(obj.getParentGeom());
			if ( tv != null)
			{
				int p = tv.pickPriority;
				if ( highP == p )
				{
					reorder.addPickData(results.getPickData(i));
				}	
			}
		}
		
		return reorder;
	} 
	
	/**
	 * Give the PickResults object for the object the mouse is trying to select on the screen
	 * Called during mouse handling
	 */
	private PickResults getPickResults() {
//		because dendrites can be densely packed need precision of triangles instead of bounding boxes
		PickResults pr = new TrianglePickResults(); 
		
		//Get the position that the mouse is pointing to
		Vector2f mPos = new Vector2f();
		mPos.set(MouseInput.get().getXAbsolute() ,MouseInput.get().getYAbsolute() );
		
		Vector3f closePoint = new Vector3f();
		Vector3f farPoint = new Vector3f();
		Vector3f dir = new Vector3f();
		
		// Get the world location of that X,Y value
		farPoint = View.getInstance().getDisplaySystem().getWorldCoordinates(mPos, 1.0f);
		closePoint = View.getInstance().getDisplaySystem().getWorldCoordinates(mPos, 0.0f);
		dir = farPoint.subtract(closePoint).normalize();
		
		// Create a ray starting from the camera, and going in the direction
		// of the mouse's location
		//Ray mouseRay = new Ray(closePoint, farPoint.subtractLocal(closePoint).normalizeLocal());
		Ray mouseRay = new Ray(closePoint, dir);
		
		View.getInstance().createDebugRay(closePoint, farPoint); //draws a picking ray and possibly a picking cone
		
		// Does the mouse's ray intersect the box's world bounds?
		pr.clear();
		pr.setCheckDistance(true);  //this function is undocumented, orders the items in pickresults
		View.getInstance().getView3D().findPick(mouseRay, pr);
		
		return pr;
	}
	
	
	
	
	
	/**
	 * Apply manipulations to the tangible that is currently selected
	 * Called during mouse handling
	 */
	private void manipulateCurrentSelection() 
	{		
	
		//CA: new movement code experiment
		//======================================
//		======================================
		/*
		float mx = 0;
		float my = 0;
		Vector2f mPos = new Vector2f();
		int x = MouseInput.get().getXDelta();
		int y = MouseInput.get().getYAbsolute();
		double angle = 0;
		mPos.set(x ,y );
		
		Vector3f dir = new Vector3f();
		
		dir = cam.getDirection();
		Vector3f dunit = new Vector3f(1,1,1);
		angle = dir.angleBetween(dunit);
		DemoCoordinateSystem d = new DemoCoordinateSystem();
		dunit = d.getOriginVector();
		mx = (float) (x * Math.cos( angle ));
		my = 0;  
		System.out.println("X:" + mx + " angle: " + angle);
		*/
//		======================================
		//======================================
		
		float mx = MouseInput.get().getXDelta();
		float my = MouseInput.get().getYDelta();
		//TODO: replace unity vectors with ones based on camera axis
		
		switch ( manipulation )
		{
		case METHOD_PICK:
			//do nothing
			break;
		case METHOD_MOVE:
			moveSelected(mx, my);
			break;
		case METHOD_ROTATEX:
			rotateSelected(mx, my, new OMTVector(1,0,0));
			break;
		case METHOD_ROTATEY:
			rotateSelected(mx, my,new OMTVector(0,1,0));
			break;
		case METHOD_ROTATEZ:
			rotateSelected(mx, my,new OMTVector(0,0,1));
			break;
		case METHOD_LOOKAT:
			//FIXME: /* needs to be re-engineered to deal with multiple selections */
			Log.warn("LOOK AT is broken");
			try
			{
				View.getInstance().getCamera().lookAt(TangibleManager.getInstance().getSelectedRecent().getAbsolutePosition() , new OMTVector(0,1,0)); //make the camera point a thte object in question	
			}
			catch(Exception e){};
			break;
		case METHOD_SCALE:
			scaleSelected(mx, my);
			break;
		}
			
		
	}
	
	private void moveSelected(float mx, float my) {
		for (Tangible manip : TangibleManager.getInstance().getSelected())
		{
			manip.move(mx, my, new OMTVector(1,1,0));
		}
	}
	
	private void rotateSelected(float mx, float my, OMTVector v) {
		for (Tangible manip : TangibleManager.getInstance().getSelected())
		{
			manip.rotate(mx, my, v);
		}
	}
	
	private void scaleSelected(float mx, float my) {
		for (Tangible manip : TangibleManager.getInstance().getSelected()) {
			manip.scale(mx, my,  new OMTVector(1,1,1));
		}
	}
		
	/**
	 * Sets the manipulation method that dragging the mouse should have on a selected object.
	 * 
	 * Use static fields defined in this class
	 * @param m - one of the constant ints defined in this class
	 * @see View3DMouseHandler#METHOD_LOOKAT
	 * @see View3DMouseHandler#METHOD_MOVE
	 * @see View3DMouseHandler#METHOD_NONE
	 * @see View3DMouseHandler#METHOD_PICK
	 * @see View3DMouseHandler#METHOD_ROTATEX
	 * @see View3DMouseHandler#METHOD_ROTATEY
	 * @see View3DMouseHandler#METHOD_ROTATEZ
	 * @see View3DMouseHandler#METHOD_SCALE
	 */
	public void setManipulation(int m)
	{
		manipulation = m;
		Log.warn("Manipulation method set to: " + m);
	}
	
}
