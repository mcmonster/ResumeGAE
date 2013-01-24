/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rogue.resume.models;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import static org.junit.Assert.assertEquals;

/**
 * Tests the JDO annotations to the resume models.
 * 
 * @author R. Matt McCann
 */
public class JDOTest {
    private final PersistenceManager datastore = 
            JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
    
    private final LocalServiceTestHelper datastoreHelper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    
    private final Logger logger = LoggerFactory.getLogger(JDOTest.class);
    
    @Before
    public void setUp() {
        datastoreHelper.setUp();
    }
    
    @After
    public void tearDown() {
        datastore.close();
        datastoreHelper.tearDown();
    }
    
    @Test
    public void testCourseJDO() {
        // Set up the test model
        final Course expected = new Course();
        expected.setCode(600);
        expected.setDescription("An assembly and compiler development class");
        expected.setGpa(2.4f);
        expected.setName("Software Engineering Project");
        final Department department = new Department();
        department.setAbbreviation("CSE");
        department.setName("Computer Science & Engineering");
        expected.setDepartment(department);
        logger.info("Expected: " + expected);
        
        // Set up the retrieval of the test model
        Query query = datastore.newQuery(Course.class);
        query.setFilter("code == 600");
        
        try {
            // Commit the test model
            datastore.makePersistent(expected);
            
            // Retrieve the test model
            List<Course> results = (List<Course>) query.execute();
            
            // Verify the results
            final int expectedNumResults = 1;
            assertEquals("# of courses retrieved", expectedNumResults, results.size());
            logger.info("Got: " + results.get(0));
            assertEquals("Retrieved course", expected, results.get(0));
        } finally {
            query.closeAll();
        }
    }
    
    @Test
    public void testDepartmentJDO() {
        // Set up the test model
        final Department expected = new Department();
        expected.setAbbreviation("CSE");
        expected.setName("Computer Science & Engineering");
        logger.info("Expected: " + expected);
        
        // Set up the retrieval of the test model
        Query query = datastore.newQuery(Department.class);
        query.setFilter("abbreviation == 'CSE'");
        
        try {
            // Commit the test model
            datastore.makePersistent(expected);
            
            // Retrieve the test model
            List<Department> results = (List<Department>) query.execute();
            
            // Verify the results
            final int expectedNumResults = 1;
            assertEquals("# of courses retrieved", expectedNumResults, results.size());
            logger.info("Got: " + results.get(0));
            assertEquals("Retrieved course", expected, results.get(0));
        } finally {
            query.closeAll();
        }
    }
    
    @Test
    public void testInstitutionJDO() {
        // Set up the test model
        final Institution expected = new Institution();
        expected.setName("Ohio State University");
        logger.info("Expected: " + expected);
        
        // Set up the retrieval of the test model
        Query query = datastore.newQuery(Institution.class);
        query.setFilter("name == 'Ohio State University'");
        
        try {
            // Commit the test model
            datastore.makePersistent(expected);
            
            // Retrieve the test model
            List<Institution> results = (List<Institution>) query.execute();
            
            // Verify the results
            final int expectedNumResults = 1;
            assertEquals("# of courses retrieved", expectedNumResults, results.size());
            logger.info("Got: " + results.get(0));
            assertEquals("Retrieved course", expected, results.get(0));
        } finally {
            query.closeAll();
        }
    }
}
