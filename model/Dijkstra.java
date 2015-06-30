package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by marcus.rodrigues on 24/06/2015.
 */
public class Dijkstra {

    List<Vertice> menorCaminho = new ArrayList<Vertice>();   // Lista que guarda os vertices do menor caminho encontrado
    Vertice verticeCaminho = new Vertice();

    Vertice atual = new Vertice(); // Variavel que guarda o vertice que esta sendo visitado

    Vertice vizinho = new Vertice();// Variavel que marca o vizinho do vertice atualmente visitado

    List<Vertice> naoVisitados = new ArrayList<Vertice>();// Lista dos vertices que ainda nao foram visitados

    // Algoritmo de Dijkstra
    public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {

        menorCaminho.add(v1);// Adiciona a origem na lista do menor caminho

        for (int i = 0; i < grafo.getVertices().size(); i++) {// Colocando a distancias iniciais

            if (grafo.getVertices().get(i).getIndice() == (v1.getIndice())) {// Vertice atual tem distancia zero, e todos os outros, 9999("infinita")

                grafo.getVertices().get(i).setDistancia(0);
            } else {

                grafo.getVertices().get(i).setDistancia(9999);
            }
            this.naoVisitados.add(grafo.getVertices().get(i));
        }

        Collections.sort(naoVisitados);

        while (!this.naoVisitados.isEmpty()) {// O algoritmo continua ate que todos os vertices sejam visitados

            atual = this.naoVisitados.get(0);
           // System.out.println("Pegou esse vertice:  " + atual);

            for (int i = 0; i < atual.getArestas().size(); i++) {

                vizinho = atual.getArestas().get(i).getDestino();
               // System.out.println("Olhando o vizinho de " + atual + ": " + vizinho);
                if (!vizinho.verificarVisita()) {

                    if (vizinho.getDistancia() > (atual.getDistancia() + atual.getArestas().get(i).getPeso())) {

                        vizinho.setDistancia(atual.getDistancia() + atual.getArestas().get(i).getPeso());
                        vizinho.setPai(atual);

                        if (vizinho == v2) {
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while (verticeCaminho.getPai() != null) {

                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();
                            }
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }
            atual.visitar();
            this.naoVisitados.remove(atual);

            Collections.sort(naoVisitados);
           // System.out.println("Nao foram visitados ainda:"+naoVisitados);
        }
        return menorCaminho;
    }
}
