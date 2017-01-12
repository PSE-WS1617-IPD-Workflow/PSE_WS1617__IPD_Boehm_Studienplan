// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;

/************************************************************/
/**
 * Modelliert einen Moduleintrag in einem Studienplan
 */
public class ModuleEntry {
	/**
	 * 
	 */
	private Module module;
	/**
	 * 
	 */
	private int semester;

	/**
	 * 
	 * @return gibt das Modul zurück
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * 
	 * @param module
	 *            das Modul
	 */
	public void setModule(Module module) {
	}

	/**
	 * 
	 * @return gibt die Nummer des Semesters zurück, dem der Eintrag zugeordnet
	 *         wurde
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * 
	 * @param semester
	 *            die Semesternummer
	 */
	public void setSemester(int semester) {
	}
};
