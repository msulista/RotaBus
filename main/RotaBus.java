package main;

import model.Dijkstra;
import model.Grafo;
import model.Vertice;
import util.LerDoArquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus.rodrigues on 27/06/2015.
 */
public class RotaBus {
    public static void main(String[] args) {

        try {
            LerDoArquivo.lerArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Calcula o menor Caminho");
        System.out.println();


    }
}
