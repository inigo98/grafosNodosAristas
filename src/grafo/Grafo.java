/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author navarret
 */
public class Grafo extends JFrame implements ActionListener{
    
    JButton vincular, desvincular, save, erase;    
    JComboBox comboOrigin, comboDestiny, comboErase;
    JTextArea text, error, variables, nodo, nodo1;
    JScrollPane scroll;
    JScrollPane scrollText, scrollError, scrollVariables;
    JLabel label, vars;
    ArrayList<nodo> nodos = new ArrayList();
    ArrayList<arista> aristas = new ArrayList();    
    ArrayList<arista> aristasTemp = new ArrayList();
    String nodoText = "", aristaText = "";
    public Grafo() {
        this.setBounds(0, 0, 1370, 800);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        nodo = new JTextArea();
        nodo.setName("NODO");
        nodo.setText("");
        nodo.setEditable(true);
        nodo.setBounds(25, 25, 160, 25);
        nodo.setVisible(true);
        this.add(nodo);
        save = new JButton();
        save.setName("SAVE");
        save.setText("AGREGAR NODO");
        save.setBounds(250, 25, 150, 25);
        save.setVisible(true);
        save.addActionListener(this);
        this.add(save);
        comboOrigin = new JComboBox();
        comboOrigin.setName("comboOrigin");
        comboOrigin.setBounds(25, 60, 75, 25);
        comboOrigin.setVisible(true);
        comboOrigin.addActionListener(this);
        this.add(comboOrigin);
        comboDestiny = new JComboBox();
        comboDestiny.setName("comboDestiny");
        comboDestiny.setBounds(110, 60, 75, 25);
        comboDestiny.setVisible(true);
        comboDestiny.addActionListener(this);
        this.add(comboDestiny);
        erase = new JButton();
        erase.setName("Erase");
        erase.setText("Borrar Nodo");
        erase.setBounds(550, 25, 150, 25);
        erase.setVisible(true);
        erase.addActionListener(this);
        this.add(erase);
        comboErase = new JComboBox();
        comboErase.setName("comboErase");
        comboErase.setBounds(450, 25, 75, 25);
        comboErase.setVisible(true);
        comboErase.addActionListener(this);
        this.add(comboErase);
        vincular = new JButton();
        vincular.setName("Vincular");
        vincular.setText("Vincular");
        vincular.setBounds(250, 60, 150, 25);
        vincular.setVisible(true);
        vincular.addActionListener(this);
        this.add(vincular);
        desvincular = new JButton();
        desvincular.setName("Desvincular");
        desvincular.setText("Desvincular");
        desvincular.setBounds(410, 60, 150, 25);
        desvincular.setVisible(true);
        desvincular.addActionListener(this);
        this.add(desvincular);
        label = new JLabel();
        label.setName("Aristas");
        label.setText("Aristas");
        label.setBounds(1070, 25, 500, 25);
        label.setVisible(true);
        this.add(label);
        vars = new JLabel();
        vars.setName("Nodos");
        vars.setText("Nodos");
        vars.setBounds(1250, 25, 100, 25);
        vars.setVisible(true);
        this.add(vars);
        text = new JTextArea();
        text.setName("Aristas");
        text.setText("");
        text.setEditable(false);
        text.setBounds(1020, 60, 150, 615);
        text.setVisible(true);
        this.add(text);
        variables = new JTextArea();
        variables.setName("Nodos");
        variables.setText("");
        variables.setEditable(false);
        variables.setBounds(1190, 60, 150, 615);
        variables.setVisible(true);
        this.add(variables);
        scrollText = new JScrollPane(text);
        scrollText.setBounds(1020, 60, 150, 615);
        this.add(scrollText);
        scrollVariables = new JScrollPane(variables);
        scrollVariables.setBounds(1190, 60, 150, 615);
        this.add(scrollVariables);
    }
    
