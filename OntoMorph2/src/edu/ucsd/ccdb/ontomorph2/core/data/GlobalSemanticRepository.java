package edu.ucsd.ccdb.ontomorph2.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.stanford.smi.protege.model.Cls;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protege.model.SimpleInstance;
import edu.stanford.smi.protege.model.Slot;
import edu.stanford.smi.protege.util.ApplicationProperties;
import edu.stanford.smi.protegex.owl.database.OWLDatabaseModel;
import edu.stanford.smi.protegex.owl.model.OWLIndividual;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.ucsd.ccdb.ontomorph2.app.OntoMorph2;
import edu.ucsd.ccdb.ontomorph2.core.semantic.SemanticClass;
import edu.ucsd.ccdb.ontomorph2.core.semantic.SemanticInstance;
import edu.ucsd.ccdb.ontomorph2.observers.SceneObserver;
import edu.ucsd.ccdb.ontomorph2.util.OMTException;
import edu.ucsd.ccdb.ontomorph2.util.OMTOfflineException;
import edu.ucsd.ccdb.ontomorph2.view.gui2d.MyNode;


/**
 * Represents a database of semantic things.
 * @author Stephen D. Larson (slarson@ncmir.ucsd.edu)
 *
 */
public class GlobalSemanticRepository implements SemanticRepository {
	
	
	OWLDatabaseModel owlModel = null;
	Map<String, OWLNamedClass> clsFlyweightStore = new HashMap<String,OWLNamedClass>();
	/**
	 * Holds singleton instance
	 */
	private static GlobalSemanticRepository instance;
	
