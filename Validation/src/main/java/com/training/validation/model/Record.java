package com.training.validation.model;

import com.training.validation.view.View;

/**
 * Part of the model that describes record entity.
 * This entity store information about user in phone book.
 *
 * @author Taras Sakharchuk
 * @version 06 Nov 2016
 */
public class Record {
    private String surname;
    private String name;
    private String patronymic;
    private String username;
    private String comment;
    private String homePhone;
    private String cellPhone;
    private String cellPhoneOptional;
    private String email;
    private String skype;
    private Address address;
    private String createDate;
    private String editDate;
    private Group group;


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhoneOptional() {
        return cellPhoneOptional;
    }

    public void setCellPhoneOptional(String cellPhoneOptional) {
        this.cellPhoneOptional = cellPhoneOptional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Combine surname with first chars in name and patronymic
     * to create initials of person in record.
     *
     * @return initials of person in record
     */
    public String getInitials(){
        return surname + View.SPACE_DELIMITER + name.charAt(0) +
                View.POINT_DELIMITER + patronymic.charAt(0) +
                View.POINT_DELIMITER;
    }
}