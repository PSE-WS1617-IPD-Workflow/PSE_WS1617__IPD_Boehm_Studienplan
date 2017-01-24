// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.moduledata.dao;

import java.util.List;

import org.hibernate.Session;

import edu.kit.informatik.studyplan.server.filter.Filter;
import edu.kit.informatik.studyplan.server.model.HibernateUtil;
import edu.kit.informatik.studyplan.server.model.moduledata.Category;
import edu.kit.informatik.studyplan.server.model.moduledata.Discipline;
import edu.kit.informatik.studyplan.server.model.moduledata.Module;

/************************************************************/
/**
 * Ein konkretes ModulDao, welches die Datenbankverbindung über Hibernate
 * herstellt. Es kann nur auf Module, Kategorien und Vertiefungsfächer des im
 * Konstruktur angebenen Studiengangs zugreifen
 */
class HibernateModuleDao implements ModuleDao {

	@Override
	public Module getModuleById(String id) {
		Session session = HibernateUtil.getModuleDataSessionFactory().openSession();
		session.beginTransaction();
		Module module = session.bySimpleNaturalId(Module.class).load(id);
		session.getTransaction().commit();
		session.close();
		return module;
	}

	@Override
	public List<Module> getModulesByFilter(Filter filter, Discipline discipline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> getModulesByFilter(Filter filter, Discipline discipline, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module getRandomModuleByFilter(Filter filter, Discipline discipline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discipline> getDisciplines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategories(Discipline discipline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getSubjects(Discipline discipline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discipline getDisciplineById(int disciplineId) {
		Session session = HibernateUtil.getModuleDataSessionFactory().openSession();
		session.beginTransaction();
		Discipline discipline = session.byId(Discipline.class).load(disciplineId);
		session.getTransaction().commit();
		session.close();
		return discipline;
	}

	@Override
	public List<Category> getFields(Discipline discipline) {
		// TODO Auto-generated method stub
		return null;
	}

};
