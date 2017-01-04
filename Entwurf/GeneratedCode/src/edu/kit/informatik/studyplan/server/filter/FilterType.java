// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.filter;

import edu.kit.informatik.studyplan.server.filter.AttributeFilter;
import edu.kit.informatik.studyplan.server.rest.JSONObject;

/**
 * Aufzählung der verschiedenen AttributeFilter-Typen.
 */
public enum FilterType {
	/**
	 * Repräsentiert den Filtertyp {@link RangeFilter}.
	 */
	RANGE {
		@Override
		public JSONObject toJsonSpecification(AttributeFilter defaultFilter) {
			return null;
		}

		@Override
		public JSONObject defaultJsonValue(AttributeFilter defaultFilter) {
			return null;
		}
	},
	/**
	 * Repräsentiert den Filtertyp {@link ListFilter}.
	 */
	LIST {
		@Override
		public JSONObject toJsonSpecification(AttributeFilter defaultFilter) {
			return null;
		}

		@Override
		public JSONObject defaultJsonValue(AttributeFilter defaultFilter) {
			return null;
		}
	},
	/**
	 * Repräsentiert den Filtertyp {@link ContainsFilter}.
	 */
	CONTAINS {
		@Override
		public JSONObject toJsonSpecification(AttributeFilter defaultFilter) {
			return null;
		}

		@Override
		public JSONObject defaultJsonValue(AttributeFilter defaultFilter) {
			return null;
		}
	};

	/**
	 * Liefert den Spezifikation-Abschnitt der JSON-Repräsentation des übergebenen Default-Filters.
	 * @param defaultFilter der Default-Filter
	 * @return  die Spezifikation des Filters als JSON-Objekt
	 */
	public abstract JSONObject toJsonSpecification(AttributeFilter defaultFilter);

	/**
	 * Liefert eine JSON-Repräsentation der Werte des übergebenen Default-Filters.
	 * @param defaultFilter das Filter-Objekt mit Default-Werten
	 * @return  die Werte des Default-Filters
	 */
	public abstract JSONObject defaultJsonValue(AttributeFilter defaultFilter);
};