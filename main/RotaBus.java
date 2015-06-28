package main;

import model.Dijkstra;
import model.Grafo;
import model.Vertice;
import util.LerDoArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 27/06/2015.
 */
public class RotaBus {
    public static void main(String[] args) {

        Grafo teste = new Grafo();
        LerDoArquivo lerDoArquivo = new LerDoArquivo();

        teste.setVertices(lerDoArquivo.lerGrafo(args[0]));
        Vertice i1 = new Vertice();
        Vertice i2 = new Vertice();
        i1 = teste.encontrarVertice(args[1]);
        i2 = teste.encontrarVertice(args[2]);

        List<Vertice> resultado = new ArrayList<Vertice>();
        Dijkstra algoritmo = new Dijkstra();
        resultado = algoritmo.encontrarMenorCaminhoDijkstra(teste, i1, i2);

        System.out.println("Esse é o menor caminho feito pelo algoritmo:"
                + resultado);
    }
}
