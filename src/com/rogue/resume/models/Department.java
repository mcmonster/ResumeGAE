package com.rogue.resume.models;

import java.util.Set;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.labs.repackaged.com.google.common.base.Objects;

/**
 * Model representing an academic department in an institution of study.
 * 
 * @author R. Matt McCann
 */
@PersistenceCapable
public class Department {
    //**********************************************************************************************
    // Member Variables
    //**********************************************************************************************
    /** Abbreviation of the department's name. */
    @Persistent
    private String abbreviation;
    
    /** Courses provided by this department. */
    @NotPersistent
    private Set<Course> courses;
   
    /** Institution at which the department belongs. */
    @NotPersistent
    private Institution institution;
    
    /** Name of the department. */
    @Persistent
    private String name;

    //**********************************************************************************************
    // Object Functions
    //**********************************************************************************************
    @Override
    public final boolean equals(final Object object) {
        if ((object == null) || !(object instanceof Department)) {
            return false;
        }
        
        final Department comparee = (Department) object;
        
        return (Objects.equal(this.abbreviation, comparee.abbreviation) &&
                Objects.equal(this.courses, comparee.courses) &&
                Objects.equal(this.institution, comparee.institution) &&
                Objects.equal(this.name, comparee.name));
    }
    
    @Override
    public final int hashCode() {
        return Objects.hashCode(abbreviation, courses, institution, name);
    }
    
    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("abbreviation", abbreviation)
                                           .add("courses", courses)
                                           .add("institution", institution)
                                           .add("name", name).toString();
    }
    
    //**********************************************************************************************
    // Getters / Setters
    //**********************************************************************************************
    public final String getAbbreviation() { return abbreviation; }
    public final Set<Course> getCourses() { return courses; }
    public final Institution getInstitution() { return institution; }
    public final String getName() { return name; }

    public final void setAbbreviation(final String abbreviation) { this.abbreviation = abbreviation; }
    public final void setCourses(final Set<Course> courses) { this.courses = courses; }
    public final void setInstitution(final Institution institution) { this.institution = institution; }
    public final void setName(final String name) { this.name = name; }
}
