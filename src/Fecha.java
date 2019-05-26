/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUANPABLO
 */
public class Fecha {
    private int día;
    private int mes;
    private int año;
    private String hora;

    public Fecha(int día, int mes, int año, String hora) {
        this.día = día;
        this.mes = mes;
        this.año = año;
        this.hora = hora;
    }
    

    public int getDía() {
        return día;
    }

    public void setDía(int día) {
        this.día = día;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    
}
