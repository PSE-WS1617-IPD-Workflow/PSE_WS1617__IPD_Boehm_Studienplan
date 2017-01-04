// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.moduledata.constraint;

import edu.kit.informatik.studyplan.server.model.moduledata.ModuleOrientation;
import edu.kit.informatik.studyplan.server.model.moduledata.constraint.ModuleConstraintType;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;

/************************************************************/
/**
 * Modelliert eine Voraussetzungsabhängigkeit zwischen Modulen:<br>
 * Das erste Modul ist Voraussetzung für das zweite Modul.
 */
public class PrerequisiteModuleConstraintType extends ModuleConstraintType {

	public boolean isValid(ModuleEntry first, ModuleEntry second, ModuleOrientation orientation) {
		return false;
	}
};
