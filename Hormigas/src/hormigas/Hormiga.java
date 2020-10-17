/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Hormiga {
    public ArrayList <Punto> visitado;
    public double costoTotal;

    public Hormiga() {
        visitado = new ArrayList();
    }

    public void imprimirCamino(){
        for (int i = 0; i < visitado.size(); i++) {
            if(i%10 == 0){
                System.out.println();
            }else{
                System.out.print(visitado.get(i).getNodo()+" -> \t");
            }
        }
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    
}
