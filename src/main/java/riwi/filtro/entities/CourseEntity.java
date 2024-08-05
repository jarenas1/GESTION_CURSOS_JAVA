package riwi.filtro.entities;

public class CourseEntity {
    private int id;
    private String name;

    //CONTRUCTORS-----------------------------
    public CourseEntity() {
    }

    //WITHOUT ID
    public CourseEntity(String name) {
        this.name = name;
    }
    //FULL CONSTRUCTOR
    public CourseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //GETTERS AND SETTERS----------------------------


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
}
