package erpcompras;

import java.util.*;

import erpcompras.modelos.EstadoSolicitud;
import erpcompras.modelos.Producto;
import erpcompras.modelos.Proveedor;
import erpcompras.modelos.SolicitudCompra;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static List<Proveedor> proveedores = new ArrayList<>();
    static List<Producto> productos = new ArrayList<>();
    static List<SolicitudCompra> solicitudes = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTION DE COMPRAS ERP =====");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Registrar producto");
            System.out.println("3. Registrar solicitud de compra");
            System.out.println("4. Listar proveedores");
            System.out.println("5. Listar productos");
            System.out.println("6. Listar solicitudes de compra");
            System.out.println("7. Buscar proveedor por ID");
            System.out.println("8. Buscar producto por nombre");
            System.out.println("9. Buscar solicitud por numero");
            System.out.println("13. Aprobar / Rechazar solicitud de compra");
            System.out.println("14. Calcular total de una solicitud");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarProveedor();
                    break;
                case 2:
                    registrarProducto();
                    break;
                case 3:
                    registrarSolicitud();
                    break;
                case 4:
                    proveedores.forEach(System.out::println);
                    break;
                case 5:
                    productos.forEach(System.out::println);
                    break;
                case 6:
                    solicitudes.forEach(System.out::println);
                    break;
                case 7:
                    buscarProveedor();
                    break;
                case 8:
                    buscarProducto();
                    break;
                case 9:
                    buscarSolicitud();
                    break;
                case 13:
                    cambiarEstado();
                    break;
                case 14:
                    calcularTotal();
                    break;
                case 15:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
        }

        } while (opcion != 15);
    }

    static void registrarProveedor() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Empresa: ");
        String empresa = scanner.nextLine();
        proveedores.add(new Proveedor(id, nombre, empresa));
    }

    static void registrarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        productos.add(new Producto(nombre, precio));
    }

    static void registrarSolicitud() {
        System.out.print("Numero de solicitud: ");
        int numSolicitud = Integer.parseInt(scanner.nextLine());
        SolicitudCompra solicitud = new SolicitudCompra(numSolicitud);
        while (true) {
            System.out.print("Producto (nombre o 'fin'): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;

            Producto p = productos.stream().filter(prod -> prod.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
            if (p == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            solicitud.agregarItem(p, cantidad);
        }
        solicitudes.add(solicitud);
    }

    static void buscarProveedor() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        proveedores.stream()
            .filter(p -> p.getId().equalsIgnoreCase(id))
            .forEach(System.out::println);
    }

    static void buscarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        productos.stream()
            .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
            .forEach(System.out::println);
    }

    static void buscarSolicitud() {
        System.out.print("Numero: ");
        String numero = scanner.nextLine();
        solicitudes.stream()
            .filter(s -> s.getNumero() == Integer.parseInt(numero))
            .forEach(System.out::println);
    }

    static void cambiarEstado() {
        System.out.print("Numero de solicitud: ");
        String numero = scanner.nextLine();
        SolicitudCompra solicitud = solicitudes.stream()
            .filter(s -> s.getNumero() == Integer.parseInt(numero)).findFirst().orElse(null);
        if (solicitud == null) {
            System.out.println("No encontrada.");
            return;
        }
        System.out.print("Nuevo estado (SOLICITADA, EN_REVISION, APROBADA, RECHAZADA): ");
        String estadoStr = scanner.nextLine().toUpperCase();
        solicitud.setEstado(EstadoSolicitud.valueOf(estadoStr));
    }

    static void calcularTotal() {
        System.out.print("Numero de solicitud: ");
        int numero = scanner.nextInt();
        solicitudes.stream()
            .filter(s -> s.getNumero() == numero)
            .forEach(s -> System.out.println("Total: $" + s.calcularTotal()));

    }
}
