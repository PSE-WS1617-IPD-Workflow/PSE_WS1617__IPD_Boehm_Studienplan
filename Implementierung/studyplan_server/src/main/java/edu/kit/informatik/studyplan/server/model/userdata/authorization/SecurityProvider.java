// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package edu.kit.informatik.studyplan.server.model.userdata.authorization;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.Session;

import edu.kit.informatik.studyplan.server.model.HibernateUtil;
import edu.kit.informatik.studyplan.server.model.userdata.User;

/************************************************************/
/**
 * Konkrete Implementierung eines Security-Providers, der Hibernate verwendet.
 */
class SecurityProvider extends AbstractSecurityProvider {
	
	private Session session;
	
	private static long SECONDS = 3600;
	
	SecurityProvider() {
		this.session = HibernateUtil.getUserDataSessionFactory().openSession();
	}
	
	@Override
	public AuthorizationContext generateAuthorizationContext(User user, RESTClient client, AuthorizationScope scope) {
		session.beginTransaction();
		AuthorizationContext context = new AuthorizationContext();
		context.setProvider(this);
		context.setRestClient(client);
		context.setScope(scope);
		context.setUser(user);
		LocalDateTime expiryDate = LocalDateTime.now().plusSeconds(SECONDS);
		context.setExpiryDate(expiryDate);
		Serializable id = session.save(context);
		session.flush();
		session.refresh(context);
		session.getTransaction().commit();
		return context;
	}

	@Override
	public AuthorizationContext getAuthorizationContext(String accessToken) {
		session.beginTransaction();
		AuthorizationContext authorizationContext = session.byId(AuthorizationContext.class).load(accessToken);
		session.getTransaction().commit();
		if (authorizationContext != null) {
			authorizationContext.setProvider(this);
			if (authorizationContext.getExpiryDate().isBefore(LocalDateTime.now())) {
				authorizationContext = null;
			}
		}
		return authorizationContext;
	}

	@Override
	public RESTClient getClient(String apiKey) {
		session.beginTransaction();
		RESTClient client = session.bySimpleNaturalId(RESTClient.class).load(apiKey);
		session.getTransaction().commit();
		return client;
	}

	@Override
	public void cleanUp() {
		session.close();
	}
};
