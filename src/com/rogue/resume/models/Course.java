package com.rogue.resume.models;

import com.google.appengine.api.datastore.Key;

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
    /** 
     * Course code used when displaying the abbreviated name of the course
     * i.e the 600 in CSE600.
     */
    @Persistent
    private int code;
    
    /** Department to which the course belongs. */
    @NotPersistent
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
