/**
 * 
 */
package raysrentals.co.uk.lib.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.jpa.GeneralDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

/**
 * General service to manage a hibernate entity. 
 * 
 * Should only be used for test applications 
 * @author selliott
 */
@Repository
public class TestGeneralDAO extends GeneralDAOImpl
{
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
	
	@Override
    @Autowired
    public void setSearchProcessor(JPASearchProcessor searchProcessor){
        super.setSearchProcessor(searchProcessor);
    }
}
