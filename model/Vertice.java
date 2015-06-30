package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 24/06/2015.
 */
public class Vertice implements Comparable<Vertice>{

    private int indice;
    private double distancia;
    private double x;
    private double y;
    private boolean visitado = false;
    private Vertice pai;
    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> vizinhos = new ArrayList<Vertice>();

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

    public boolean verificarVisita(){

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

    public void setVizinhos(List<Vertice> vizinhos) {

        this.vizinhos.addAll(vizinhos);
    }

    public List<Vertice> getVizinhos(){

        return this.vizinhos;
    }

    public void setArestas(List <Aresta> arestas){

        this.arestas.addAll(arestas);
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
            Vertice vRef = (Vertice) object;
            if(this.getIndice() == (vRef.getIndice())) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = " ";
        s+= this.getIndice();
        return s;
    }
}
