package com.leonino.appweb.model;

import javax.validation.constraints.NotBlank;

public class Jedi {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    public Jedi() {
    }

    public Jedi(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
