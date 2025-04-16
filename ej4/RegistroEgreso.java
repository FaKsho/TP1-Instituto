package ej4;

import java.time.LocalTime;

/*
 * Clase auxiliar para el Ejercicio 4
 */
public class RegistroEgreso {
    private Chofer chofer;
    private String tipoCarga;
    private LocalTime horaEgreso;
    private String patente;

    public RegistroEgreso() {

    }
    public RegistroEgreso(Chofer chofer, String tipoCarga, LocalTime horaEgreso, String patente) {
        this.chofer = chofer;
        this.tipoCarga = tipoCarga;
        this.horaEgreso = horaEgreso;
        this.patente = patente;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public LocalTime getHoraEgreso() {
        return horaEgreso;
    }

    public void setHoraEgreso(LocalTime horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Registro >>" +
                " Chofer=" + chofer.toString() +
                ", \t patente='" + patente + '\'' +
                ", \t tipoCarga='" + tipoCarga + '\'' +
                ", \t horaEgreso=" + horaEgreso;
    }
}

