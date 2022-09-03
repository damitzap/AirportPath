package com.ime.algorithm;

import com.ime.application.Airports;

import java.util.HashSet;
import java.util.Set;

public class Djikstra {

    private static Airports getLowestDistanceNode(Set < Airports > unsettledNodes) {
        Airports lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Airports node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static Grafo calcularMenorCaminhodaOrigem(Grafo grafo, Airports origem){
        origem.setDistance(0);
        Set<Airports> settledAirports = new HashSet<>();
        Set<Airports> unsettledAirports = new HashSet<>();

        unsettledAirports.add(origem);

        while(unsettledAirports.size() !- 0){
            Airports aeroportoAtual = getMenorDistanciaAeroporto(unsettledAirports);

        }
    }

}
