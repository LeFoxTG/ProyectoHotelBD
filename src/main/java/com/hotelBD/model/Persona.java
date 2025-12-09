package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    
    @Id
    @Column(name = "cedulaper")
    private String cedulaPer;
    
    @Column(name = "primernom", nullable = false)
    private String primerNom;
    
    @Column(name = "segundonom")
    private String segundoNom;
    
    @Column(name = "primerapell", nullable = false)
    private String primerApell;
    
    @Column(name = "segundoapell")
    private String segundoApell;
    
    @Column(name = "calle", nullable = false)
    private String calle;
    
    @Column(name = "carrera", nullable = false)
    private String carrera;
    
    @Column(name = "numero", nullable = false)
    private String numero;
    
    @Column(name = "complemento")
    private String complemento;
    
    // Constructores
    public Persona() {}
    
    public Persona(String cedulaPer, String primerNom, String segundoNom, 
                   String primerApell, String segundoApell, String calle, 
                   String carrera, String numero, String complemento) {
        this.cedulaPer = cedulaPer;
        this.primerNom = primerNom;
        this.segundoNom = segundoNom;
        this.primerApell = primerApell;
        this.segundoApell = segundoApell;
        this.calle = calle;
        this.carrera = carrera;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    // Getters y Setters
    public String getCedulaPer() {
        return cedulaPer;
    }
    
    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }
    
    public String getPrimerNom() {
        return primerNom;
    }
    
    public void setPrimerNom(String primerNom) {
        this.primerNom = primerNom;
    }
    
    public String getSegundoNom() {
        return segundoNom;
    }
    
    public void setSegundoNom(String segundoNom) {
        this.segundoNom = segundoNom;
    }
    
    public String getPrimerApell() {
        return primerApell;
    }
    
    public void setPrimerApell(String primerApell) {
        this.primerApell = primerApell;
    }
    
    public String getSegundoApell() {
        return segundoApell;
    }
    
    public void setSegundoApell(String segundoApell) {
        this.segundoApell = segundoApell;
    }
    
    public String getCalle() {
        return calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}