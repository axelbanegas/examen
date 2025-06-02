package erpcompras.modelos;

public class Proveedor {
    private String id;
    private String nombre;
    private String empresa;

    public Proveedor(String id, String nombre, String empresa) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Proveedor{id='" + id + "', nombre='" + nombre + "', empresa='" + empresa + "'}";
    }

    public String getId() {
        return id;
    }
}
