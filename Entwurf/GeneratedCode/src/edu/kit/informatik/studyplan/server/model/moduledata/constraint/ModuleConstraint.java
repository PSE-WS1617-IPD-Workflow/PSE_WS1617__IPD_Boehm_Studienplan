// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.moduledata.constraint;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;
import edu.kit.informatik.studyplan.server.model.moduledata.constraint.ModuleConstraintType;

/************************************************************/
/**
 * Diese Klasse modelliert eine Abhängigkeit zwischen zwei Modulen.
 */
public class ModuleConstraint {
	/**
	 * 
	 */
	private ModuleConstraintType constraintType;

	/**
	 * 
	 * @return gibt das erste Modul der Abhängigkeitsrelation zurück
	 */
	public Module getFirstModule() {
		return null;
	}

	/**
	 * 
	 * @return gibt das zweite Modul der Abhängigkeitsrelation zurück
	 */
	public Module getSecondModule() {
		return null;
	}

	/**
	 * 
	 * @return gibt den Typ der Abhängigkeit zurück
	 * @see ModuleConstraintType
	 */
	public ModuleConstraintType getConstraintType() {
		return constraintType;
	}
};
