package com.training.reflection;

/**
 * Class, that describes student entity
 *
 * @version 09 Nov 2016
 * @author Taras Sakharchuk
 */
public class Student implements IStudent {
    /** Unique number assigned for each students */
    protected long id;

    /** Student's name */
    protected String name;

    /** Student's surname */
    protected String surname;

    /** Student's course */
    protected Course course;

    /**
     * Constructor that initialize fields of object
     * with appropriated arguments
     *
     * @param id unique number assigned for each students
     * @param name student's name
     * @param surname student's surname
     * @param course current course, where student studied
     */
    public Student(long id, String name, String surname, Course course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    @CustomAnnotation
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    @CustomAnnotation
    public String toString() {
        return new StringBuffer()
                .append("ID : ").append(id)
                .append("\nName : ").append(name)
                .append("\nSurname : ").append(surname)
                .append("\nCourse : ").append(course)
                .toString();
    }
}
