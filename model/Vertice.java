package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 24/06/2015.
 */
public class Vertice implements Comparable<Vertice>{

    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> vizinhos = new ArrayList<Vertice>();

    private int indice;
    private double distancia;
    private double x;
    private double y;

    private boolean visitado = false;
    private Vertice pai;


    public void setIndice(int nome){

        this.indice = nome;
    }

    public int getIndice(){

        return indice;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void visitar (){

        this.visitado = true;
    }

    public boolean verVisita(){

        return visitado;
    }

    public void setDistancia(double distancia){

        this.distancia = distancia;
    }

    public double getDistancia(){

        return this.distancia;
    }

    public void setPai(Vertice pai){

        this.pai = pai;
    }

    public Vertice getPai(){

        return this.pai;
    }

    public List<Aresta> getArestas() {

        return arestas;
    }
    public void adicionaAresta(Aresta aresta){

        this.arestas.add(aresta);
    }

    @Override
    public int compareTo(Vertice vertice) {
        if(this.getDistancia() < vertice.getDistancia()) return -1;
        else if(this.getDistancia() == vertice.getDistancia()) return 0;

        return 1;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Vertice){
            Vertice vertice = (Vertice) object;
            if(this.getIndice() == (vertice.getIndice())) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String string = " ";
        string+= this.getIndice();
        return string;
    }
}
