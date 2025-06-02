
---

# ERPCompras

## Descripción breve del proyecto

El proyecto **ERPCompras** es un sistema de gestión de compras desarrollado en Java bajo el paradigma de Programación Orientada a Objetos (POO). Está diseñado para administrar proveedores, productos y solicitudes de compra, facilitando el registro, búsqueda, actualización y control de estados de las solicitudes. El sistema implementa estructuras como clases, interfaces y enumeraciones para garantizar una organización modular y escalable del código, además de aplicar principios de encapsulamiento y polimorfismo para la correcta gestión de los datos y operaciones involucradas en el proceso de compras.

---

## Instrucciones para ejecutar el sistema

1. **Estructura del proyecto**
   Mantenga la siguiente estructura de carpetas y paquetes dentro de la carpeta raíz `src`:

   ```
   src/
      erpcompras/
         App.java
         modelos/
            Producto.java
            Proveedor.java
            SolicitudCompra.java
            EstadoSolicitud.java
            Persona.java
            SolicitudCompra.java
         interfaces/
            Calculable.java
   ```

2. **Declaración de paquetes**
   Cada archivo `.java` contiene en la primera línea la declaración correspondiente a su paquete:

   * Archivos en `src/erpcompras`:
     `package erpcompras;`
   * Archivos en `src/erpcompras/modelos`:
     `package erpcompras.modelos;`
   * Archivos en `src/erpcompras/interfaces`:
     `package erpcompras.interfaces;`

3. **Compilación**
   Abra una terminal y navegue hasta la carpeta `src` (raíz del código fuente). Luego ejecute:

   ```
   javac erpcompras/*.java erpcompras/modelos/*.java erpcompras/interfaces/*.java
   ```

   Esto compilará todos los archivos `.java` y generará los `.class`.

4. **Ejecución**
   Desde la misma carpeta `src`, ejecute el programa con:

   ```
   java -cp bin erpcompras.App
   ```

5. **Requisitos**

   * Tener instalado JDK 11 o superior.
   * Se recomienda usar un IDE con soporte Java (por ejemplo, Visual Studio Code o IntelliJ IDEA) para facilitar la edición y ejecución.

6. **Funcionamiento del sistema**
   Al ejecutar la aplicación, se desplegará un menú interactivo en consola que permite:

   * Registrar proveedores y productos.
   * Crear y gestionar solicitudes de compra.
   * Consultar y buscar registros.
   * Modificar el estado de las solicitudes y calcular totales.

---
