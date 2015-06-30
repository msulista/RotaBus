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
/*
public static List<Vertice> lerGrafo(String teste) { //Metodo para ler o arquivo utilizando o File eu posso passar o nome do
                                                        //arquivo como parametro String se estiver na pasta do  projeto
        Grafo grafo = new Grafo();
        Vertice vertice;
        File file = new File(teste);
        String vertices[];
        String linha;
        ArrayList<String[]> listaStrings = new ArrayList<String[]>();

        try {//le o arquivo
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            Map<String, Vertice> mapa = new HashMap<String, Vertice>();

            while ((linha = bufferedReader.readLine()) != null) {//le as linhas

                if (linha.contains(",")) {
                    listaStrings.add(linha.split(" "));
                    vertices = listaStrings.get(0)[0].split(",");

                    vertice = (Vertice) mapa.get(vertices[0]);
                    if (vertice == null)
                        vertice = new Vertice();

                    List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
                    List<Aresta> arestasAtual = new ArrayList<Aresta>();
                  //  vertice.setIndice(vertices[0]);
                    mapa.put(vertices[0], vertice);

                    if (linha.contains(" ")) {

                        String pesoArestas[] = listaStrings.get(0)[1].split(",");

                        for (int i = 1; i < vertices.length; i++) {
                            Vertice vit;
                            // vit = grafo.encontrarVertice(vertices[i]);
                            vit = mapa.get(vertices[i]);
                            if (vit == null)
                                vit = new Vertice();
                           // vit.setIndice(vertices[i]);
                            vizinhosAtual.add(vit);
                            mapa.put(vertices[i], vit);

                            Aresta ait = new Aresta(vertice, vit);
                            ait.setPeso(Integer.parseInt(pesoArestas[i - 1]));
                            arestasAtual.add(ait);

                        }
                        vertice.setVizinhos(vizinhosAtual);
                        vertice.setArestas(arestasAtual);

                    }

                }

                // Vertices finais
                else {

                    // vertice = grafo.encontrarVertice(linha);
                    vertice = (Vertice) mapa.get(linha);
                    if (vertice == null)
                        vertice = new Vertice();
                   // vertice.setIndice(linha);
                    mapa.put(linha, vertice);

                }

                grafo.adicionarVertice(vertice);
                listaStrings.clear();

            }

            // catch do BufferedReader
        } catch (FileNotFoundException e) {
            System.out.println("Nao encontrou o arquivo");
            e.printStackTrace();
        }
        // catch do readLine
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Retornando os vertices
        return grafo.getVertices();
    }
 */
/*   //Main Utilizando BufferReader
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
*/