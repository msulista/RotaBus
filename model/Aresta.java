package model;

/**
 * Created by marcus.rodrigues on 24/06/2015.
 */
public class Aresta {

    private double peso;
    private Vertice origem;
    private Vertice destino;

    public Aresta(Vertice v1, Vertice v2) {

        this.peso = 0; //seto o peso default
        this.origem = v1;
        this.destino = v2;
        calculaDistancia(v1, v2);
    }

    public double getPeso() {

        return peso;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void calculaDistancia(Vertice v1, Vertice v2){ //Calcula a distancia dos vertices no plano carteziano

        double distancia = Math.sqrt(Math.pow((v2.getX() - v1.getX()), 2) + Math.pow((v2.getY() - v1.getY()), 2));
        this.peso = distancia;
    }
}
