package com.training.reflection;

/**
 * Class, that describes student with diploma topic.
 *
 * @version 09 Nov 2016
 * @author Taras Sakharchuk
 */
public class DiplomaStudent extends Student {
    /** Topic of student's diploma work */
    private String diplomaTopic;

    /**
     * Constructor that initialize fields of object
     * with appropriated arguments.
     * Set course field to {@code Course.SENIOR } value,
     * cause only students of senior year can have diploma work.
     *
     * @param id unique number assigned for each students
     * @param name student's name
     * @param surname student's surname
     * @param diplomaTopic topic of student's diploma work
     */
    public DiplomaStudent(long id, String name, String surname, String diplomaTopic) {
        super(id, name, surname, Course.SENIOR);
        this.diplomaTopic = diplomaTopic;
    }

    public String getDiplomaTopic() {
        return diplomaTopic;
    }

    @CustomAnnotation
    public void setDiplomaTopic(String diplomaTopic) {
        this.diplomaTopic = diplomaTopic;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDiploma Topic : " + diplomaTopic;
    }
}
