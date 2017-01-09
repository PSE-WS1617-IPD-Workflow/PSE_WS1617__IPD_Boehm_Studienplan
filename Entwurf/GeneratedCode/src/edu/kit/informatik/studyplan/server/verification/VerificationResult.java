// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.verification;

import edu.kit.informatik.studyplan.server.model.moduledata.constraint.ModuleConstraint;

import java.util.Collection;

/************************************************************/
/**
 * Die Klasse VerificationResult ist das Ergebins einer Verifizierung. 
 */
public class VerificationResult {
	/**
	 * VerificationResult enthält ein Array violations vom Typ ModuleConstraint. 
	 * In diesem werden verletzte Modulconstraints gespeichert.
	 */
	private Collection<ModuleConstraint> violations;


	/**
	 * Gibt die verletzten Modul-Constraints zurück.
	 * @return die verletzten Modul-Constraints
	 */
	public Collection<ModuleConstraint> getViolations() {
		return violations;
	}

	/**
	 * is correct prüft anhand von violations, ob der Studienplan erfolgreich verifiziert wurde.
	 * @return  zurückgegeben wird false, falls der Studienplan fehlerhaft ist und true,
	 * wenn er zu einem erfolreichen Studienabschluss führt.
	 */
	public boolean isCorrect() {
		return false;
	}
};