    public void paint(Graphics g) {
        if(this.nodos.size() > 0){
            super.paint(g);
            for(nodo nodo: this.nodos){
                Graphics2D circulo = (Graphics2D) g;
                circulo.setStroke(new BasicStroke(5.f)); //ancho de linea
                circulo.setPaint(Color.black); //color de contorno
                circulo.fillOval((int)nodo.getX(), (int)nodo.getY(), 25, 25);
                Graphics2D string = (Graphics2D) g;
                string.setPaint(Color.RED); //color de contorno
                string.drawString(nodo.getNodoName(), (int)nodo.getX(), (int)nodo.getY());
            }
            for(arista arista: this.aristas){
                if(arista.getNodoDestiny().equals(arista.getNodoOrigin())){
                    double x = this.searchX(arista.getNodoOrigin());
                    double y = this.searchY(arista.getNodoOrigin());
                    Graphics2D arc = (Graphics2D) g;
                    arc.setStroke(new BasicStroke(5.f)); //ancho de linea
                    arc.setPaint(Color.black); //color de contorno
                    arc.drawArc((int)x + 10, (int)y + 10, 30, 30, 0, 360);
                } else {
                    double xDestiny = this.searchX(arista.getNodoDestiny());
                    double yDestiny = this.searchY(arista.getNodoDestiny());
                    double xOrigin = this.searchX(arista.getNodoOrigin());
                    double yOrigin = this.searchY(arista.getNodoOrigin());
                    Graphics2D lin = (Graphics2D) g;
                    lin.setStroke(new BasicStroke(5.f)); //ancho de linea
                    lin.setPaint(Color.black); //color de contorno
                    lin.drawLine((int)xOrigin + 10, (int)yOrigin + 10, (int)xDestiny + 10, (int)yDestiny + 10);
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Grafo().show();
    }

    public void updateNodoText(){
        this.nodoText = "";
        for(nodo nodoText: this.nodos){
            this.nodoText = this.nodoText + '\n' + nodoText.getNodoName().toString() + "(" + String.valueOf(nodoText.getX()) + " , " + String.valueOf(nodoText.getY()) + ")";
        }
        this.variables.setText(this.nodoText);
    }
    
    public void updateAristaText(){
        this.aristaText = "";
        for(arista arista: this.aristas){
            this.aristaText = this.aristaText + '\n' + arista.getNodoOrigin().toString() + " -> " + arista.getNodoDestiny().toString();
        }
        this.text.setText(this.aristaText);
    }
    
    public void calculate(){
            int angle = 360 / this.nodos.size();
            this.moreThanFive(250, angle, this.nodos.size());
        repaint();
    }
    
    public void moreThanFive(int hipotenus, int angle, int iterations){
        int angleTemp = 0;
        for(int i = 0; i < iterations; i++){
            angleTemp = angleTemp + angle;
            if(angleTemp <= 90){
            System.out.println("90 - " + angleTemp);
                this.firstCuadrant(hipotenus, angleTemp, i);
            }
            if(angleTemp > 90 && angleTemp <= 180){
            System.out.println("90 - 180" + angleTemp);
                this.secondCuadrant(hipotenus, angleTemp, i);
            }
            if(angleTemp > 180 && angleTemp <= 270){
            System.out.println("180 - 270" + angleTemp);
                this.thirdCuadrant(hipotenus, angleTemp, i);
            }
            if(angleTemp > 270){
            System.out.println("270 - 360" + angleTemp);
                this.fourthCuadrant(hipotenus, angleTemp, i);
            }
        }
    }
    
    public void firstCuadrant(int hipotenus, int angle, int iterations){
        double angles = Math.toRadians(angle);
        double x = ( 500 + ( (hipotenus) * ( Math.cos(angles) ) ) );        
        double y = ( 500 - ( (hipotenus) * ( Math.sin(angles) ) ) );
        this.nodos.get(iterations).SetX(x);
        this.nodos.get(iterations).SetY(y);
    }
    public void secondCuadrant(int hipotenus, int angle, int iterations){
        angle = 180 - angle;
        double angles = Math.toRadians(angle);
        double x = ( 500 - ( (hipotenus) * ( Math.cos(angles) ) ) );        
        double y = ( 500 - ( (hipotenus) * ( Math.sin(angles) ) ) );
        this.nodos.get(iterations).SetX(x);
        this.nodos.get(iterations).SetY(y);
    }
    public void thirdCuadrant(int hipotenus, int angle, int iterations){
        angle = angle - 180;
        double angles = Math.toRadians(angle);
        double x = ( 500 - ( (hipotenus) * ( Math.cos(angles) ) ) );        
        double y = ( 500 + ( (hipotenus) * ( Math.sin(angles) ) ) );
        this.nodos.get(iterations).SetX(x);
        this.nodos.get(iterations).SetY(y);
    }
    public void fourthCuadrant(int hipotenus, int angle, int iterations){
        angle = 360 - angle;
        double angles = Math.toRadians(angle);
        double x = ( 500 + ( (hipotenus) * ( Math.cos(angles) ) ) );        
        double y = ( 500 + ( (hipotenus) * ( Math.sin(angles) ) ) );
        this.nodos.get(iterations).SetX(x);
        this.nodos.get(iterations).SetY(y);
    }
    
    public double searchX(String nodoText){
        for(nodo nodo: this.nodos){
            if(nodo.getNodoName().equals(nodoText)){
                return nodo.getX();
            }
        }
        return 0;
    }
    
    public double searchY(String nodoText){
        for(nodo nodo: this.nodos){
            if(nodo.getNodoName().equals(nodoText)){
                return nodo.getY();
            }
        }
        return 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            int cont = 0;
            for (nodo nodo : this.nodos) 
            { 
                if(nodo.getNodoName().equals(this.nodo.getText())){
                    cont++;
                }
            }
            if(cont == 0){
                this.comboDestiny.addItem(this.nodo.getText());  
                this.comboOrigin.addItem(this.nodo.getText());            
                this.comboErase.addItem(this.nodo.getText());
                nodo nodo = new nodo();
                nodo.SetNodoName(this.nodo.getText());
                this.nodos.add(nodo);
                this.calculate();
                this.updateNodoText();
            } else {
                System.out.print("ya esta registrado");
            }
            this.nodo.setText("");
        }
        if(e.getSource() == erase){
            if(this.nodos.size() > 0){
                nodo tempNodoErase = null;
                this.aristasTemp.clear();
                String erased = this.comboErase.getSelectedItem().toString();
                for (nodo nodo : this.nodos) 
                { 
                    if(nodo.getNodoName().equals(this.comboErase.getSelectedItem().toString())){
                        tempNodoErase = nodo;
                    }
                }
                this.nodos.remove(tempNodoErase);
                this.comboDestiny.removeAllItems();
                this.comboOrigin.removeAllItems();
                this.comboErase.removeAllItems();
                for (nodo nodoNew : this.nodos) 
                { 
                    this.comboDestiny.addItem(nodoNew.getNodoName().toString());  
                    this.comboOrigin.addItem(nodoNew.getNodoName().toString());            
                    this.comboErase.addItem(nodoNew.getNodoName().toString());
                }
                if(this.aristas.size() > 0){
                    for(arista arista: this.aristas){
                        System.out.println( arista.getNodoOrigin() + arista.getNodoDestiny() );
                        if( (arista.getNodoOrigin().equals(erased)) || (arista.getNodoDestiny().equals(erased)) ){
                            System.out.println("la borrada" + erased);
                        } else {
                            this.aristasTemp.add(arista);
                        }
                    }
                    this.aristas.clear();
                    System.out.print(this.aristas.size());
                    for(arista arista: this.aristasTemp){
                        this.aristas.add(arista);
                    }
                    System.out.print(this.aristas.size());
                    this.updateAristaText();
                }
                this.calculate();
                this.updateNodoText();
            } else {
                System.out.print("no hay nodos");
            }
        }
        if(e.getSource() == vincular){
            if(this.nodos.size() > 0){
                int cont = 0;
                for(arista arista: this.aristas){
                    if( (arista.getNodoOrigin().equals(this.comboOrigin.getSelectedItem().toString())) && (arista.getNodoDestiny().equals(this.comboDestiny.getSelectedItem().toString())) ){
                        cont++;
                    }
                }
                if(cont == 0){
                    arista arista = new arista();
                    arista.SetNodoOrigin(this.comboOrigin.getSelectedItem().toString());
                    arista.SetNodoDestiny(this.comboDestiny.getSelectedItem().toString());
                    this.aristas.add(arista);
                } else {
                    System.out.print("arista ya vinculada");
                }
                this.updateAristaText();
                repaint();
            } else {
                System.out.print("no hay nodos");
            }
        }
        if(e.getSource() == desvincular){
            if( (this.nodos.size() > 0) && (this.aristas.size() > 0)){
                arista aristaErase = null;
                for(arista arista: this.aristas){
                    if( (arista.getNodoOrigin().equals(this.comboOrigin.getSelectedItem().toString())) && (arista.getNodoDestiny().equals(this.comboDestiny.getSelectedItem().toString())) ){
                        aristaErase = arista;
                    }
                }
                this.aristas.remove(aristaErase);
                this.updateAristaText();
                repaint();
            } else {
                System.out.print("no hay nodos o aristas");
            }
        }
    }
    
}
