// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.client.view.components.uipanel;

import java.util.Collection;

import edu.kit.informatik.studyplan.client.model.system.NotificationCollection;
import edu.kit.informatik.studyplan.client.view.components.uielement.NotificationBox;

/************************************************************/
/**
 * Klasse, welche die Anzeige von Benachrichtigungen kapselt
 */
public class NotificationCentre {
    /**
     * Wird mittels NotificationCollection.getInstance() geladen.
     * NotificationCentre ist ein Observer der NotificationCollection und zeigt
     * neue Notifications ggf. an.
     */
    private NotificationCollection notificationCollection;
    /**
     * Die NotificationBoxes, welche die Benachrichtigungen anzeigen
     */
    private Collection<NotificationBox> notificationBox;

    /**
     * Methode, welche aufgerufen wird, wenn sich die notificationCollection
     * verändert.
     */
    public void onChange() {
    }
};