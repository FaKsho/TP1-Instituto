/*
 * Ejercicio 4
 *
 *  Una empresa de camiones necesita un algoritmo para controlar el egreso de sus 30
 *  camiones desde la planta y la carga que transportan. Para ello, se necesita que por cada
 *  camión se cargue por teclado su patente, el nombre y apellido del chofer, el tipo de carga
 *  que lleva (madera, yerba o té) y a qué hora egresó. Además, la empresa necesita saber
 *  cuántos camiones cargaron té. Al final, debe mostrar todos estos datos por pantalla al
 *  usuario.
 *
 */

package ej4;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EJ4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RegistroEgreso[] registros = new RegistroEgreso[30];

        System.out.print("Desea ingresar MANUALMENTE los registros de los 30 egresos? (S/N) ");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("n")) autoRellenar(registros);
        else {
            System.out.println(">>Ingrese los datos del registro en el siguiente orden:\n\t NOMBRE APELLIDO PATENTE TIPO_DE_CARGA HORA   (La hora se ingresa sin los : Por ejemplo 13 30)");

            for (int i = 0; i < registros.length; i++) {
                System.out.print("Engreso nro " + (i+1) + ": ");
                registros[i] = crearRegistro();
            }
        }

        // Impresión de registros
        int camionesDeTe = 0;
        for(RegistroEgreso re: registros) {

            System.out.println(re.toString());

            if(re.getTipoCarga().equalsIgnoreCase("te") || re.getTipoCarga().equalsIgnoreCase("té")) {
                camionesDeTe++;
            }
        }

        System.out.println("Se registraron " + camionesDeTe + " camiones que llevaban té.");
    }

    /*
     * Método que rellena automáticamente el array de registros
     */
    private static void autoRellenar(RegistroEgreso[] registros) {

        Random random = new Random();
        String[] nombres = {"Juan", "Pedro", "Carlos", "Luis", "Fernando", "Marcos", "Daniel", "Pablo", "Jose", "Manuel", "Facundo", "Fabricio", "Alejando", "Andrés", "Valentina", "Ana"};
        String[] apellidos = {"Perez", "García", "González", "Martinez", "Lopez", "Da Silva", "Rodriguez", "Acosta", "Romero", "Díaz", "Sanchez", "Castro", "Rojas", "Torres"};
        String[] tipoCarga = {"Madera", "Yerba", "Té"};

        for(int i = 0; i < registros.length; i++) {

            // Generar chofer
            Chofer chofer = new Chofer(
                    nombres[random.nextInt(nombres.length)],
                    apellidos[random.nextInt(apellidos.length)]
            );

            // Generar carga
            String carga =  tipoCarga[random.nextInt(tipoCarga.length)];

            // Generar hora de egreso
            LocalTime hora = LocalTime.of(
                    random.nextInt(24),
                    random.nextInt(60)
            );

            // Generar patente
            String patente = "";
            for(int j = 0; j < 3; j++) {
                patente = patente + (char) ('A' + random.nextInt(26));
            }
            for(int j = 0; j < 3; j++) {
                patente = patente + random.nextInt(10);
            }

            registros[i] = new RegistroEgreso(chofer, carga, hora, patente);
        }

        System.out.println("\n\tAUTORRELLENADO COMPLETADO\n");

    }

    /*
     * Método de utilidad que se encarga de convertir el String de datos ingresados del usuario
     *    en un objeto de tipo Registro.
     */
    private static RegistroEgreso crearRegistro() {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        String[] strArray = entrada.split("\\s+");
        RegistroEgreso registro = new RegistroEgreso();

        try {
            registro.setChofer(new Chofer(strArray[0], strArray[1]));
            registro.setPatente(strArray[2]);
            registro.setTipoCarga(strArray[3]);
            registro.setHoraEgreso(LocalTime.of(
                    Integer.parseInt(strArray[4]),
                    Integer.parseInt(strArray[5])
            ));
        } catch (InputMismatchException e) {
            System.err.print("Ingrese valores correctos.");
            System.exit(0);
        }

        return registro;
    }
}