	private GlobalSemanticRepository() throws OMTOfflineException{
		if (!OntoMorph2.isOfflineMode()) {
			this.loadOntology();
		} else {
			throw new OMTOfflineException("Cannot use Global Semantic Repository when in offline mode!");
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getOWLModel()
	 */
	public OWLModel getOWLModel() {
		return owlModel;
	}

	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getSemanticClass(java.lang.String)
	 */
	public SemanticClass getSemanticClass(String uri) {
		OWLNamedClass cls = null;
		if (owlModel != null) {
			try {
				cls = clsFlyweightStore.get(uri);
				if (cls == null) {
					cls = owlModel.getOWLNamedClass(uri);
					clsFlyweightStore.put(uri, cls);
				}
			} catch (Exception e ) {
				throw new OMTException("Problem finding URI in semantic repository" + uri, e);
			}
		}
		SemanticClass s = new SemanticClass(cls, uri);
		s.addObserver(SceneObserver.getInstance());
		return s;
	}
	
	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getInstanceTree()
	 */
	public MyNode getInstanceTree() {
		MyNode root = new MyNode("Instances", null);
		for (SemanticInstance si : this.getCellInstances()) {
			root.children.add(new MyNode(si.getLabel(), si));
		}
		return root;
	}
	
	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getInstancesFromRoot(edu.ucsd.ccdb.ontomorph2.core.semantic.SemanticClass, boolean)
	 */
	public List<SemanticInstance> getInstancesFromRoot(SemanticClass rootClass, boolean requireLabel) {
		List<SemanticInstance> runningList = new ArrayList<SemanticInstance>();
		for (Iterator it = rootClass.getInstances().iterator(); it.hasNext(); ) {
			OWLIndividual i = (OWLIndividual)it.next();
			if (i instanceof SimpleInstance) {
				SemanticInstance si = new SemanticInstance(i);
				if (requireLabel) {
					if (si.getLabel() != null) {
						runningList.add(si);
					}
				} else {
					runningList.add(si);
				}
			}
			
		}
		return runningList;
	}

	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getCellInstances()
	 */
	public List<SemanticInstance> getCellInstances() {
		return getInstancesFromRoot(getSemanticClass("sao:sao1813327414"), true);
	}
	
	//initialize the semantic repository by connecting to the 
	//database and retriving a knowledge base object
	private void loadOntology() throws OMTOfflineException{
    	try {
    		    		
    		ApplicationProperties.setUrlConnectTimeout(100000);
			ApplicationProperties.setUrlConnectReadTimeout(100000);
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyPort", "8080");
			System.getProperties().put("proxyHost", "http://webproxy.ucsd.edu/proxy.pl");
//			JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModelFromURI("http://ccdb.ucsd.edu/SAO/1.2.9/SAO.owl");
			//JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModelFromURI("http://purl.org/nbirn/birnlex/ontology/BIRNLex-Anatomy.owl");
    		//JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModelFromURI("http://purl.org/nif/ontology/nif.owl");
			
			//ProjectManager projectManager = ProjectManager.getProjectManager();
			//URI uri = new URI("file://C:\/Documents\and\ Settings\/stephen\/Desktop\/nifSaved\/nif.pprj");
						
			//Project p = Project.loadProjectFromFile("etc/NIF/CKB_db.pprj", new ArrayList());
			Project p = Project.loadProjectFromFile("etc/NIF/CKB_mega_db_v2.pprj", new ArrayList());
						
			//projectManager.loadProject(uri);
			owlModel = (OWLDatabaseModel)p.getKnowledgeBase();
					    			
			/*
			JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModel();
			RepositoryManager rp = new RepositoryManager(owlModel);
			File dir = new File("C:/Documents and Settings/stephen/Desktop/nifSaved");
			rp.addGlobalRepository(new LocalFolderRepository(dir));
			FileReader reader = new FileReader("C:/Documents and Settings/stephen/Desktop/nifSaved/nif.owl");			
			owlModel.load(reader, FileUtils.langXMLAbbrev);
    		*/
    		
			/*
    		//must be done before getLabel() is run!!!
    		Slot rdfsLabel = owlModel.getSlot("rdfs:label");
    		
    		if (owlModel != null) {

    			Cls root = owlModel.getRootCls();
    			Cls entity = owlModel.getCls("bfo:Entity");
    			System.out.println("The root class is: " + entity.getName());
    			//Node rootNode = getTree().addRoot();
    			rdfsLabel = owlModel.getSlot("rdfs:label");
    			String label = (String)entity.getDirectOwnSlotValue(rdfsLabel);
    			String prefix = owlModel.getPrefixForResourceName(entity.getName());
    			if (prefix != null) {
    				label =  prefix + ":" + label;
    			}
    			//rootNode.setString("label", label);
    			//hm.put(label, entity);
    			
    		}*/
    	} catch (Exception e) {
    		throw new OMTOfflineException("Cannot connect to OWL Database!", e);
    	}	
    }

	/**
	 * Returns the singleton instance.
	 @return	the singleton instance
	 */
	static public GlobalSemanticRepository getInstance() throws OMTOfflineException{
		if (instance == null) {
			instance = new GlobalSemanticRepository();
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getClassLabel(edu.stanford.smi.protege.model.Cls, java.lang.String)
	 */
	public String getClassLabel(Cls OWLClass, String URI) {
//		must be done before getLabel() is run!!!

		String label = null;
		
		if (owlModel != null) {
			Slot rdfsLabel = owlModel.getSlot("rdfs:label");
			
			//Cls root = owlModel.getRootCls();
			//Cls entity = owlModel.getCls("bfo:Entity");
			//System.out.println("The root class is: " + entity.getName());
			//Node rootNode = getTree().addRoot();
			rdfsLabel = owlModel.getSlot("rdfs:label");
			label = (String)OWLClass.getDirectOwnSlotValue(rdfsLabel);
			String prefix = null;//owlModel.getPrefixForResourceName(entity.getName());
			if (prefix != null) {
				label =  prefix + ":" + label;
			}
			if (URI != null) {
				label = label + "(" + URI + ")";
			}
		}			
		return label;

	}

	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getMPIDsForMouse()
	 */
	public int[] getMPIDsForMouse() {
		/*
		QueryResults qr = null;
		try {
		String q = "SELECT distinct ?mpid" + 
"\nWHERE" + 
"\n{" +
"\n?subject rdf:type ccdb:MICROSCOPYPRODUCT_OBJTAB ." +
"\n?subject ccdb:mpid ?mpid ." +
"\n?subject ccdb:SECURITY_LEVEL ?level ." +
"\n?subject obo_base:has_part ?someting . "+
"\n?something rdf:type birn_org_tax:birnlex_167 . " +
"\nfilter regex(str(?level),\"1\")" +
"\n}" +
"\norder by ?mpid";
		qr = ((OWLModel)getOWLModel()).executeSPARQLQuery(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (qr != null) {
			if (qr.hasNext()) {
				List vars = qr.getVariables();
				Map varsToVals = qr.next();
                
				for (Object o : vars) {
					RDFObject rdf = (RDFObject)varsToVals.get((String)o);
					if (rdf instanceof RDFSLiteral) {
						RDFSLiteral rdfs = (RDFSLiteral)rdf;
						System.out.println(rdfs.getInt());
					}
				}
            }
		}
		*/
		//can't get above code to work, so for now hard coding the values
		int[] hackOutput = {1, 14, 16, 17, 29, 3, 30, 31, 32, 33, 3339, 3379, 
				  3380, 3382, 3383, 3384, 35, 3561, 3563, 3587, 3592, 
				  3593, 36, 3652, 3659, 3687, 3693, 39, 3993, 3996, 
				  4, 40, 4003, 	4043, 4044, 4045, 4046, 4047, 4048,
				  4049, 4050, 4051, 4052, 4053, 4054, 4055, 4056, 
				  4057, 4058, 4059, 4060, 4061, 4062, 4063, 4064, 
				  4065, 4066, 4067, 4068, 4069, 4070, 4071, 4072,
				  4073, 4074, 4075, 41, 48, 49, 50, 51, 53, 54, 
				  6, 7};
		return hackOutput;
	}

	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getMicroscopyProductInstances()
	 */
	public List<SemanticInstance> getMicroscopyProductInstances() {
		return getInstancesFromRoot(getSemanticClass("ccdb:MICROSCOPYPRODUCT_OBJTAB"), false);
	}
	
	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#createNewInstanceOfClass(java.lang.String)
	 */
	public SemanticInstance createNewInstanceOfClass(String uri) {
		// TODO Auto-generated method stub
		return null;
	}



	/* (non-Javadoc)
	 * @see edu.ucsd.ccdb.ontomorph2.core.data.SemanticRepository#getSemanticInstance(java.lang.String)
	 */
	public SemanticInstance getSemanticInstance(String uri) {
		// TODO Auto-generated method stub
		return null;
	}
}
