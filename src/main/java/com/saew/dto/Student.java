package com.saew.dto;

public class Student {
    // Variables de instancia
    private int id;
    private String nombre;
    private String correoElectronico;
    private float gpa;

    // Constructor sin argumentos
    public Student() {
    }

    // Constructor con todos los argumentos
    public Student(int id, String nombre, String correoElectronico, float gpa) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.gpa = gpa;
    }

    // Métodos get y set para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos get y set para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos get y set para correoElectronico
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Métodos get y set para gpa
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
