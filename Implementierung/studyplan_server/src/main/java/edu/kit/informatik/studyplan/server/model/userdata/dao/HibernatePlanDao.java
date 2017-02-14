// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata.dao;

import java.io.Serializable;

import org.hibernate.Session;

import edu.kit.informatik.studyplan.server.model.HibernateUtil;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;
import edu.kit.informatik.studyplan.server.model.userdata.Plan;

/**
 * A concrete PlanDao implementation using Hibernate.
 * @author NiklasUhl
 */
class HibernatePlanDao implements PlanDao {
	
	@Override
	public Plan getPlanById(String id) {
		if (id == null) {
			return null;
		}
		Session session = HibernateUtil.getUserDataSessionFactory().getCurrentSession();
		session.beginTransaction();
		Plan plan = session.byId(Plan.class).load(id);
		session.getTransaction().commit();
		return plan;
	}

	@Override
	public void deletePlan(Plan plan) {
		Session session = HibernateUtil.getUserDataSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ModuleEntry entry : plan.getModuleEntries()) {
			session.delete(entry);
		}
		session.delete(plan);
		session.getTransaction().commit();
	}

	@Override
	public String updatePlan(Plan plan) {
		Session session = HibernateUtil.getUserDataSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(plan);
		Serializable identifier = session.getIdentifier(plan);
		session.getTransaction().commit();
		return (String) identifier;
	}

};
