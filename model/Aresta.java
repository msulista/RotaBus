package model;

/**
 * Created by marcus.rodrigues on 24/06/2015.
 */
public class Aresta {

    private double peso;
    private Vertice origem;
    private Vertice destino;

    public Aresta(Vertice v1, Vertice v2) {

        this.peso = 1; //seto o peso default
        this.origem = v1;
        this.destino = v2;
        calculaDistancia(v1, v2);

    }

    public void setPeso(double novoPeso) {//Deixo um set caso queira implementar pesos no futuro

        this.peso = novoPeso;
    }

    public double getPeso() {

        return peso;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void calculaDistancia(Vertice v1, Vertice v2){

        double distancia = Math.sqrt(Math.pow((v1.getX() - v2.getX()), 2) + Math.pow((v1.getY() - v2.getY()), 2));
        this.peso = distancia;
    }
}
