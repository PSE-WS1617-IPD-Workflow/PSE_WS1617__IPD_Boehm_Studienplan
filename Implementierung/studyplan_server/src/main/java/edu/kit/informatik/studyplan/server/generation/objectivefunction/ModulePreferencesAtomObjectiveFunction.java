package edu.kit.informatik.studyplan.server.generation.objectivefunction;

import edu.kit.informatik.studyplan.server.model.moduledata.Module;
import edu.kit.informatik.studyplan.server.model.userdata.ModulePreference;
import edu.kit.informatik.studyplan.server.model.userdata.Plan;

/**
 * Evaluates the plan based on the preferences of the user. The more user preferences
 * (either positive or negative) were considered in generating the plan, the higher it 
 * would be evaluated. The ideal case would be that the plan contains all modules with 
 * positive preference and does not contain any of the negative evaluated modules.
 * 
 */
public class ModulePreferencesAtomObjectiveFunction extends AtomObjectiveFunction {

	
	public ModulePreferencesAtomObjectiveFunction() {
		setDescriptor("Präferenzen berücksichten");
	}
	
	/*
	 * {@inheritDoc}
	 */
	@Override
	public double evaluate(final Plan plan) {
		int numberOfPreferences = plan.getPreferences().size();
		if (numberOfPreferences < 1) {
			return 1;
		}
		int fulfilledPreferences = 0;
		for (ModulePreference preference : plan.getPreferences()) {
			Module module = preference.getModule();
			if (plan.getPreferenceForModule(module) != null) {
				fulfilledPreferences++;
			}
		}
		return ((double) fulfilledPreferences)/((double) numberOfPreferences);
	}
};
