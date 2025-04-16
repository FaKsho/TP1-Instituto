/*
 * Ejercicio 1
 *
 *  Un alumno tiene “n” notas (Se ingresa por teclado la cantidad de notas) que se deben
 *  cargar en un vector (Se debe definir el vector en base a la cantidad de notas que se van a
 *  ingresar, por ejemplo: Si son 5 notas, el vector debe ser de tamaño 5). Luego de cargar las
 *  notas se debe mostrar la nota más alta y el promedio de notas.
 *
 */

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EJ1{

    public static void main(String[] args){

        double[] notas = CargadorNotas.cargar();

        // Promedio
        double count = 0;
        for(double n: notas) {

            count = count + n;
        }
        System.out.print("El promedio es: ");
        System.out.printf("%.2f", count/notas.length);
        System.out.println();

        // Nota más alta
        Arrays.sort(notas);
        System.out.println("Nota más alta: " + notas[notas.length-1]);

        
    }

    
}