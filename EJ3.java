/*
 * Ejercicio 3
 *
 *  Se tienen 2 vectores con “n” productos, uno con las cantidades[n] y el otro con los
 *  costos[n]. Determinar el precio total e informar todos aquellos que superen los $1000.
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class EJ3 {

    public static void main(String[] args) {
        
        // Cantidad de productos
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de productos: ");
        Producto[] productos = new Producto[scanner.nextInt()];
        scanner = null;

        // Ingreso de productos
        scanner = new Scanner(System.in);
        System.out.println("\n>>Ingrese: NOMBRE, CANTIDAD y PRECIO, en el mismo orden, y separado por espacios.<<\n");
        for(int i = 0; i < productos.length; i++) {

            System.out.print("Ingrese el producto " + i + ": ");
            productos[i] = Producto.crearProducto(scanner.nextLine());
        }

        // Listado de productos que superan los $1000
        for(Producto p: productos) {

            if(p.getPrecio() >= 1000) {
                System.out.println("SUPERA LOS $1000 -> " + p.toString());  
            }
        }
    }
}

/*
 * Clase auxiliar
 */
class Producto {

    private String nombre;
    private int cantidad;
    private double precio;

    public Producto() {

    }

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String toString() {

        return " Información del producto: >> " + nombre + " | " +
                cantidad + " unidades | $" +
                precio + " <<";
    }

    // Permite crear un producto en base a un string
    // Formato: NOMBRE CANTIDAD PRECIO
    public static Producto crearProducto(String producto) {

        String nombre = "";
        int cantidad = 0;
        double precio = 0;

        String[] strArray = producto.split("\\s+");

        if (strArray.length > 3) {
            System.out.println("Solo incluya 3 campos");
            System.exit(0);
        }
        try {
            nombre = strArray[0];
            cantidad = Integer.parseInt(strArray[1]);
            precio = Double.parseDouble(strArray[2]);

        } catch (NumberFormatException e) {
            System.out.print("Revise los campos ingresados");
            System.exit(0);
        }

        return new Producto(nombre, cantidad, precio);
    }
}