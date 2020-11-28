package edu.idat.semana5.entity;

public class Producto {
    private int id;
    private String nombre;
    private String decscripcion;
    private double precio;
    private int imagenId;

    public Producto() {
    }

    public Producto(int id, String nombre, String decscripcion, double precio, int imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.decscripcion = decscripcion;
        this.precio = precio;
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

    public String getDecscripcion() {
        return decscripcion;
    }

    public void setDecscripcion(String decscripcion) {
        this.decscripcion = decscripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
