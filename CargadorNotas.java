import java.util.InputMismatchException;
import java.util.Scanner;

public class CargadorNotas {
 
    public static double[] cargar() {

        int cantidad = 0;
        Scanner scanner = new Scanner(System.in);

        // Ingreso de tamaño de vector
        System.out.print("Ingrese la cantidad de notas: ");

        try {

            cantidad = scanner.nextInt();
        
        } catch (InputMismatchException e) {
            System.err.print("Ingrese valores correctos.");
            System.exit(0);
        }
        
        scanner = null;

        double[] notas = new double[cantidad];
        scanner = new Scanner(System.in);

        // Ingreso de notas

        if(cantidad <= 0) {
            System.out.println("El tamaño no puede ser 0 ni menor.");
            System.exit(0);
        }

        for(int i = 0; i < notas.length; i++) {

            try {

                System.out.print("Ingrese nota número " + (i+1) + ": ");
                notas[i] = scanner.nextDouble();

            } catch (InputMismatchException e) {
                System.err.print("Ingrese valores correctos.");
                System.exit(0);
            }
            
        }

        scanner.close();
        return notas;
    }
}
