package raysrentals.co.uk.lib.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import raysrentals.co.uk.lib.search.SearchModel;
import raysrentals.co.uk.lib.search.SearchResult;

import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

/**
 *
 */
@Repository
public class TestHibernateSearchDAO 
{
	/* The @Autowired annotation means that sessionFactory will be instantiated only once across the whole program 
	 * by Spring. This is much more efficient that creating a new one for each controller. Session Factories are also 
	 * heavy on processing due to loading the drivers etc.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private JPASearchProcessor searchProcessor;

	/**
	 * A very simple search facility to find all entities that match the set
	 * fields in the example.
	 */
	@SuppressWarnings("unchecked")
	public <M> List<M> findByExample(M searchExample)
	{
		try
		{
			// Note. This ties this method to the hibernate session. Not pure JPA
			Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(searchExample.getClass());
			return (List<M>) criteria.add(Example.create(searchExample)).list();
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}
	
	/**
	 * A very simple search facility to find all entities that match the set
	 * fields in the example.
	 */
	@SuppressWarnings("unchecked")
	public <M> SearchResult<M> generalSearch(SearchModel<M> searchObject)
	{
		try
		{
			com.googlecode.genericdao.search.SearchResult<M> searchAndCount = searchProcessor.searchAndCount(entityManager, searchObject.getSearchClass(), searchObject);
			
			return new SearchResult<M>(searchAndCount);
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}
	
	public <M> int count(SearchModel<M> searchObject)
	{
		try
		{
			int count = searchProcessor.count(entityManager, searchObject.getSearchClass(), searchObject);
			return count;
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}
}