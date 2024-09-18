package ec.edu.ups.builder.activo_fijo.dto;

public class ActivoFijoRequest {

    private String codigo;
    private String nombres;
    private double precio;
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private String ubicacion;

    // Getters and setters for each field

    // Example getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public String getColor() {
        return color;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    // Example setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}