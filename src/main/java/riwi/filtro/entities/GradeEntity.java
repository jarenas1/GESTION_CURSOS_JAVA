package riwi.filtro.entities;

public class GradeEntity {
    private int id;
    private Double note;
    private String description;
    private int id_student;
    private int id_course;

    //CONSTRUCTORS---------------------

    public GradeEntity() {
    }
    //WITHOUT ID
    public GradeEntity(Double note, String description, int id_student, int id_course) {
        this.note = note;
        this.description = description;
        this.id_student = id_student;
        this.id_course = id_course;
    }
    //FULL CONSTRUCTOR
    public GradeEntity(int id, Double note, String description, int id_student, int id_course) {
        this.id = id;
        this.note = note;
        this.description = description;
        this.id_student = id_student;
        this.id_course = id_course;
    }

    //GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double nota) {
        this.note = nota;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }
}