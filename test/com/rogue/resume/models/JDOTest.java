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
    
    @Before
    public void setUp() {
        datastoreHelper.setUp();
    }
    
    @After
    public void tearDown() {
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
            assertEquals("Retrieved course", expected, results.get(0));
        } finally {
            query.closeAll();
            datastore.close();
        }
    }
}
