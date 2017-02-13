// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.generation.objectivefunction;

import edu.kit.informatik.studyplan.server.model.userdata.Plan;

/************************************************************/
/**
 * Es wird bei der Auswertung der Teilzielfunktionen immer der durchschnitt
 * genomen.
 */
public class AverageObjectiveFunction extends ObjectiveFunction {

	/*
	 * Nimmt die durchschnittliche Bewertungen der Teilzielfunktionen.
	 */
	@Override
	public double evaluate(final Plan plan) {
		return this.getSubFunctions().stream()
				.mapToDouble(function -> function.evaluate(plan))
				.average().orElse(0);
	}
};
