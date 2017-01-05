// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.generation.standard;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;

/************************************************************/
/**
 * Die abstrakte Klasse Node stellt Knoten des Graphen da.
 */
public abstract class Node {
	/**
	 * Ein Knoten beinhaltet ein Module module, welches er darstellt.
	 */
	private Module module;
	
	/**
	 * Ein Knoten beinhaltet eine Liste parents vom Typ Node, die 
	 * alle Knoten enthält, die Kanten zu diesem Knoten haben.
	 */
	private Node[] parents;

	/**
	 * Die Methode getPartens gibt die Liste parents zurück.
	 * @return parent-moduls 
	 */
	public Node[] getParents() {
		return null;
	}


	/**
	 * @return
	 */
	public Module getModule() {
	  return null;
	}

	/**
	 * 
	 * @return parent-moduls 
	 */
	public Node getChildren() {
		return null;
	}
};
