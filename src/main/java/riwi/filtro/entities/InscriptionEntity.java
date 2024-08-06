package riwi.filtro.entities;

public class InscriptionEntity {
    private int id;
    private int id_course;
    private int id_student;

    //CONSTRUCTORS


    public InscriptionEntity() {
    }

    //WITHOUT ID
    public InscriptionEntity(int id_course, int id_student) {
        this.id_course = id_course;
        this.id_student = id_student;
    }

    //FULL CONSTRUCTOR
    public InscriptionEntity(int id, int id_course, int id_student) {
        this.id = id;
        this.id_course = id_course;
        this.id_student = id_student;
    }

    //GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }
}
