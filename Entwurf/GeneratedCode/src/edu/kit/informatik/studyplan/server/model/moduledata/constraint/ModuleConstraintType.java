// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.moduledata.constraint;

import edu.kit.informatik.studyplan.server.model.moduledata.ModuleOrientation;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;

/************************************************************/
/**
 * 
 */
public abstract class ModuleConstraintType {
	/**
	 *
	 */
	private int id;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String formalDescription;

	/**
	 * 
	 * @param first 
	 * @param second 
	 * @param orientation 
	 */
	public abstract void isValid(ModuleEntry first, ModuleEntry second, ModuleOrientation orientation);

	/**
	 * 
	 * @return  
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return  
	 */
	public String getFormalDescription() {
		return description;
	}
};
