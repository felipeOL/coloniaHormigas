/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Calculos {
    
    public void llenarMatrizDistancia(float[][] matrizDistancia,ArrayList<Punto> puntos) {

        for (int x = 0; x < matrizDistancia.length; x++) {
            for (int y = 0; y < matrizDistancia[x].length; y++) {
                if (x == y) {
                    matrizDistancia[x][y] = 0;
                } else if (x == 0) {
                    matrizDistancia[x][y] = y;
                } else if (y == 0) {
                    matrizDistancia[x][y] = x;
                } else {
                    Punto p1, p2;
                    p1 = puntos.get(x - 1);
                    p2 = puntos.get(y - 1);
                    matrizDistancia[x][y] = this.calcularDistancia(p1, p2);
                }
            }
        }

        //this.imprimirMatriz();
    }
    
    public float calcularDistancia(Punto p1, Punto p2) {
        int x1, y1, x2, y2;
        float total;
        x1 = p1.getCoordenadaX();
        y1 = p1.getCoordenadaY();
        x2 = p2.getCoordenadaX();
        y2 = p2.getCoordenadaY();
        total = this.distancia(x1, y1, x2, y2);
        return total;
    }
    
    public float distancia(int x1, int y1, int x2, int y2) {
        float dist;
        dist = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
        dist = (float) sqrt(dist);
        return dist;
    }
    
    
}
