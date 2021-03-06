package edu.idat.semana1.entity;

public class Planeta {
    private int id;
    private String nombre;
    private int imagenId;
    private String descripcion;

    // ALT + INSERT

    public Planeta() {
    }

    public Planeta(int id, String nombre, int imagenId, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.imagenId = imagenId;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
