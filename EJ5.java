/*
 * Ejercicio 5
 *
 *  Un gerente de una empresa prestadora de servicios de internet necesita un algoritmo que
 *  permita realizar el cálculo del monto a pagar de la factura de consumo de internet de 5
 *  clientes de una empresa. Para ello, el algoritmo debe solicitar por teclado dos datos: DNI del
 *  cliente y tipo de servicio. Los tipos de servicio son 3: 1. Internet 30 megas (El servicio
 *  cuesta: $750) 2. Internet 50 megas (El servicio cuesta: $1100) 3. Internet 100 megas (El
 *  servicio cuesta: $1500 – menos 5% de descuento por promoción) El algoritmo debe poder
 *  calcular el monto a pagar (dependiendo del tipo de servicio con el que cuente el cliente) e
 *  informar por pantalla el dni del mismo junto con el monto a pagar y el número de servicio
 *  con el que cuenta.
 */

import java.util.Scanner;

public class EJ5 {

    public static void main(String[] args) {

        String[] resumenesCuota = new String[2];
        for(int i = 0; i < resumenesCuota.length; i++) {

            Scanner scanner = new Scanner(System.in);
            String DNI, tipoServicio;
            double precioFinal = 0;

            System.out.println("Ingrese DNI del cliente y el tipo de servicio.");
            String entrada = scanner.nextLine();
            String[] strArr = entrada.split("\\s");

            DNI = strArr[0].replace(".", "");
            tipoServicio = strArr[1];

            switch (tipoServicio){
                case "1":
                    precioFinal = 750;
                    break;
                case "2":
                    precioFinal = 1100;
                    break;
                case "3":
                    precioFinal = 1500 - (1500 * 0.05);
                    System.out.println("Se aplicó un descuento del 5%");
                    break;
                default:
                    System.out.println("Ingrese un valor correcto");
                    System.exit(0);
            }

            resumenesCuota[i] = "DNI=" +DNI + " Precio Final= $" + precioFinal;
        }

        for(String s: resumenesCuota) {

            System.out.println(s);
        }
    }
}
