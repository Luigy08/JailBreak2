/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Usuario
 */
public class Nodo {
    private boolean visitado;
    private String valor;
    private Nodo Arriba;
    private Nodo Abajo;
    private Nodo Izquierda;
    private Nodo Derecha;
    private Nodo anterior;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Nodo(){
        visitado=false;
        Arriba=null;
        Abajo=null;
        Izquierda=null;
        Derecha=null;
        anterior=null;
        valor=" ";
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Nodo getArriba() {
        return Arriba;
    }

    public void setArriba(Nodo Arriba) {
        this.Arriba = Arriba;
    }

    public Nodo getAbajo() {
        return Abajo;
    }

    public void setAbajo(Nodo Abajo) {
        this.Abajo = Abajo;
    }

    public Nodo getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(Nodo Izquierdo) {
        this.Izquierda = Izquierdo;
    }

    public Nodo getDerecha() {
        return Derecha;
    }

    public void setDerecha(Nodo Derecho) {
        this.Derecha = Derecho;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    
    
}
