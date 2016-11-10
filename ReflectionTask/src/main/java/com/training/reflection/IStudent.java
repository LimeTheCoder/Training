package com.training.reflection;

/**
 * Student interface.
 * It's training interface, which main purpose is creating proxy
 * for student object.
 *
 * @version 09 Nov 2016
 * @author Taras Sakharchuk
 */
public interface IStudent {
    long getId();
    void setId(long id);

    String getName();
    void setName(String name);

    String getSurname();
    void setSurname(String surname);

    Course getCourse();
    void setCourse(Course course);
}
