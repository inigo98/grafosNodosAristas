/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author navarret
 */
public class nodo {
    private String NodoName;
    private double x;
    private double y;

    public String getNodoName(){
        return this.NodoName;
    }
    public void SetNodoName(String name){
        this.NodoName = name;
    }
    public double getX(){
        return this.x;
    }
    public void SetX(double x){
        this.x = x;
    }
    public double getY(){
        return this.y;
    }
    public void SetY(double y){
        this.y = y;
    }
}
