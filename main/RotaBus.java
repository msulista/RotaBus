package main;

import model.Aresta;
import model.CalculaRota;
import model.Grafo;
import model.Vertice;
import util.Console;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by marcus.rodrigues on 27/06/2015.
 */
public class RotaBus {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(); //Cria a estrutura do grafo
        CalculaRota calculaRota = new CalculaRota();
        List<Vertice> vertices;
        try {
           lerArquivo(grafo); //Le o arquivo, cria os vertices e as arestas e sobe para o grafo
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Calcula o menor Caminho");
        int indice1 = Console.lerInt("Digite o Indice do Verice de origem: ");
        int indice2 = Console.lerInt("Digite o Indice do Vertice de destino: ");
        Vertice vertice1 = grafo.buscaVertice(indice1);
        Vertice vertice2 = grafo.buscaVertice(indice2);

        vertices = calculaRota.encontrarMenorCaminhoDijkstra(grafo, vertice1, vertice2);

        double distancia = 0;
        System.out.println("ROTA: ");
        for (Vertice v: vertices){
            System.out.println(v);
            distancia = (distancia + v.getDistancia());
        }
        System.out.printf("Distancia percorrida em metros: %.2f m\n", distancia);
        System.out.printf("Distancia percorrida em quilometros: %.2f km\n", distancia/1000);
        System.out.println("\n");
    }

    //Metodos de leitura do arquivo e criação de arestas e vertices

    public static void lerArquivo(Grafo grafo) throws IOException {
        Scanner lerArquivo = new Scanner( new FileReader("C:\\Users\\marcus.rodrigues\\Desktop\\grafo.txt"));

        lerArquivo.next(); //Verifica String de Vertice
        while (lerArquivo.hasNextInt()){
            int indice = lerArquivo.nextInt();
            double x = lerArquivo.nextDouble();
            double y = lerArquivo.nextDouble();
            criaVertice(indice, x, y);

            grafo.addVertice(criaVertice(indice, x, y));
        }
        lerArquivo.next(); //Verifica String Aresta
        while (lerArquivo.hasNextInt()) {
            Vertice v1 = grafo.buscaVertice(lerArquivo.nextInt());
            Vertice v2 = grafo.buscaVertice(lerArquivo.nextInt());
            double peso = lerArquivo.nextDouble();
            v1.adicionaAresta(criaAresta(v1,v2));
        }
    }

    public static Vertice criaVertice(int indice, double x, double y){
        Vertice vertice = new Vertice();

        vertice.setIndice(indice);
        vertice.setX(x);
        vertice.setY(y);

        return vertice;
    }

    public static Aresta criaAresta(Vertice v1, Vertice v2){

        return new Aresta(v1, v2);
    }
}
