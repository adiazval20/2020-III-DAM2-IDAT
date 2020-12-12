package edu.idat.semana5.entity;

public class Seccion {
    private int id;
    private String nombre;
    private int imagenId;

    public Seccion() {
    }

    public Seccion(int id, String nombre, int imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.imagenId = imagenId;
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
}
