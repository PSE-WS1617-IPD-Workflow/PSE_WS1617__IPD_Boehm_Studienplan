// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.client.view.components.uipanel;

import edu.kit.informatik.studyplan.client.model.plans.Plan;
import edu.kit.informatik.studyplan.client.model.system.ProposalInformation;
import edu.kit.informatik.studyplan.client.view.components.uipanel.WizardComponent;

/************************************************************/
/**
 * 
 */
public class GenerationWizardComponent3 extends WizardComponent {
    /**
     * Plan für welchen generiert werden soll
     */
    private Plan plan;
    /**
     * Die notwendigen Informationen für die Generierung
     */
    private ProposalInformation information;

    /**
     * Gibt null zurück, da dies die letzte Seite des Wizards ist.
     * 
     * @return null
     */
    public WizardComponent next() {
        return null;
    }

    /**
     * Methode, welche bei Veränderungen des Seiteninhalts aufgerufen wird.
     */
    public void onChange() {
    }
};