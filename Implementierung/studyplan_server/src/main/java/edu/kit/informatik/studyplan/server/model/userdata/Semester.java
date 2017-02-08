// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/************************************************************/
/**
 * Modelliert ein Semester
 */
@Embeddable
public class Semester implements Comparable<Semester>{

	/**
	 * 
	 */
	@Column(name = "semester_type")
	@Enumerated(EnumType.STRING)
	@JsonProperty("semester-type")
	@NotNull
	private SemesterType semesterType;
	/**
	 * 
	 */
	@Column(name = "year")
	@JsonProperty("year")
	private int year = -1;
	
	public Semester() {
		
	}
	
	/**
	 * Creates a new semester
	 * @param semesterType the semester Type
	 * @param year the start year of the semester
	 * @throws IllegalArgumentException if semesterType is set to <code>null</code> or year is set to non positive value
	 */
	public Semester(SemesterType semesterType, int year) throws IllegalArgumentException{
		if (semesterType == null) {
			throw new IllegalArgumentException("SemesterType must not be null");
		}
		if (year < 0) {
			throw new IllegalArgumentException("Year must be positive");
		}
		this.semesterType = semesterType;
		this.year = year;
	}

	/**
	 * Berechnet die Anzahl an Semester, die seit diesem Semester vergangen sind
	 * (inkl. aktuelles)
	 * 
	 * @return die Semesterzahl
	 */
	@JsonIgnore
	public int getDistanceToCurrentSemester() {
		return getDistanceTo(getCurrentSemester());
	}

	/**
	 *
	 * @return returns the current running semester
	 */
	private Semester getCurrentSemester() {
		Semester currentSemester;
		LocalDate today = LocalDate.now();
		LocalDate summerTermStart = SemesterType.SUMMER_TERM.getSemesterStartDate().withYear(today.getYear());
		LocalDate winterTermStart = SemesterType.WINTER_TERM.getSemesterStartDate().withYear(today.getYear());
		if (today.isBefore(summerTermStart)) {
			currentSemester = new Semester(SemesterType.WINTER_TERM, today.getYear() - 1);
		} else {
			if (today.isBefore(winterTermStart)) {
				currentSemester = new Semester(SemesterType.SUMMER_TERM, today.getYear());
			} else {
				currentSemester = new Semester(SemesterType.WINTER_TERM, today.getYear());

			}
		}
		return currentSemester;
	}

	/**
	 * 
	 * @param semester the semester
	 * @return calculates the distance to the given semester including this one<br>
	 * 			always returns a value greater zero
	 */
	@JsonIgnore
	public int getDistanceTo(Semester semester) {
		LocalDate thisStart = this.semesterType.getSemesterStartDate().withYear(year);
		LocalDate otherStart = semester.semesterType.getSemesterStartDate().withYear(semester.year);
		Period studyPeriod = thisStart.until(otherStart);
		int distance = studyPeriod.getYears() * 2 + 1;
		if (studyPeriod.getMonths() != 0) {
			distance++;
		}
		return distance;
	}

	/**
	 * 
	 * @return gibt den Typ des Semester zurück
	 * @see edu.kit.informatik.studyplan.server.model.userdata.SemesterType
	 */
	public SemesterType getSemesterType() {
		return semesterType;
	}

	/**
	 * 
	 * @param semesterType
	 *            der Semestertyp
	 */
	public void setSemesterType(SemesterType semesterType) {
		this.semesterType = semesterType;
	}

	/**
	 * 
	 * @return gibt das Jahr zurück in dem das Semester begonnen hat
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 *            das Jahr in dem das Semester begonnen hat
	 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	@JsonIgnore
	public int compareTo(Semester o) {
		if (year < o.getYear()) {
			return -1;
		} else {
			if (year == o.getYear()) {
				return semesterType.getSemesterStartDate().compareTo(o.semesterType.getSemesterStartDate());
			} else {
				return 1;
			}
		}
	}

};
