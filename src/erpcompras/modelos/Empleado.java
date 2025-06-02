package erpcompras.modelos;



public class Empleado extends Persona {
    private String cargo;

    public Empleado(String cedula, String nombre, String cargo) {
        super(cedula, nombre);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Empleado{nombre='" + nombre + "', cedula='" + cedula + "', cargo='" + cargo + "'}";
    }
}
