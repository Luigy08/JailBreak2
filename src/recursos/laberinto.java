/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import Estructuras.Arbol;
import Estructuras.Nodo;
import Estructuras.NodoRecorrido;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author luigy
 */
public class laberinto {

    private int size;
    private Nodo[][] matriz;
    private Arbol arbol;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Nodo[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Nodo[][] matriz) {
        this.matriz = matriz;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public laberinto() {
        size = 40;
        matriz = new Nodo[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = new Nodo();
            }
        }
        this.arbol = new Arbol(matriz[0][0]);
    }

    public void generarLaberinto() {
        Random rnd = new Random();
        int lado = rnd.nextInt(4);
        int fila = 0, columna = 0;
        if (lado == 0) {
            columna = 0;
            fila = rnd.nextInt(size);
        } else if (lado == 1) {
            fila = 0;
            columna = rnd.nextInt(size);
        } else if (lado == 2) {
            fila = rnd.nextInt(size);
            columna = size - 1;
        } else if (lado == 3) {
            fila = size - 1;
            columna = rnd.nextInt(size);
        }
        Nodo actual = matriz[fila][columna];
        this.arbol.setRaiz(actual);
        int visitados = 1;
        NodoActual datos;
        actual.setVisitado(true);
        int entradaSalida = 1;
        while (visitados != size * size) {
            datos = Datos(actual);
            if (datos.getFila() == 0 && datos.getColumna() < size || datos.getFila() < size && datos.getColumna() == 0 || datos.getFila() == size - 1 && datos.getColumna() < size || datos.getFila() < size && datos.getColumna() == size - 1) {
                if (entradaSalida < 2) {
                    actual.setValor("O");
                    entradaSalida++;
                } else if (entradaSalida == 2) {
                    actual.setValor("X");
                    arbol.setUltimaHoja(matriz[datos.getFila()][datos.getColumna()]);
                    entradaSalida = 3;
                }
                if (entradaSalida == 3) {
                    if (actual.getValor().equals(" ")) {
                        actual.setValor("#");

                    }
                }
            } else {
                int tem = rnd.nextInt(2);

                if (entradaSalida == 3 && !actual.getValor().equals("#") && !actual.getValor().equals("-") && !actual.getValor().equals("A")) {

                    if (tem == 0) {
                        actual.setValor("#");
                    } else {
                        actual.setValor("-");
                    }

                } else if (!actual.getValor().equals("#") && !actual.getValor().equals("-") && !actual.getValor().equals("A")) {
                    actual.setValor("A");
                }

            }
            switch (datos.getTipoNodo()) {
                case "ezquina1":
                    if (matriz[datos.getFila()][datos.getColumna() + 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "ezquina2":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "ezquina3":
                    if (matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "ezquina4":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "HSuperior":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "VIzquierda":
                    if (matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "HInferior":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "VDerecha":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "Centro":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
            }
            if (datos.getSiguienteNodo() == 0) {
                if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado()) {
                    continue;
                } else {
                    actual.setIzquierda(matriz[datos.getFila()][datos.getColumna() - 1]);
                    Nodo anterior = actual;
                    actual = actual.getIzquierda();
                    actual.setAnterior(anterior);
                    actual.setVisitado(true);
                    visitados++;
                }
            } else if (datos.getSiguienteNodo() == 1) {
                if (matriz[datos.getFila() - 1][datos.getColumna()].isVisitado()) {
                    continue;
                } else {
                    actual.setArriba(matriz[datos.getFila() - 1][datos.getColumna()]);
                    Nodo anterior = actual;
                    actual = actual.getArriba();
                    actual.setAnterior(anterior);
                    actual.setVisitado(true);
                    visitados++;
                }
            } else if (datos.getSiguienteNodo() == 2) {
                if (matriz[datos.getFila()][datos.getColumna() + 1].isVisitado()) {
                    continue;
                } else {
                    actual.setDerecha(matriz[datos.getFila()][datos.getColumna() + 1]);
                    Nodo anterior = actual;
                    actual = actual.getDerecha();
                    actual.setAnterior(anterior);
                    actual.setVisitado(true);
                    visitados++;
                }
            } else if (datos.getSiguienteNodo() == 3) {
                if (matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                    continue;
                } else {
                    actual.setAbajo(matriz[datos.getFila() + 1][datos.getColumna()]);
                    Nodo anterior = actual;
                    actual = actual.getAbajo();
                    actual.setAnterior(anterior);
                    actual.setVisitado(true);
                    visitados++;
                }
            }
        }

    }

    public NodoActual Datos(Nodo actual) {
        Random rnd = new Random();
        NodoActual datos = new NodoActual();
        if (actual == matriz[0][0]) {
            datos.setTipoNodo("ezquina1");
            datos.setSiguienteNodo(rnd.nextInt(2) + 2);
            datos.setFila(0);
            datos.setColumna(0);
            return datos;
        } else if (actual == matriz[0][size - 1]) {
            int num = rnd.nextInt(2);
            if (num == 0) {
                datos.setSiguienteNodo(0);
            }
            if (num == 1) {
                datos.setSiguienteNodo(3);
            }
            datos.setTipoNodo("ezquina2");
            datos.setFila(0);
            datos.setColumna(size - 1);
            return datos;
        } else if (actual == matriz[size - 1][0]) {
            datos.setSiguienteNodo(rnd.nextInt(2) + 1);
            datos.setTipoNodo("ezquina3");
            datos.setFila(size - 1);
            datos.setColumna(0);
            return datos;
        } else if (actual == matriz[size - 1][size - 1]) {
            datos.setSiguienteNodo(rnd.nextInt(2));
            datos.setTipoNodo("ezquina4");
            datos.setFila(size - 1);
            datos.setColumna(size - 1);
            return datos;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (actual == matriz[0][j]) {
                    int num = rnd.nextInt(20);
                    if (num < 2) {
                        if (num == 0) {
                            datos.setSiguienteNodo(0);
                        }
                        if (num == 1) {
                            datos.setSiguienteNodo(2);
                        }
                    }

                    if (num >=2) {
                        datos.setSiguienteNodo(3);
                    }

                    datos.setTipoNodo("HSuperior");
                    datos.setFila(0);
                    datos.setColumna(j);
                    return datos;
                } else if (actual == matriz[i][0]) {
                    int num = rnd.nextInt(20);
                    if (num < 2) {
                        if (num == 0) {
                            datos.setSiguienteNodo(1);
                        }
                        if (num == 1) {
                            datos.setSiguienteNodo(3);
                        }
                    }
                    if (num >=2) {
                        datos.setSiguienteNodo(2);
                    }
                    datos.setTipoNodo("VIzquierda");
                    datos.setFila(i);
                    datos.setColumna(0);
                    return datos;
                } else if (actual == matriz[i][size - 1]) {
                    int num = rnd.nextInt(20);
                    if (num < 2) {
                        if (num == 0) {
                            datos.setSiguienteNodo(1);
                        }
                        if (num == 1) {
                            datos.setSiguienteNodo(3);
                        }
                    }
                    if (num >=2) {
                        datos.setSiguienteNodo(0);
                    }
                    datos.setTipoNodo("VDerecha");
                    datos.setFila(i);
                    datos.setColumna(size - 1);
                    return datos;
                } else if (actual == matriz[size - 1][j]) {
                    int num = rnd.nextInt(20);
                    if (num < 2) {
                        if (num == 0) {
                            datos.setSiguienteNodo(0);
                        }
                        if (num == 1) {
                            datos.setSiguienteNodo(2);
                        }
                    }

                    if (num >=2) {
                        datos.setSiguienteNodo(1);
                    }
                    datos.setTipoNodo("HInferior");
                    datos.setFila(size - 1);
                    datos.setColumna(j);
                    return datos;
                } else if (actual == matriz[i][j]) {
                    datos.setSiguienteNodo(rnd.nextInt(4));
                    datos.setTipoNodo("Centro");
                    datos.setFila(i);
                    datos.setColumna(j);
                    return datos;
                }
            }
        }
        return datos;
    }
    public void analisis(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!matriz[i][j].getValor().equals("#")||!matriz[i][j].getValor().equals(" ")) {
                    matriz[i][j].setVisitado(false);
                }
            }
        }
        Nodo actual=arbol.getRaiz();
        NodoActual datos;
        ArrayList<ArrayList> recorridos=new ArrayList();
        ArrayList<NodoActual> recorrido=new ArrayList();
        boolean encontrado=true;
        
