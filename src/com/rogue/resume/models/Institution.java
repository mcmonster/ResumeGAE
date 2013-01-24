package com.rogue.resume.models;

import java.util.Set;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.labs.repackaged.com.google.common.base.Objects;

/**
 * Model representing an institution of study.
 * 
 * @author R. Matt McCann
 */
@PersistenceCapable
public class Institution {
    //**********************************************************************************************
    // Member Variables
    //**********************************************************************************************
    /** Departments at this institution. */
    @NotPersistent
    private Set<Department> departments;
    
    /** Name of the institution. */
    @Persistent
    private String name;
    
    //**********************************************************************************************
    // Object Functions
    //**********************************************************************************************
    @Override
    public final boolean equals(final Object object) {
        if ((object == null) || !(object instanceof Institution)) {
            return false;
        }
        
        final Institution comparee = (Institution) object;
        
        return (Objects.equal(this.departments, comparee.departments) &&
                Objects.equal(this.name, comparee.name));
    }
    
    @Override
    public final int hashCode() {
        return Objects.hashCode(departments, name);
    }
    
    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("departments", departments)
                                           .add("name", name).toString();
    }
    
    //**********************************************************************************************
    // Getters / Setters
    //**********************************************************************************************
    public final Set<Department> getDepartments() { return this.departments; }
    public final String getName() { return this.name; }
    
    public final void setDepartments(final Set<Department> departments) { this.departments = departments; }
    public final void setName(final String name) { this.name = name; }
}
