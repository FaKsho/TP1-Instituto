import java.util.ArrayList;
import java.util.Scanner;

/*
 * Ejercicio 7
 *
 * Se realizó un censo provincial y se desea procesar la información obtenida en dicho
 * censo. De cada una de las personas censadas se tiene la siguiente información: número de
 * documento, edad y sexo (‘F’ o ‘M’). Realizar un algoritmo que lea los datos de cada persona
 * censada (para fin de ingreso de datos, ingresar 0 (cero) como numero de documento) e
 * informe: Cantidad total de personas censadas, cantidad de varones y cantidad de mujeres,
 * porcentaje de varones cuya edad varía entre 16 y 65 años respecto del total de varones,
 * mostrar datos de la persona que registra la mayor edad.
 */
public class EJ7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> personasCensadas = new ArrayList<>();
        int mayorEdad = 0;
        Persona personaMayorEdad = new Persona();

        System.out.println("Ingrese los datos de la persona: DNI EDAD y SEXO (F/M)");
        String[] strArr = scanner.nextLine().split("\\s+");

        while(!(strArr[0].equals("0"))){

            try {
                personasCensadas.add(new Persona(strArr[0],
                        Integer.parseInt(strArr[1]),
                        strArr[2].toUpperCase()));
            } catch (NumberFormatException e) {
                System.out.println("Revise los datos ingresados");
                continue;
            }

            strArr = scanner.nextLine().split("\\s+");
        }

        int cantidadMujeres = 0;
        int cantidadHombres = 0;
        int rangoEdadHombres = 0;

        for(Persona s: personasCensadas){

            if(s.getEdad() > mayorEdad) {
                mayorEdad = s.getEdad();
                personaMayorEdad = s;
            }

            if(s.getSexo().equalsIgnoreCase("F")) cantidadMujeres++;
            else {
                cantidadHombres++;

                if(s.getEdad() >= 16 && s.getEdad() <= 65) rangoEdadHombres++;
            }

        }

        double porcentajeRangoEdad = (double) rangoEdadHombres/cantidadHombres;

        System.out.print("Cantidad de personas censadas: " + personasCensadas.size() +
                "\nCantidad de hombres: " + cantidadHombres +
                "\nCantidad de mujeres: " + cantidadMujeres +
                "\nHombres entre 16 y 65 años: ");
        System.out.printf("%.2f", porcentajeRangoEdad*100);
        System.out.print("%\n");
        System.out.print("Persona con mayor edad: " + personaMayorEdad.toString());
    }
}

// Clase auxiliar
class Persona {

    private String DNI;
    private int edad;
    private String sexo;

    public Persona() {

    }
    public Persona(String DNI, int edad, String sexo) {
        this.DNI = DNI;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String toString() {
        return "DNI=" + DNI + " " + edad + " años " + sexo;
    }
}
