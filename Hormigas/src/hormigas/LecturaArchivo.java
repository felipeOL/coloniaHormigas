/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class LecturaArchivo {
    
    Scanner entrada;
    
    public void leerArchivo(ArrayList<Punto> puntos) throws Exception{
        int contadorLinea = 0;
        
        try{
            entrada =  new Scanner(new File("a280.tsp"));
            
            // FORMA TRUCHA DE HACER SALTO DE LINEA.
            String lineaNombre = entrada.nextLine();
            String lineaComentario = entrada.nextLine();
            String lineaTipo = entrada.nextLine();
            String lineaDimension = entrada.nextLine();
            String lineaTipoEuclediano = entrada.nextLine();
            String lineaCoordenadas = entrada.nextLine();
            // TERMINO DE FORMA TRUCHA.
        
            while((entrada.hasNext()) && contadorLinea < 280 ){
                
                int nodo = (Integer.valueOf(entrada.next()));
                int coordenadaX = (Integer.valueOf(entrada.next()));
                int coordenadaY = (Integer.valueOf(entrada.next()));
                Punto punto = new Punto(nodo, coordenadaX, coordenadaY);
                puntos.add(punto);
                contadorLinea++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
