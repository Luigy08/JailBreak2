/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import recursos.NodoActual;

/**
 *
 * @author luigy
 */
public class NodoRecorrido {
    private NodoActual datos;
    private NodoRecorrido next;

    public NodoRecorrido(NodoActual datos, NodoRecorrido next) {
        this.datos = datos;
        this.next = next;
    }
    
    public NodoRecorrido() {
    }

    public NodoRecorrido getNext() {
        return next;
    }

    public void setNext(NodoRecorrido next) {
        this.next = next;
    }

    public NodoActual getDatos() {
        return datos;
    }

    public void setDatos(NodoActual datos) {
        this.datos = datos;
    }
    
}
