// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata.dao;

import java.io.Serializable;

import org.hibernate.Session;

import edu.kit.informatik.studyplan.server.model.HibernateUtil;
import edu.kit.informatik.studyplan.server.model.userdata.ModuleEntry;
import edu.kit.informatik.studyplan.server.model.userdata.Plan;

/************************************************************/
/**
 * Ein konkretes PlanDao, welches die Datenbankverbindung über Hibernate
 * herstellt.
 */
class HibernatePlanDao implements PlanDao {

	@Deprecated
	private Session session;
	@Deprecated
	private boolean independet;
	
	@Deprecated
	HibernatePlanDao(AuthorizationContext context) {
		if (context != null) {
			session = ((SecurityProvider) context.getProvider()).getSession();
		} else {
			session = HibernateUtil.getUserDataSessionFactory().openSession();
			independet = true;
		}
	}
	
	public HibernatePlanDao() {
		// TODO Auto-generated constructor stub
	}
	
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

	@Override
	@Deprecated
	public void cleanUp() {
		if (independet) {
			session.close();
		}
	}

};
