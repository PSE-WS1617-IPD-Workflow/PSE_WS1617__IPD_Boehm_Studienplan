// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;
import edu.kit.informatik.studyplan.server.model.userdata.ModulePreference;
import edu.kit.informatik.studyplan.server.model.userdata.PreferenceType;
import edu.kit.informatik.studyplan.server.model.userdata.User;
import edu.kit.informatik.studyplan.server.model.userdata.VerificationState;

/************************************************************/
/**
 * 
 */
public class Plan {
	/**
	 * 
	 */
	private String planId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private VerificationState state;
	/**
	 * 
	 */
	private int creditPoints;
	/**
	 * 
	 */
	private User user;
	/**
	 * 
	 */
	private ModuleEntry[] moduleentry;
	/**
	 * 
	 */
	private ModulePreference[] modulePreferences;

	/**
	 * 
	 * @return  
	 * @param module 
	 */
	public PreferenceType getPreferenceForModule(Module module) {
		return null;
	}

	/**
	 * 
	 * @return  
	 */
	public String getPlanId() {
		return name;
	}

	/**
	 * 
	 * @param planId 
	 */
	public void setPlanId(String planId) {
	}

	/**
	 * 
	 * @return  
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name 
	 */
	public void setName(String name) {
	}

	/**
	 * 
	 * @return  
	 */
	public VerificationState getVerificationState() {
		return state;
	}

	/**
	 * 
	 * @param verificationState 
	 */
	public void setVerificationState(VerificationState verificationState) {
	}

	/**
	 * 
	 * @return  
	 */
	public int getCreditPoints() {
		return creditPoints;
	}

	/**
	 * 
	 * @param creditPoints 
	 */
	public void setCreditPoints(int creditPoints) {
	}

	/**
	 * 
	 * @return  
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user 
	 */
	public void setUser(User user) {
	}

	/**
	 * 
	 * @return  
	 */
	public ModuleEntry getModuleEntries() {
		return null;
	}

	/**
	 * 
	 * @return  
	 */
	public ModulePreference getPreferences() {
		return null;
	}
};