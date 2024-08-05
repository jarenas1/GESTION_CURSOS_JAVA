package riwi.filtro.entities;

import riwi.filtro.tools.Status;

public class StudentEntity {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private Status status;

    //CONSTRUCTORS


    public StudentEntity() {
    }

    //WITHOUT ID
    public StudentEntity(String name, String lastName, String email, Status status) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    public StudentEntity(int id, String name, String lastName, String email, Status status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }


    //GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
