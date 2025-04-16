/*
 * Ejercicio 2
 *
 *  Cargar un vector con “n” notas e indicar la cantidad de aprobados (Notas mayores o
 *  iguales a 6), la cantidad de desaprobados (Notas menores a 6).
 *
 */

public class EJ2 {

    public static void main(String[] args) {
        
        double[] notas = CargadorNotas.cargar();

        int aprob = 0;
        for(double n: notas) if(n >= 6) aprob++;

        System.out.println("Aprobados: " + aprob +
        "\nDesaprobados: " + (notas.length - aprob));
    
    }
}
