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
public class Punto {
    public int nodo;
    public int coordenadaX;
    public int coordenadaY;

    public Punto(int nodo, int coordx, int coordy) {
        this.nodo = nodo;
        this.coordenadaX = coordx;
        this.coordenadaY = coordy;
    }

    public int getNodo() {
        return nodo;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
    
    
    
}
