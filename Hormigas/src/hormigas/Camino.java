/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

/**
 *
 * @author felipe
 */
public class Camino {
    public Punto origen, llegada;
    public double probabilidad;

    public Camino(Punto origen, Punto llegada, double probabilidad) {
        this.origen = origen;
        this.llegada = llegada;
        this.probabilidad = probabilidad;
    }

    public Punto getOrigen() {
        return origen;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public Punto getLlegada() {
        return llegada;
    }

    public void setLlegada(Punto llegada) {
        this.llegada = llegada;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    
    
    
}
