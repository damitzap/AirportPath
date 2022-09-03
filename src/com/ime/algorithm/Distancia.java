package com.ime.algorithm;

import com.ime.application.Airports;

import java.util.HashMap;
import java.util.Map;

public class Distancia {

    // Retorna distancia entre dois pontos dados latitute e longitude
    public double distanceTo(Airports ap1, Airports ap2) {

        double lat1 = Math.toRadians(ap1.getLatitude());
        double lon1 = Math.toRadians(ap1.getLongitude());
        double lat2 = Math.toRadians(ap2.getLatitude());
        double lon2 = Math.toRadians(ap2.getLongitude());

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // Conversao para Km
        double relKm = 1.852 * 60 * Math.toDegrees(angle);
        return relKm;
    }

    //METODO PARA GERAR TODOS OS CUSTOS (DISTANCIAS) ENTRE OS AEROPORTOS
    public HashMap<String, HashMap<String,Double>> custos(Map<String,Airports> airportsMap){
        //CUSTOS: Armazena todos os aeroportos e todas as suas  respectivas relações com outros aeroportos
        HashMap<String,HashMap<String,Double>> custos = new HashMap<>();
        for(Map.Entry<String,Airports> entry : airportsMap.entrySet()){
            HashMap<String,Double> arp_a = new HashMap<>();
            //CALCULAR A DISTANCIA ENTRE UM AEROPORTO E TODOS OS OUTROS
            for(Map.Entry<String,Airports> entry1 : airportsMap.entrySet()){
                if(entry.getValue().getIata().equals(entry1.getValue().getIata())){
                    continue;
                }
                double distanciaKm = distanceTo(entry.getValue(),entry1.getValue());
                arp_a.put(entry1.getValue().getIata(),distanciaKm);
            }
            custos.put(entry.getValue().getIata(), arp_a);
        }
        return custos;
    }

}

