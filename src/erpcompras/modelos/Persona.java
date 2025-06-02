package erpcompras.modelos;

public abstract class Persona {
    protected String cedula;
    protected String nombre;

    public Persona(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', cedula='" + cedula + "'}";
    }
}

