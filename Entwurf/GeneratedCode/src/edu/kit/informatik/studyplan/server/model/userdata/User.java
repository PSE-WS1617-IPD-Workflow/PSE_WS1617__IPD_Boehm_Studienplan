// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata;

import edu.kit.informatik.studyplan.server.model.moduledata.Discipline;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;
import edu.kit.informatik.studyplan.server.model.userdata.Plan;
import edu.kit.informatik.studyplan.server.model.userdata.Semester;

/************************************************************/
/**
 * 
 */
public class User {
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private Discipline discipline;
	/**
	 * 
	 */
	private Semester studyStart;
	/**
	 * 
	 */
	private ModuleEntry[] passedModules;

	/**
	 * 
	 * @return  
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId 
	 */
	public void setUserId(String userId) {
	}

	/**
	 * 
	 * @return  
	 */
	public String getUserName() {
		return userId;
	}

	/**
	 * 
	 * @param userName 
	 */
	public void setUserName(String userName) {
	}

	/**
	 * 
	 * @return  
	 */
	public Discipline getDiscipline() {
		return discipline;
	}

	/**
	 * 
	 * @param discipline 
	 */
	public void setDiscipline(Discipline discipline) {
	}

	/**
	 * 
	 * @return  
	 */
	public Semester getStudyStart() {
		return studyStart;
	}

	/**
	 * 
	 * @param semester 
	 */
	public void setStudyStart(Semester semester) {
	}

	/**
	 * 
	 * @return  
	 */
	public ModuleEntry getPassedModules() {
		return null;
	}

	/**
	 * 
	 * @return  
	 */
	public Plan getPlans() {
		return null;
	}
};