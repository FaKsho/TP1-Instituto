/* Ejercicio 6
 *
 * En una carrera automovilística se desea calcular cuál es el menor tiempo realizado entre
 * cada uno de sus 12 competidores. Para ello, se pide un algoritmo que sea capaz de permitir
 * el ingreso por teclado del número de vehículo y el tiempo (en segundos) de cada
 * participante. Una vez encontrado el que realizó el mejor tiempo, se debe informar por
 * pantalla tanto el número de vehículo que utilizaba como el tiempo que llevó a cabo.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class EJ6 {

    public static void main(String[] args) {

        int numeroVehiculo = 0, vehiculoMasRapido = 0;
        double tiempoMasRapido = Integer.MAX_VALUE;

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i++){

            System.out.println(i);
            System.out.print("Ingrese número de vehículo y velocidad: ");
            String[] strArr = scanner.nextLine().split("\\s+");
            double tiempo = Double.MAX_VALUE;

            try {
                numeroVehiculo = Integer.parseInt(strArr[0]);
                tiempo = Double.parseDouble(strArr[1]);
            } catch (Exception e) {
                System.out.println("Ingrese valores válidos.");
                i--;
            }

            if(tiempo < tiempoMasRapido) {
                tiempoMasRapido = tiempo;
                vehiculoMasRapido =  numeroVehiculo;
            }
        }

        System.out.println("El vehículo más rápido fue el Nro" + vehiculoMasRapido + " con una velocidad de " + tiempoMasRapido + "s");
    }
}
