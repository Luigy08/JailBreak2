/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import Estructuras.Arbol;
import Estructuras.Nodo;
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
                    entradaSalida=2;
                    actual.setVisitado(true);
                }else if(entradaSalida==2){
                    arbol.setUltimaHoja(matriz[datos.getFila()][datos.getColumna()]);
                    matriz[datos.getFila()][datos.getColumna()].setValor("X");
                    actual.setValor("X");
                    entradaSalida=3;
                    actual.setVisitado(true);
                }else if (entradaSalida ==3) {
                    if (actual.isVisitado()) {
                        actual.setValor("#");
                        actual.setVisitado(true);
                    }
                }
            } else {
                int tem = rnd.nextInt(3);

                if (entradaSalida == 3) {

                    if (tem == 0) {
                        actual.setValor("#");
                    } else {
                        actual.setValor("-");
                    }
                    actual.setVisitado(true);
                } else {
                    actual.setVisitado(true);
                    actual.setValor("A");
                }

            }
            /*for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print("["+matriz[i][j].getValor()+"]");
                }
                System.out.println("");
            }*/
            switch (datos.getTipoNodo()) {
                case "nodo00":
                    if (matriz[datos.getFila()][datos.getColumna() + 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodo0n":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodon0":
                    if (matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodonn":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodo0j":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodoi0":
                    if (matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodonj":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila()][datos.getColumna() + 1].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodoin":
                    if (matriz[datos.getFila()][datos.getColumna() - 1].isVisitado() && matriz[datos.getFila() - 1][datos.getColumna()].isVisitado() && matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                        actual = actual.getAnterior();
                        continue;
                    }
                    break;
                case "nodonormal":
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
                    actual.setIzquierdo(matriz[datos.getFila()][datos.getColumna() - 1]);
                    Nodo anterior = actual;
                    actual = actual.getIzquierdo();
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
                    actual.setDerecho(matriz[datos.getFila()][datos.getColumna() + 1]);
                    Nodo anterior = actual;
                    actual = actual.getDerecho();
                    actual.setAnterior(anterior);
                    actual.setVisitado(true);
                    visitados++;
                }
            } else if (datos.getSiguienteNodo() == 3) {
                if (matriz[datos.getFila() + 1][datos.getColumna()].isVisitado()) {
                    continue;
                } else {
                    //System.out.println("Enlazar hacia abajo con: "+(datos.getFila()+1)+","+datos.getColumna()+" Nodo:"+matNodos[datos.getFila()+1][datos.getColumna()]);
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
            datos.setTipoNodo("nodo00");
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
            datos.setTipoNodo("nodo0n");
            datos.setFila(0);
            datos.setColumna(size - 1);
            return datos;
        } else if (actual == matriz[size - 1][0]) {
            datos.setSiguienteNodo(rnd.nextInt(2) + 1);
            datos.setTipoNodo("nodon0");
            datos.setFila(size - 1);
            datos.setColumna(0);
            return datos;
        } else if (actual == matriz[size - 1][size - 1]) {
            datos.setSiguienteNodo(rnd.nextInt(2));
            datos.setTipoNodo("nodonn");
            datos.setFila(size - 1);
            datos.setColumna(size - 1);
            return datos;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (actual == matriz[0][j]) {
                    int num = rnd.nextInt(3);
                    if (num == 0) {
                        datos.setSiguienteNodo(0);
                    }
                    if (num == 1) {
                        datos.setSiguienteNodo(2);
                    }
                    if (num == 2) {
                        datos.setSiguienteNodo(3);
                    }
                    datos.setTipoNodo("nodo0j");
                    datos.setFila(0);
                    datos.setColumna(j);
                    return datos;
                } else if (actual == matriz[i][0]) {
                    datos.setSiguienteNodo(rnd.nextInt(3) + 1);
                    datos.setTipoNodo("nodoi0");
                    datos.setFila(i);
                    datos.setColumna(0);
                    return datos;
                } else if (actual == matriz[i][size - 1]) {
                    int num = rnd.nextInt(3);
                    if (num == 0) {
                        datos.setSiguienteNodo(1);
                    }
                    if (num == 1) {
                        datos.setSiguienteNodo(0);
                    }
                    if (num == 2) {
                        datos.setSiguienteNodo(3);
                    }
                    datos.setTipoNodo("nodoin");
                    datos.setFila(i);
                    datos.setColumna(size - 1);
                    return datos;
                } else if (actual == matriz[size - 1][j]) {
                    datos.setSiguienteNodo(rnd.nextInt(3));
                    datos.setTipoNodo("nodonj");
                    datos.setFila(size - 1);
                    datos.setColumna(j);
                    return datos;
                } else if (actual == matriz[i][j]) {
                    datos.setSiguienteNodo(rnd.nextInt(4));
                    datos.setTipoNodo("nodonormal");
                    datos.setFila(i);
                    datos.setColumna(j);
                    return datos;
                }
            }
        }
        return datos;
    }

}