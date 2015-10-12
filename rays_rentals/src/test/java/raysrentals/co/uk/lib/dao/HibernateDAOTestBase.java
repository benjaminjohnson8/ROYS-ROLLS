package raysrentals.co.uk.lib.dao;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import raysrentals.co.uk.lib.model.ModelBase;
import raysrentals.co.uk.lib.model.VersionControlled;
import raysrentals.co.uk.lib.service.TestGeneralDAOService;
import raysrentals.co.uk.rays_rentals.config.DAOTestsConfigurationAware;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class })
// Change this to false to see changes in the db but becareful of test data
// which is left in the db when using this.
// If database is dirtied with test data. Use
// @DatabaseSetup("classpath:dbunit/tableClear.xml") in the setup of the
// class. This will allow dbunit to clean the database table referenced in the
// xml file and run the test in a clean state.
// This will not remove the entry but just basically allow dbunit to revert the
// table to nothing to perform the test then
// put the entry back in the db.
@TransactionConfiguration(defaultRollback = true)
@Ignore
public class HibernateDAOTestBase extends DAOTestsConfigurationAware {

	private static final String TEST_USER_NAME = "testUser";
	/**
	 * Creates an instance of the DAO for the CRUD operations
	 */
	@Autowired
	protected TestGeneralDAOService generalDAOService;
	@Autowired
	protected TestGeneralDAO generalDAO;
	@Autowired
	protected TestHibernateSearchDAO searchDAO;

	@PersistenceContext
	private EntityManager entityManager;

	/** Start of test time stamp */
	private LocalDateTime timestamp;
	
	/**
	 * Before each test mark the start time of the test. This is then used to check that the hibernate
	 * audit intercepter set the created and last updated date correctly. ie after the start time.
	 */
	@Before
	public void markTime()
	{
		this.timestamp = LocalDateTime.now();
	}
	
	/**
	 * The hibernate audit intercepter sets the created by and last update by to the currently 
	 * logged in user. So must set a test user to be logged in, ie set on the security context.
	 */
	@Before
	public void setupSecurityUser() {
		// create a test user and set on the security context
		Set<SimpleGrantedAuthority> auths = new HashSet<SimpleGrantedAuthority>();
		Authentication authToken = new UsernamePasswordAuthenticationToken(TEST_USER_NAME,null, auths);
		SecurityContextHolder.getContext().setAuthentication(authToken);
	}
	
	/**
	 * Clear the security context after each test.
	 */
	@After
	public void teardown() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}

	/**
	 * Any test that updates the database (create, update or delete) will need to call this in
	 * order for the changes to take effect on the DB. 
	 * The clear will force hibernate to forget about the model objects it 
	 * Prevents false positives due to caching - must be called after DAO use
	 */
	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
// we arent using version controlled yet so these arent needed yet
//	protected void assertAuditFields(ModelBase objectToTest) {
//		// Put these in a method if using more than once.
//		assertNotNull("CreatedBy field is null", objectToTest.getCreatedBy());
//		assertNotNull("CreatedDate field is null", objectToTest.getCreatedDate());
//		assertNotNull("UpdatedBy field is null", objectToTest.getLastUpdatedBy());
//		assertNotNull("UpdatedDate field is null", objectToTest.getLastUpdatedDate());
//	}
//	
//	/**
//	 * Tests that the audit fields are not null. This should be called for all retrieve tests. But 
//	 * update and create tests should call the more specific methods assertAuditFields_create and
//	 * assertAuditFields_update respectively
//	 * @param objectToTest
//	 */
//	protected void assertAuditFields(VersionControlled objectToTest) {
//		// Put these in a method if using more than once.
//		assertNotNull("CreatedBy field is null", objectToTest.getCreatedBy());
//		assertNotNull("CreatedDate field is null", objectToTest.getCreatedDate());
//		assertNotNull("UpdatedBy field is null", objectToTest.getLastUpdatedBy());
//		assertNotNull("UpdatedDate field is null", objectToTest.getLastUpdatedDate());
//		assertNotNull("VersionNumber field is null", objectToTest.getVersionNumber());
//	}
//
//	/**
//	 * Tests that the audit fields are set correctly. ie The logged in user is the created and
//	 * update user. And that the created and last updated dates are after the test start time.
//	 * @param objectToTest
//	 */
//	protected void assertAuditFields_create(VersionControlled objectToTest) {
//		assertAuditFields(objectToTest);
//		assertEquals(TEST_USER_NAME, objectToTest.getCreatedBy());
//		assertEquals(TEST_USER_NAME, objectToTest.getLastUpdatedBy());
//		
//		// Adjust the timestamp to allow for same discrepancies when persisting to the DB
//		LocalDateTime adjustedTimestamp = timestamp.minusSeconds(1);
//		
//		assertTrue("Created date not after the start of test time.", adjustedTimestamp.isBefore(objectToTest.getCreatedDate()));
//		assertTrue("Last update date not after the start of test time.", adjustedTimestamp.isBefore(objectToTest.getLastUpdatedDate()));
//	}
//
//	/**
//	 * Tests that the audit fields are set correctly. ie The logged in user is the
//	 * update user and that the last updated date is after the test start time.
//	 * @param objectToTest
//	 */
//	protected void assertAuditFields_update(VersionControlled objectToTest) {
//		assertAuditFields(objectToTest);
//		assertEquals(TEST_USER_NAME, objectToTest.getLastUpdatedBy());
//		
//		// Adjust the timestamp to allow for same discrepancies when persisting to the DB
//		LocalDateTime adjustedTimestamp = timestamp.minusSeconds(1);
//
//		assertTrue("Last update date (" + objectToTest.getLastUpdatedDate() + ") not after the start of test time ("+adjustedTimestamp+").", 
//				adjustedTimestamp.isBefore(objectToTest.getLastUpdatedDate()));
//	}
}
