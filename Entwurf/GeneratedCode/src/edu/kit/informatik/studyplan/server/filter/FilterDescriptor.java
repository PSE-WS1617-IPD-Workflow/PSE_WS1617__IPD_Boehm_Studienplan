// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.filter;

import edu.kit.informatik.studyplan.server.filter.AttributeFilter;
import edu.kit.informatik.studyplan.server.rest.JSONObject;

/**
 * Beschreibungen der nach außen sichtbaren Filter für den Client.
 */
public enum FilterDescriptor {
	/**
	 * Beschreibt den ECTS-Intervall-Filter.
	 */
	CREDIT_POINTS,
	/**
	 * Beschreibt den Kategorie-Wahlfilter.
	 */
	CATEGORY,
	/**
	 * Beschreibt den Turnus-Wahlfilter.
	 */
	CYCLE_TYPE,
	/**
	 * Beschreibt den Modultyp-Wahlfilter.
	 */
	TYPE,
	/**
	 * Beschreibt den Fachrichtungs-Wahlfilter.
	 */
	DISCIPLINE,
	/**
	 * Beschreibt den Pflicht-/Wahlveranstaltungs-Wahlfilter.
	 */
	COMPULSORY,
	/**
	 * Beschreibt den Modulnamen-Textfilter.
	 */
	NAME;

	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String attributeName;
	/**
	 * 
	 */
	private String filterName;
	/**
	 * 
	 */
	private String defaultJsonValue;
	/**
	 * 
	 */
	private String tooltip;
	/**
	 * 
	 */
	private AttributeFilter defaultFilter;

	/**
	 * Gibt ein jOOQ-Field-Objekt zurück, das des Filters attributeName kapselt.
	 * @return  das jOOQ-Field-Objekt
	 */
	public Field<Object> toField() {
		return null;
	}

	/**
	 * Liefert eine JSON-Repräsentation des beschriebenen Filters für den Client.
	 * @return eine JSON-Repräsentation des beschriebenen Filters
	 */
	public JSONObject toJson() { return null; };

	/**
	 * Liefert die ID des Filters.
	 * @return  die ID des Filters
	 */
	public int id() {
		return id;
	}

	/**
	 * Liefert ein Default-Objekt des beschriebenen Filtertyps.
	 * @return  das Default-Objekt
	 */
	public AttributeFilter defaultFilter() {
		return defaultFilter;
	}

	/**
	 * Liefert den Namen des Module-Attributs, das durch beschriebenen Filter gefiltert werden soll.
	 * @return  der Attribut-Name
	 */
	public String attributeName() {
		return attributeName;
	}

	/**
	 * Liefert den Namen des Filters (für die Benutzeroberfläche).
	 * @return  den Filternamen
	 */
	public String filterName() {
		return filterName;
	}

	/**
	 * Liefert den zum Filter gehörenden Tooltip (für die Benutzeroberfläche).
	 * @return  das Tooltip zum Filter
	 */
	public String tooltip() {
		return tooltip;
	}
};
