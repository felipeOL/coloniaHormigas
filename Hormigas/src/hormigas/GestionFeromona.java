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
public class GestionFeromona {
    
    public void llenarMatrizFeromonas(float[][] matrizFeromonas) {
        for (int x = 0; x < matrizFeromonas.length; x++) {
            for (int y = 0; y < matrizFeromonas[x].length; y++) {
                if (x == y) {
                    matrizFeromonas[x][y] = 0;
                } else if (x == 0) {
                    matrizFeromonas[x][y] = y;
                } else if (y == 0) {
                    matrizFeromonas[x][y] = x;
                } else {
                    matrizFeromonas[x][y] = (float) 0.1;
                }
            }
        }
    }
    
    public void evaporacionFeromona(float[][] matrizFeromonas) {
        for (int x = 0; x < matrizFeromonas.length; x++) {
            for (int y = 0; y < matrizFeromonas[x].length; y++) {
                if (x == y) {
                    matrizFeromonas[x][y] = 0;
                } else if (x == 0) {
                    matrizFeromonas[x][y] = y;
                } else if (y == 0) {
                    matrizFeromonas[x][y] = x;
                } else {
                    matrizFeromonas[x][y] = (float) (matrizFeromonas[x][y] * 0.99);
                }
            }
        }
    }
    
    public void actualizarMatrizFeromonas(Hormiga hormigaColmena,float[][] matrizFeromonas,float[][] matrizDistancia,int feromonasHormiga){
        evaporacionFeromona(matrizFeromonas);
        for (int i = 0; (i+1) < matrizDistancia.length; i++) {
            int j = i+1;
            matrizFeromonas[hormigaColmena.visitado.get(i).nodo][hormigaColmena.visitado.get(j).nodo] = (float) (matrizFeromonas[hormigaColmena.visitado.get(i).nodo][hormigaColmena.visitado.get(j).nodo] + feromonasHormiga/hormigaColmena.costoTotal);
            matrizFeromonas[hormigaColmena.visitado.get(j).nodo][hormigaColmena.visitado.get(i).nodo] = (float) (matrizFeromonas[hormigaColmena.visitado.get(j).nodo][hormigaColmena.visitado.get(i).nodo] + feromonasHormiga/hormigaColmena.costoTotal);
        }
    }
}
