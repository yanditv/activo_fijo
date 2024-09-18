package ec.edu.ups.builder.activo_fijo.models;

public class ActivoBuilder {
    private ActivoFijo activoFijo;

    // Constructor para los atributos obligatorios
    public ActivoBuilder(String codigo, String nombres, double precio) {
        this.activoFijo = new ActivoFijo(codigo, nombres, precio);
    }

    // Métodos para establecer los atributos opcionales
    public ActivoBuilder conMarca(String marca) {
        this.activoFijo.setMarca(marca);
        return this;
    }

    public ActivoBuilder conModelo(String modelo) {
        this.activoFijo.setModelo(modelo);
        return this;
    }

    public ActivoBuilder conAño(int año) {
        this.activoFijo.setAño(año);
        return this;
    }

    public ActivoBuilder conColor(String color) {
        this.activoFijo.setColor(color);
        return this;
    }

    public ActivoBuilder conUbicacion(String ubicacion) {
        this.activoFijo.setUbicacion(ubicacion);
        return this;
    }

    public ActivoFijo build() {
        return this.activoFijo;
    }
}
