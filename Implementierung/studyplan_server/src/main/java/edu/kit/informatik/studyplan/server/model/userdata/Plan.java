// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;
import edu.kit.informatik.studyplan.server.model.moduledata.dao.ModuleDaoFactory;
import edu.kit.informatik.studyplan.server.rest.resources.json.JsonModule;

/************************************************************/
/**
 * Modelliert einen Studienplan
 */
@Entity
@Table(name = "plan")
public class Plan {

	/**
	 * 
	 */
	@Id
	@GenericGenerator(name = "uuid-gen", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid-gen")
	@Column(name = "identifier")
	@JsonProperty("id")
	private String identifier;
	/**
	 * 
	 */

	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	/**
	 * 
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	@JsonProperty("status")
	private VerificationState state;
	/**
	 * 
	 */
	@Transient
	@JsonProperty("creditpoints-sum")
	private double creditPoints = -1;
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	/**
	 *
	 */
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "plan_entries", 
		joinColumns = @JoinColumn(name = "plan_identifier"), 
		inverseJoinColumns = @JoinColumn(name = "entry_id"))
	@JsonIgnore
	private List<ModuleEntry> moduleEntries = new LinkedList<ModuleEntry>();

	/**
	 *
	 */
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<ModulePreference> modulePreferences;
	
	
	/**
	 * Gibt für ein übergebenes Modul die Präferenz zurück. <br>
	 * <code>null</code>, falls keine Präferenz vorhanden
	 *
	 * @return die Präferenz
	 * @param module
	 *            das Modul
	 */
	@JsonIgnore
	public PreferenceType getPreferenceForModule(Module module) {
		return modulePreferences.stream()
		.filter(preference -> preference.getModule().equals(module))
		.map(preference -> preference.getPreference()).findFirst().orElse(null);
	}



	/**
	 *
	 * @return gibt den eindeutigen Plan-Identifier zurück
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 *
	 * @param identifier
	 *            der Plan-Identifier
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 *
	 * @return gibt den Namen des Plans zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 *            der Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return gibt den Verifizierungsstatus des Plans zurück
	 */
	public VerificationState getVerificationState() {
		return state;
	}

	/**
	 *
	 * @param verificationState
	 *            der Verifizierungsstatus
	 */
	public void setVerificationState(VerificationState verificationState) {
		this.state = verificationState;
	}

	/**
	 *
	 * @return gibt die ECTS-Summe des Plans zurück
	 */
	public double getCreditPoints() {
		if (creditPoints == -1) {
			creditPoints =  moduleEntries.stream()
					.mapToDouble(entry -> entry.getModule().getCreditPoints())
					.sum();
		}
		return creditPoints;
	}

	/**
	 *
	 * @return gibt den Eigentümer des Plans zurück
	 */
	public User getUser() {
		return user;
	}

	/**
	 *
	 * @param user
	 *            der Eigentümer
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 *
	 * @return gibt alle Moduleinträge des Plans zurück
	 */
	public List<ModuleEntry> getModuleEntries() {
		return moduleEntries;
	}

	public void setModuleEntries(List<ModuleEntry> moduleEntries) {
		this.moduleEntries = moduleEntries;
	}

	public void setModulePreferences(List<ModulePreference> modulePreferences) {
		this.modulePreferences = modulePreferences;
	}

	/**
	 * 
	 * @return gibt eine List der Modulpräferenzen zurück
	 */
	public List<ModulePreference> getPreferences() {
		return modulePreferences;
	}


	/**
	 * Only being called by Jackson and/or REST handlers, respectively.
	 * @return Publishes the module entries inside the plan's JSON representation.
     */
	@JsonProperty("modules")
	public List<JsonModule> getJsonModules() {
		return getModuleEntries().stream()
				.map(entry -> {
					JsonModule jsonModule = new JsonModule();
					jsonModule.setId(entry.getModule().getIdentifier());
					jsonModule.setName(entry.getModule().getName());
					jsonModule.setSemester(entry.getSemester());
					jsonModule.setCreditPoints(entry.getModule().getCreditPoints());
					jsonModule.setLecturer(entry.getModule().getModuleDescription().getLecturer());
					jsonModule.setCycleType(entry.getModule().getCycleType());
					jsonModule.setPreference(getPreferenceForModule(entry.getModule()));
					return jsonModule;
				})
				.collect(Collectors.toList());
	}

	/**
	 * Only being called by Jackson and/or REST handlers, respectively.
	 * @param jsonModules The modules attribute's content from the plan's JSON representation.
     */
	@JsonProperty("modules")
	public void setJsonModules(List<JsonModule> jsonModules) {
		HashSet<String> placedModulesIds = new HashSet<>(jsonModules.size()); //for finding duplicates
		List<ModuleEntry> moduleEntries = new ArrayList<>(jsonModules.size());
		List<ModulePreference> preferences = new LinkedList<>();
		for (JsonModule jsonModule : jsonModules) {
			if (placedModulesIds.contains(jsonModule.getId())) {
				throw new BadRequestException();
			} else {
				placedModulesIds.add(jsonModule.getId());
			}
			if (jsonModule.getSemester() < user.getStudyStart().getDistanceToCurrentSemester()) {
				throw new BadRequestException();  //TODO rather UnprocessableEntity?
			}
			Module module = ModuleDaoFactory.getModuleDao().getModuleById(jsonModule.getId());
			if (module == null) {
				throw new NotFoundException();
			}
			ModuleEntry entry = new ModuleEntry(module, jsonModule.getSemester());
			moduleEntries.add(entry);
			if (jsonModule.getPreference() != null) {
				ModulePreference preference = new ModulePreference(module, jsonModule.getPreference());
				preferences.add(preference);
			}
		}
		this.moduleEntries = moduleEntries;
		this.modulePreferences = preferences;
	}



	public boolean contains(Module module) {
		return getAllModuleEntries().stream().anyMatch(entry -> entry.getModule().equals(module));
	}
	
	@Transient
	public ModuleEntry getEntryFor(Module module) {
		return getAllModuleEntries().stream()
				.filter(entry -> entry.getModule().equals(module))
				.findFirst()
				.orElse(null);
	}
	
	@Transient
	public List<ModuleEntry> getAllModuleEntries() {
		LinkedList<ModuleEntry> allEntries = new LinkedList<ModuleEntry>(moduleEntries);
		allEntries.addAll(user.getPassedModules());
		return allEntries;
	}
};
