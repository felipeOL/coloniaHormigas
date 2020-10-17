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
public class Hormigas {
    
    public Menu menu;
    public ArrayList<Hormiga> hormigasColmena;
    public ArrayList<Punto> puntos;
    public float matrizDistancia[][] = new float[281][281];
    public float matrizFeromonas[][] = new float[281][281];
    public ArrayList<Punto> noVisitados,valores;
    public ArrayList<Camino> caminos;
    public LecturaArchivo lectura;
    public Calculos calculo;
    public Punto puntoActual;
    public GestionFeromona gestionFeromona;
    public int colmena = 10000;
    public int feromonasHormiga = 100;
    
    public Hormigas() {
        menu = new Menu();
        caminos = new ArrayList();
        valores = new ArrayList();
        puntos = new ArrayList();
        noVisitados = new ArrayList();
        hormigasColmena = new ArrayList();
        calculo = new Calculos();
        lectura = new LecturaArchivo();
        gestionFeromona = new GestionFeromona();

    }
    
    /**
     * 
     */
    public void creacionHormigas() {
        for (int i = 0; i < this.colmena; i++) {
            Hormiga hormigaNueva = new Hormiga();
            hormigasColmena.add(hormigaNueva);
        }

    }
    
    /**
     * 
     */
    public void llenarPuntosNoVisitados() {
        for (Punto puntoNoVisitado : puntos) {
            noVisitados.add(puntoNoVisitado);
        }
    }
    
    /**
     * 
     * @throws Exception 
     */
    public void iniciar() throws Exception {
        menu.mensajeBienvenido();
        menu.Precuacion();
        lectura.leerArchivo(puntos);
        calculo.llenarMatrizDistancia(matrizDistancia,puntos);
        gestionFeromona.llenarMatrizFeromonas(matrizFeromonas);
        creacionHormigas();
        
        //this.hormigasExploradoras.clear();
        for (Hormiga hormigaColmena : hormigasColmena) {
            Punto puntoo = puntos.get(0);
            hormigaColmena.visitado.add(puntoo);
            llenarPuntosNoVisitados();
            noVisitados.remove(puntoo);
            puntoActual = puntoo;
            while (!noVisitados.isEmpty()) {
                puntoo = calcularMovimiento(noVisitados, puntoActual);
                hormigaColmena.visitado.add(puntoo);
                noVisitados.remove(puntoo);
                puntoActual = puntoo;
            }
            
            if (noVisitados.isEmpty()) {
                puntoo = puntos.get(0);
                hormigaColmena.visitado.add(puntoo);
                hormigaColmena.setCostoTotal(this.calcularCostoCamino(hormigaColmena.visitado));
                System.out.println(hormigaColmena.getCostoTotal());
                if(hormigaColmena.getCostoTotal() < 4500){
                    System.out.println(hormigaColmena.getCostoTotal());
                    hormigaColmena.imprimirCamino();
                    break;
                }
                noVisitados.clear();
            }
            gestionFeromona.actualizarMatrizFeromonas(hormigaColmena,matrizFeromonas,matrizDistancia,feromonasHormiga);
            
        }
        
    }
    
    /**
     * 
     * @param noVisitados
     * @param puntoActual
     * @return 
     */
    public Punto calcularMovimiento(ArrayList<Punto> noVisitados, Punto puntoActual) {
        double sumaVisibilidad = 0;
        double feromonas, distancia;
        double variable, visibilidad;
        for (Punto noVisitado : noVisitados) {
            distancia = this.matrizDistancia[puntoActual.nodo][noVisitado.nodo];
            if (distancia != 0) {
                visibilidad = 1 / distancia;
            } else {
                visibilidad = 0;
            }
            sumaVisibilidad = sumaVisibilidad + visibilidad;
            feromonas = this.matrizFeromonas[puntoActual.nodo][noVisitado.nodo];
            variable = feromonas * visibilidad;
            Camino caminoNuevo = new Camino(puntoActual, noVisitado, variable);
            caminos.add(caminoNuevo);
        }
        for (Camino camino : caminos){
            double valor;
            valor = camino.getProbabilidad() / sumaVisibilidad;
            camino.setProbabilidad(valor);
        }
        Punto punto = obtenerCaminoRandom(caminos);
        return punto;
    }
    
    
    /**
     * 
     * @param caminos
     * @return 
     */
    public Punto obtenerCaminoRandom(ArrayList<Camino> caminos) {

        double probabilidadNueva;
        for (Camino camino : caminos) {
            
            // ya que la probabilidad es tan pequeña decidi multiplicarla por 10000000 para que sea mas facil de trabajar.
            probabilidadNueva = (camino.getProbabilidad() * 10000000);
            if (probabilidadNueva != 0) {
                for (int i = 0; i < probabilidadNueva; i++) {
                    valores.add(camino.getLlegada());
                }
            }
        }

        int tamano = valores.size();
        int numero = (int) Math.floor(Math.random() * (tamano));
        Punto punto = valores.get(numero);
        valores.clear();
        this.caminos.clear();
        return punto;
    }
    
    
    /**
     * 
     * @param lugaresVisitados
     * @return 
     */
    public double calcularCostoCamino(ArrayList<Punto> lugaresVisitados){
        double distancia = 0;
        for (int i = 0; (i+1) < lugaresVisitados.size(); i++) {
            int j = i+1;
            distancia += matrizDistancia[lugaresVisitados.get(i).nodo][lugaresVisitados.get(j).nodo];
        }
        return distancia;
    }

}
