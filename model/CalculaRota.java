package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by marcus.rodrigues on 24/06/2015.
 */
public class CalculaRota {

    List<Vertice> naoVisitados = new ArrayList<Vertice>();
    List<Vertice> rotaDoOnibus = new ArrayList<Vertice>();

    Vertice verticeCaminho = new Vertice();
    Vertice verticeVisitado = new Vertice();
    Vertice vizinho = new Vertice();


    public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice origem, Vertice destino) {

        rotaDoOnibus.add(origem); //Adiciono o Vertice de origem na lista da minha rota

        for (int i = 0; i < grafo.buscaListaDeVertices().size(); i++) {

            if (grafo.buscaListaDeVertices().get(i).getIndice() == (origem.getIndice())) {

                grafo.buscaListaDeVertices().get(i).setDistancia(0);
            } else {

                grafo.buscaListaDeVertices().get(i).setDistancia(9999);
            }
            this.naoVisitados.add(grafo.buscaListaDeVertices().get(i));
        }

        Collections.sort(naoVisitados);

        while (!this.naoVisitados.isEmpty()) {

            verticeVisitado = this.naoVisitados.get(0);
            for (int i = 0; i < verticeVisitado.getArestas().size(); i++) {

                vizinho = verticeVisitado.getArestas().get(i).getDestino();
                if (!vizinho.verVisita()) {
                    if (vizinho.getDistancia() > (verticeVisitado.getDistancia() + verticeVisitado.getArestas().get(i).getPeso())) { //(verticeVisitado.getDistancia() + verticeVisitado.getArestas().get(i).getPeso())

                        vizinho.setDistancia(verticeVisitado.getDistancia() + verticeVisitado.getArestas().get(i).getPeso());
                        vizinho.setPai(verticeVisitado);
                        if (vizinho == destino) {
                            rotaDoOnibus.clear();
                            verticeCaminho = vizinho;
                            rotaDoOnibus.add(vizinho);
                            while (verticeCaminho.getPai() != null) {

                                rotaDoOnibus.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();
                            }
                            Collections.sort(rotaDoOnibus);
                        }
                    }
                }
            }
            verticeVisitado.visitar();
            this.naoVisitados.remove(verticeVisitado);
            Collections.sort(naoVisitados);
        }
        return rotaDoOnibus;
    }
}
