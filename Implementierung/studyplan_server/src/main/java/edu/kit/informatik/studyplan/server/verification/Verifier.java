// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.verification;

import edu.kit.informatik.studyplan.server.model.userdata.Plan;
import edu.kit.informatik.studyplan.server.verification.VerificationResult;

/************************************************************/
/**
 * Das Interface Verifier bietet die allgemeine Sturktur eines Verifizierers.
 */
public interface Verifier {

	/**
	 * Die Methode verify verifiziert einen übergebenen Studienplan. Das heißt
	 * sie überprüft an Hand der gegebenen System-Constraints, ob der Plan zu
	 * einem erfolreichen Studienabschluss führen kann.
	 * 
	 * @return invalid Ein VerificationResult wird als Ergebnis der
	 *         Verifizierung zurückgegeben.
	 * @param plan
	 *            Ein zu verifizierender Studienplan wird übergeben.
	 */
	public VerificationResult verify(Plan plan);
};