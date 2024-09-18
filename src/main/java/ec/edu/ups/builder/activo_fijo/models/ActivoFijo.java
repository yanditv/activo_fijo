package ec.edu.ups.builder.activo_fijo.models;

public class ActivoFijo {
    // Atributos obligatorios
    private final String codigo;
    private final String nombres;
    private final double precio;

    // Atributos opcionales
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private String ubicacion;

    // Constructor para los atributos obligatorios
    public ActivoFijo(String codigo, String nombres, double precio) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.precio = precio;
    }

    // Métodos para establecer los atributos opcionales

    @Override
    public String toString() {
        return "ActivoFijo {" +
                "codigo='" + codigo + '\'' +
                ", nombres='" + nombres + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", color='" + color + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
