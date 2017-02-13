package edu.kit.informatik.studyplan.server.model.userdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;
import edu.kit.informatik.studyplan.server.model.moduledata.dao.ModuleDaoFactory;

/************************************************************/
/**
 * Class modeling a module entry, which assigns a preference to a module.
 * 
 * @see PreferenceType
 */
@Entity
@Table(name = "module_preference")
public class ModulePreference {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "preference_id")
	private int preferenceId;

	@Column(name = "module_id")
	private String moduleId;
	/**
	 * 
	 */
	@Transient
	private Module module;
	/**
	 * 
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "preference_type")
	private PreferenceType type;

	@ManyToOne
	@JoinColumn(name = "plan_identifier")
	private Plan plan;

	/**
	 * creates a new empty module preference
	 */
	public ModulePreference() {
	}

	/**
	 * Creates a new ModulePreference with given module and preference type
	 * 
	 * @param module
	 *            the module whose preference shall be set
	 * @param preference
	 *            the preference to assign
	 */
	public ModulePreference(Module module, PreferenceType preference, Plan plan) {
		this.plan = plan;
		setModule(module);
		this.type = preference;
	}

	/**
	 * 
	 * @return returns the module
	 */
	public Module getModule() {
		if (module == null) {
			module = ModuleDaoFactory.getModuleDao().getModuleById(moduleId);
		}
		return module;
	}

	/**
	 * 
	 * @param module
	 *            the module
	 */
	public void setModule(Module module) {
		this.moduleId = module.getIdentifier();
		this.module = module;
	}

	/**
	 * 
	 * @return returns the type of the preference
	 * @see PreferenceType
	 */
	public PreferenceType getPreference() {
		return type;
	}

	/**
	 * 
	 * @param preferenceType
	 *            the preference type to set
	 */
	public void setPreference(PreferenceType preferenceType) {
	}

	/**
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * @param plan the plan to set
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
};
