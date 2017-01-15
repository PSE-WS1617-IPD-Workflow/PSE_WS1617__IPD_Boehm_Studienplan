// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.moduledata;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.kit.informatik.studyplan.server.model.moduledata.constraint.ModuleConstraint;

/************************************************************/
/**
 * Modelliert ein Modul
 */
@Entity
@Table (name = "module")
public class Module {
	/**
	 * 
	 */
	@Transient
	private List<ModuleConstraint> moduleConstraints;
	/**
	 * 
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "module_category_assignment",
	joinColumns = 
		@JoinColumn(name = "module_id"),
	inverseJoinColumns =
		@JoinColumn(name = "category_id"))
	private List<Category> categories;
	/**
	 * 
	 */
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "description_id")
	private ModuleDescription moduleDescription;
	/**
	 * 
	 */
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "discipline_id")
	private Discipline discipline;
	/**
	 * 
	 */
	@Id
	@Column(name = "module_id")
	private int moduleId;
	/**
	 * 
	 */
	@Column(name = "identifier")
	private String identifier;
	/**
	 * 
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 
	 */
	@Column (name = "credit_points")
	private double creditPoints;
	/**
	 * 
	 */
	@Column (name = "cycle_type")
	@Enumerated(EnumType.STRING)
	private CycleType cycleType;
	/**
	 * 
	 */
	@Column (name = "is_compulsory")
	private boolean compulsory;

	/**
	 * 
	 * @return gibt die eindeutige Modul-ID zurück
	 */
	public int getModuleId() {
		return moduleId;
	}

	/**
	 * 
	 * @return gibt den eindeutigen Identifier-String zurück
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * 
	 * @return gibt die Modulbezeichnung zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return gibt die ECTS-Zahl des Moduls zurück
	 */
	public double getCreditPoints() {
		return creditPoints;
	}

	/**
	 * 
	 * @return gibt den Turnus des Moduls zurück
	 */
	public CycleType getCycleType() {
		return cycleType;
	}

	/**
	 * 
	 * @return gibt zurück, ob es sich um ein Pflichtmodul handelt
	 */
	public boolean isCompulsory() {
		return compulsory;
	}

	/**
	 * 
	 * @return gibt den Studiengang, dem das Modul angehört, zurück <br>
	 *         Ein Modul ist immer eindeutig einem Studiengang zugeordnet. Wird
	 *         ein Modul in der Realität für mehrere Studiengänge angeboten, so
	 *         handelt es sich jeweils um unterschiedliche Module, denn in einem
	 *         anderen Studiengang können Modulabhängigkeiten ggf. varieren.
	 */
	public Discipline getDiscipline() {
		return discipline;
	}

	/**
	 * 
	 * @return gibt die Modul-Beschreibung des Moduls zurück
	 */
	public ModuleDescription getModuleDescription() {
		return moduleDescription;
	}

	/**
	 * 
	 * @return gibt die Abhängigkeiten des Moduls zu anderen Modulen zurück
	 */
	public List<ModuleConstraint> getConstraints() {
		return moduleConstraints;
	}

	/**
	 * 
	 * @return gibt die Kategorien, denen das Modul angehört, zurück
	 */
	public List<Category> getCategories() {
		return categories;
	}
};
