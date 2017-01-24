// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.moduledata.constraint;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import edu.kit.informatik.studyplan.server.model.moduledata.ModuleOrientation;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;

/************************************************************/
/**
 * Modelliert eine Voraussetzungsabhängigkeit zwischen Modulen:<br>
 * Das erste Modul ist Voraussetzung für das zweite Modul.
 */
@Entity
@DiscriminatorValue(value = "prerequisite")
public class PrerequisiteModuleConstraintType extends ModuleConstraintType {

	@Override
	public boolean isValid(ModuleEntry first, ModuleEntry second, ModuleOrientation orientation) {
		switch (orientation) {
		case LEFT_TO_RIGHT:
			return first.getSemester() < second.getSemester();
		case RIGHT_TO_LEFT:
			return second.getSemester() < first.getSemester();
		default:
			return first.getSemester() < second.getSemester();
		}
	}
};
