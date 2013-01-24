package com.rogue.resume.models;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.labs.repackaged.com.google.common.base.Objects;

import java.util.Map;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.joda.time.Interval;

/**
 * Model representing a course of study.
 * 
 * @author R. Matt McCann
 */
@PersistenceCapable
public class Course {
    //**********************************************************************************************
    // Member Variables
    //**********************************************************************************************
    /** 
     * Course code used when displaying the abbreviated name of the course
     * i.e the 600 in CSE600.
     */
    @Persistent
    private int code;
    
    /** Number of credits the course is worth. */
    @Persistent
    private int credits;
    
    /** Department to which the course belongs. */
    @Persistent
    private Department department;
    
    /** Description of the course. */
    @Persistent
    private String description;
    
    /** GPA achieved in the class. */
    @Persistent
    private float gpa;
    
    /** Database records ID. */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;
    
    /** Name of the course. */
    @Persistent
    private String name;
    
    /** Professor who taught the course. */
    @NotPersistent
    private Professor professor;
    
    /** 
     * Skills studied in the course mapped to a description of how they were
     * studied.
     */
    @NotPersistent
    private Map<Skill, String> skillsStudied;
            
    /** When the course was taken. */
    @NotPersistent
    private Interval whenEnrolled;

    //**********************************************************************************************
    // Object Functions
    //**********************************************************************************************
    @Override
    public final boolean equals(final Object object) {
        if ((object == null) || !(object instanceof Course)) {
            return false;
        }
        
        final Course comparee = (Course) object;
        
        return (Objects.equal(this.code, comparee.code) &&
                Objects.equal(this.credits, comparee.credits) &&
                Objects.equal(this.department, comparee.department) &&
                Objects.equal(this.description, comparee.description) &&
                Objects.equal(this.gpa, comparee.gpa) &&
                Objects.equal(this.id, comparee.id) &&
                Objects.equal(this.name, comparee.name) &&
                Objects.equal(this.professor, comparee.professor) &&
                Objects.equal(this.skillsStudied, comparee.skillsStudied) &&
                Objects.equal(this.whenEnrolled, comparee.whenEnrolled));
    }
    
    @Override
    public final int hashCode() {
        return Objects.hashCode(code, credits, department, description, gpa, id, name, professor, 
                skillsStudied, whenEnrolled);
    }
    
    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("code", code)
                                           .add("credits", credits)
                                           .add("department", department)
                                           .add("description", description)
                                           .add("gpa", gpa)
                                           .add("id", id)
                                           .add("name", name)
                                           .add("professor", professor)
                                           .add("skillsStudied", skillsStudied)
                                           .add("whenEnrolled", whenEnrolled).toString();
    }
    
    //**********************************************************************************************
    // Getters / Setters
    //**********************************************************************************************
    public int getCode() { return code; }
    public Department getDepartment() { return department; }
    public String getDescription() { return description; }
    public float getGpa() { return gpa; }
    public Key getId() { return id; }
    public String getName() { return name; }
    public Professor getProfessor() { return professor; }
    public Map<Skill, String> getSkillsStudied() { return skillsStudied; }
    public Interval getWhenEnrolled() { return whenEnrolled; }

    public void setCode(int code) { this.code = code; }
    public void setDepartment(Department department) { this.department = department; }
    public void setDescription(String description) { this.description = description; }
    public void setGpa(float gpa) { this.gpa = gpa; }
    public void setId(Key id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public void setSkillsStudied(Map<Skill, String> skillsStudied) { this.skillsStudied = skillsStudied; }
    public void setWhenEnrolled(Interval whenEnrolled) { this.whenEnrolled = whenEnrolled; }
}
