// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.client.model.system;

import edu.kit.informatik.studyplan.client.model.system.OAuthModel;

/************************************************************/
/**
 * Klasse welcher die Daten zu einem Filter speichert
 */
public class Filter extends OAuthModel {
    /**
     * Name des Filters
     */
    private String name;
    /**
     * Typ des Filters ("range", "list", "contains")
     */
    private String type;
    /**
     * Die den Filter spezifizierenden Eigenschaften
     */
    private Object parameters;
    // TODO: In UML �bertragen
    /**
     * Die ID des Filters
     */
    private String id;
    /**
     * Der Standardwert des Filters (Struktur abh�ngig vom Filter)
     */
    private Object defaultValue;
    /**
     * Ein Tooltip, der den Filter textuell beschreibt
     */
    private String tooltip;
    /**
     * Der aktuelle Wert des Filters
     */
    private Object curValue;

};
