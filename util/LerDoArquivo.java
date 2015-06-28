package util;

import model.Aresta;
import model.Dijkstra;
import model.Grafo;
import model.Vertice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by marcus.rodrigues on 27/06/2015.
 */
public class LerDoArquivo {

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
                    listaStrings.add(linha.split("/"));
                    vertices = listaStrings.get(0)[0].split(",");

                    vertice = (Vertice) mapa.get(vertices[0]);
                    if (vertice == null)
                        vertice = new Vertice();

                    List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
                    List<Aresta> arestasAtual = new ArrayList<Aresta>();
                    vertice.setDescricao(vertices[0]);
                    mapa.put(vertices[0], vertice);

                    if (linha.contains("/")) {

                        String pesoArestas[] = listaStrings.get(0)[1].split(",");

                        for (int i = 1; i < vertices.length; i++) {
                            Vertice vit;
                            // vit = grafo.encontrarVertice(vertices[i]);
                            vit = mapa.get(vertices[i]);
                            if (vit == null)
                                vit = new Vertice();
                            vit.setDescricao(vertices[i]);
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
                    vertice.setDescricao(linha);
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

}
