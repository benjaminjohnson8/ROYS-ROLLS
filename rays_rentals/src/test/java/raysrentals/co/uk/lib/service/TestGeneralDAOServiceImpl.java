/**
 * 
 */
package raysrentals.co.uk.lib.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.jpa.GeneralDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

/**
 * General service to manage a hibernate entity
 */
@Service
@Transactional
public class TestGeneralDAOServiceImpl extends GeneralDAOImpl implements TestGeneralDAOService
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
