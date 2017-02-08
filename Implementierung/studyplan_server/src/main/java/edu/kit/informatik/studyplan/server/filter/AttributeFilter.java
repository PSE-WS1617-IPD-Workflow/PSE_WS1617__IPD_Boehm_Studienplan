// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.filter;

/**
 * Repräsentiert einen Filter für ein bestimmtes Module-Attribut.
 */
public abstract class AttributeFilter implements Filter {

	/**
	 * Liefert den Namen des Module-Attributs, das durch beschriebenen Filter
	 * gefiltert werden soll.
	 *
	 * @return der Attribut-Name
	 */
	public abstract String getAttributeName();


	/**
	 * Liefert den Filter-Typ des AttributeFilters.
	 * 
	 * @return der Filter-Typ
	 */
	public abstract FilterType getFilterType();
};
