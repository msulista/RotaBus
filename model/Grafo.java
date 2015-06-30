package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 21/06/2015.
 */
public class Grafo {

    private List<Vertice> grafo = new ArrayList<Vertice>();

    public void setVertices(List<Vertice> vertices) {

        this.grafo.addAll(vertices);
    }

    public void adicionarVertice(Vertice novoVertice) {

        this.grafo.add(novoVertice);
    }

    public List<Vertice> getVertices() {

        return this.grafo;
    }

    public Vertice encontrarVertice(int indice) {// Método que retorna o vértice cuja indice é igual à procurada.

        for (int i = 0; i < this.getVertices().size(); i++) {

            if (indice == this.getVertices().get(i).getIndice()) {

                return this.getVertices().get(i);
            }
        }
        return null;
    }
}
