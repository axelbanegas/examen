package erpcompras.modelos;

import erpcompras.interfaces.Calculable;

public class Producto implements Calculable {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularCostoTotal() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + "}";
    }
}
