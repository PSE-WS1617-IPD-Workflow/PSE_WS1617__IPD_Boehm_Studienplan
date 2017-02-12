// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.filter;

/**
 * Represents a filter for a specific Module attribute.
 */
public abstract class AttributeFilter implements Filter {

	/**
	 *
	 * @return the name of the Module attribute which is to be filtered by this instance.
	 */
	public abstract String getAttributeName();


	/**
	 * 
	 * @return the filter type of the AttributeFilter
	 */
	public abstract FilterType getFilterType();
};
