// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.client.view.components;

/************************************************************/
/**
 * 
 */
public abstract class FilterComponent {
	/**
	 * 
	 */
	private String id;

	/**
	 * 
	 * @return  
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return  
	 */
	public abstract String getParams();

	/**
	 * 
	 */
	public abstract void onSelect();
};