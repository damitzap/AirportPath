package com.ime.application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Airports {
    //Atributos dos Aeroportos
    private String iata; //Id do aeroporto
    private String nome;
    private String local;
    private double latitude;
    private double longitude;

    private List<Airports> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    Map<Airports, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Airports destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    //Metodos Get e Set para cada atributo da Classe Aeroporto
    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
