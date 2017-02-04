package edu.kit.informatik.studyplan.server.model.moduledata;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Class representing a rule group, which defines a group of modules
 * where a number of modules in a specified range is necessary for completing a discipline
 * @author NiklasUhl
 *
 */
@Entity
@Table(name = "rule_group")
public class RuleGroup {
	
	@Id
	@Column(name = "rule_id")
	private int ruleId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "min_num")
	private int minNum;
	
	@Column(name = "max_num")
	private int maxNum;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rule_module_assignment",
	joinColumns = 
		@JoinColumn(name = "module_id"),
	inverseJoinColumns =
		@JoinColumn(name = "rule_id"))
	private List<Module> modules;

	/**
	 * @return the ruleId
	 */
	public int getRuleId() {
		return ruleId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the minNum
	 */
	public int getMinNum() {
		return minNum;
	}

	/**
	 * @return the maxNum
	 */
	public int getMaxNum() {
		return maxNum;
	}

	/**
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}

	/**
	 * @param ruleId the ruleId to set
	 */
	void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	/**
	 * @param name the name to set
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * @param minNum the minNum to set
	 */
	void setMinNum(int minNum) {
		this.minNum = minNum;
	}

	/**
	 * @param maxNum the maxNum to set
	 */
	void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	/**
	 * @param modules the modules to set
	 */
	void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
}
