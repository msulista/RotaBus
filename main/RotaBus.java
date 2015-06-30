package main;

import model.Dijkstra;
import model.Grafo;
import model.Vertice;
import util.Console;
import util.LerDoArquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 27/06/2015.
 */
public class RotaBus {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(); //Cria a estrutura do grafo
        Dijkstra dijkstra = new Dijkstra();
        List<Vertice> vertices;
        try {
           LerDoArquivo.lerArquivo(grafo); //Le o arquivo, cria os vertices e as arestas e sobe para o grafo
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Calcula o menor Caminho");
        int indice1 = Console.lerInt("Digite o Indice do Verice de origem: ");
        int indice2 = Console.lerInt("Digite o Indice do Vertice de destino: ");
        Vertice vertice1 = grafo.encontrarVertice(indice1);
        Vertice vertice2 = grafo.encontrarVertice(indice2);

        vertices = dijkstra.encontrarMenorCaminhoDijkstra(grafo, vertice1, vertice2);

        double distancia = 0;
        System.out.println("ROTA: ");
        for (Vertice v: vertices){
            System.out.println(v);
            distancia = (distancia + v.getDistancia());
        }
        System.out.printf("Distancia percorrida em metros: %.2f m\n", distancia);
        System.out.printf("Distancia percorrida em quilometros: %.2f km\n", distancia/1000);
    }
}
