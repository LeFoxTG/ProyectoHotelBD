package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {
    
    @Id
    @Column(name = "numerohab")
    private Integer numeroHab;
    
    @Column(name = "categoria", nullable = false)
    private String categoria;
    
    @Column(name = "estadohab", nullable = false)
    private String estadoHab;
    
    @Column(name = "precionoche", nullable = false)
    private Double precioNoche;
    
    // Constructores
    public Habitacion() {}
    
    public Habitacion(Integer numeroHab, String categoria, String estadoHab, Double precioNoche) {
        this.numeroHab = numeroHab;
        this.categoria = categoria;
        this.estadoHab = estadoHab;
        this.precioNoche = precioNoche;
    }
    
    // Getters y Setters
    public Integer getNumeroHab() {
        return numeroHab;
    }
    
    public void setNumeroHab(Integer numeroHab) {
        this.numeroHab = numeroHab;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getEstadoHab() {
        return estadoHab;
    }
    
    public void setEstadoHab(String estadoHab) {
        this.estadoHab = estadoHab;
    }
    
    public Double getPrecioNoche() {
        return precioNoche;
    }
    
    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }
    
    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroHab=" + numeroHab +
                ", categoria='" + categoria + '\'' +
                ", estadoHab='" + estadoHab + '\'' +
                ", precioNoche=" + precioNoche +
                '}';
    }
}