        while(encontrado){
            datos=Datos(actual);
            actual.setVisitado(true);
            if (!actual.getArriba().isVisitado()) {
                actual=actual.getArriba();
                recorrido.add(datos);
            }else if (!actual.getDerecha().isVisitado()) {
                actual=actual.getDerecha();
                recorrido.add(datos);
            }else if (!actual.getAbajo().isVisitado()) {
                actual=actual.getAbajo();
                recorrido.add(datos);
            }else if (!actual.getIzquierda().isVisitado()) {
                actual=actual.getIzquierda();
                recorrido.add(datos);
            }
            if (actual.getArriba().isVisitado()&&actual.getAbajo().isVisitado()&&actual.getDerecha().isVisitado()&&actual.getIzquierda().isVisitado()) {
                actual=actual.getAnterior();
                recorridos.add(recorrido);
                recorrido.clear();
            }
            if (actual.getValor().equals("X")) {
                recorrido.add(datos);
                encontrado=false;
            }
            
        }
        ArrayList<ArrayList> soluciones=new ArrayList();
        for (int i = 0; i < recorridos.size(); i++) {
            for (int j = 0; j < recorridos.get(i).size(); j++) {
                NodoActual dato=((NodoActual)((ArrayList)recorridos.get(i).get(j)).get(((ArrayList)recorridos.get(i).get(j)).size()-1));
                Nodo tem=matriz[dato.getFila()][dato.getColumna()];
                if (tem.getValor().equals("")) {
                    soluciones.add((ArrayList)recorridos.get(i).get(j));
                }
            }
        }
        ArrayList <ArrayList>solucion=new ArrayList(); 
        int tem=0;
        for (int i = 0; i < soluciones.size(); i++) {
            if (soluciones.get(i).size()>tem) {
                tem=i;
            }
        }
        for (int i = 0; i < solucion.get(tem).size(); i++) {
            
        }
    }

}
