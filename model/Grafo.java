package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 21/06/2015.
 */
public class Grafo {

    private List<Vertice> grafo = new ArrayList<Vertice>();

    public void addVertice(Vertice novoVertice) { //Adiciona um novo vertice no grafo

        this.grafo.add(novoVertice);
    }

    public List<Vertice> buscaListaDeVertices() { //Busca uma lista de vertices

        return this.grafo;
    }

    public Vertice buscaVertice(int indice) {// Busca o vertice indicando o indice.

        for (int i = 0; i < this.buscaListaDeVertices().size(); i++) {

            if (indice == this.buscaListaDeVertices().get(i).getIndice()) {

                return this.buscaListaDeVertices().get(i);
            }
        }
        return null;
    }
}
