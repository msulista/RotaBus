package test;

import model.Aresta;
import model.Grafo;
import model.Vertice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by marcus.rodrigues on 28/06/2015.
 */
public class Teste {
    public static void main(String[] args) {

        try {
            lerArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void lerArquivo() throws IOException {
        Grafo grafo = new Grafo();
        String[] rotas = new String[196992];
        Vertice[] vertices = new Vertice[13629];
        Aresta[] arestas = new Aresta[183363];
        Scanner lerArquivo = new Scanner( new FileReader("C:\\Users\\marcus.rodrigues\\Desktop\\grafo.txt"));

        lerArquivo.next(); //Verifica String de Vertice
        while (lerArquivo.hasNextInt()){
                int indice = lerArquivo.nextInt();
                double x = lerArquivo.nextDouble();
                double y = lerArquivo.nextDouble();
                criaVertice(indice, x, y);

                grafo.adicionarVertice(criaVertice(indice, x, y));
        }
        lerArquivo.next(); //Verifica String Aresta
        while (lerArquivo.hasNextInt()) {
            Vertice v1 = grafo.encontrarVertice(lerArquivo.nextInt());
            Vertice v2 = grafo.encontrarVertice(lerArquivo.nextInt());
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
