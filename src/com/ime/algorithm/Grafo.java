package com.ime.algorithm;

import com.ime.application.Airports;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
    private Set<Airports> aeroportos = new HashSet<>();

    public void addNode(Airports aeroporto) {
        this.aeroportos.add(aeroporto);
    }
}
