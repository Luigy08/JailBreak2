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
public class Lista {
    private NodoRecorrido head;

    public Lista() {
        head=null;
    }

    public NodoRecorrido getHead() {
        return head;
    }

    public void setHead(NodoRecorrido head) {
        this.head = head;
    }
    
    public void Insert(NodoActual valor){
        NodoRecorrido nuevo=new NodoRecorrido(valor,null);
        if (head==null) {
            head=nuevo;
        }else{
            NodoRecorrido tem=head;
            while(tem.getNext()!=null){
                tem=tem.getNext();
            }
            tem.setNext(nuevo);
        }
    }
    public NodoRecorrido pop(){
        NodoRecorrido tem=head;
        head=head.getNext();
        return tem;
    }
}
