/**
 * 
 */
package raysrentals.co.uk.lib.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import raysrentals.co.uk.lib.security.BFSSecurityService;



/**
 * Hibernate intercepter to set the audit fields on all model objects when saving to the DB
 * @author Stephen Elliott
 */
@Component("hibernateAuditInterceptor")
public class HibernateAuditInterceptor extends EmptyInterceptor
{
	private static final long serialVersionUID = -1200086075033633817L;

	@Autowired
	private BFSSecurityService securityService;
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types)
	{
		setValue(currentState, propertyNames, "lastUpdatedBy", securityService.getLoggedInUserName());
		setValue(currentState, propertyNames, "lastUpdatedDate", LocalDateTime.now());
		return true;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
	{
		LocalDateTime now = LocalDateTime.now();
		String loggedInUserName = securityService.getLoggedInUserName();
        setValue(state, propertyNames, "createdBy", loggedInUserName);
		setValue(state, propertyNames, "createdDate", now);
		setValue(state, propertyNames, "lastUpdatedBy", loggedInUserName);
		setValue(state, propertyNames, "lastUpdatedDate", now);
		return true;
	}

	private void setValue(Object[] currentState, String[] propertyNames, String propertyToSet, Object value)
	{
		int index = Arrays.asList(propertyNames).indexOf(propertyToSet);
		if (index >= 0)
		{
			currentState[index] = value;
		}
	}
}
