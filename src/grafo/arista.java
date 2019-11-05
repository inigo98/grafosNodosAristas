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
public class arista {
    private String NodoOrigin;
    private String NodoDestiny;
    public String getNodoOrigin(){
        return this.NodoOrigin;
    }
    public void SetNodoOrigin(String name){
        this.NodoOrigin = name;
    }
    public String getNodoDestiny(){
        return this.NodoDestiny;
    }
    public void SetNodoDestiny(String name){
        this.NodoDestiny = name;
    }
}
