package riwi.filtro.entities;

public class GradeEntity {
    private int id;
    private String nota;
    private String description;
    private int id_student;
    private int id_course;

    //CONSTRUCTORS---------------------

    public GradeEntity() {
    }
    //WITHOUT ID
    public GradeEntity(String nota, String description, int id_student, int id_course) {
        this.nota = nota;
        this.description = description;
        this.id_student = id_student;
        this.id_course = id_course;
    }
    //FULL CONSTRUCTOR
    public GradeEntity(int id, String nota, String description, int id_student, int id_course) {
        this.id = id;
        this.nota = nota;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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