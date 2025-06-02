package erpcompras.modelos;

import erpcompras.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private int numero;
    private EstadoSolicitud estado;
    private List<ItemCompra> items;

    public SolicitudCompra(int numero) {
        this.numero = numero;
        this.estado = EstadoSolicitud.SOLICITADA;
        this.items = new ArrayList<>();
    }

    public void agregarItem(Calculable item, int cantidad) {
        items.add(new ItemCompra(item, cantidad));
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCompra item : items) {
            total += item.calcularCostoTotal();
        }
        return total;
    }

    public int getNumero() {
        return numero;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "SolicitudCompra #" + numero + " Estado: " + estado + " Total: $" + calcularTotal();
    }

    
    private static class ItemCompra implements Calculable {
        private final Calculable item;
        private final int cantidad;

        public ItemCompra(Calculable item, int cantidad) {
            this.item = item;
            this.cantidad = cantidad;
        }

        @Override
        public double calcularCostoTotal() {
            return item.calcularCostoTotal() * cantidad;
        }
    }
}
