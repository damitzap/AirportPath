package com.ime.application;

import com.ime.algorithm.Distancia;
import com.ime.dal.AirportsDal;
import com.ime.screens.InitialScreen;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) throws Exception {
        //configuração da interface gráfica
        JFrame frame = new JFrame("Melhor caminho entre dois Aeroportos");
        frame.setContentPane(new InitialScreen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        AirportsDal airportsDal = new AirportsDal();
        Distancia teste = new Distancia();
        System.out.println(
                        "Distancia entre " + airportsDal.getAirports().get("SDU").getIata() + " e "
                        + airportsDal.getAirports().get("FOR").getIata() + " eh: " +
                        teste.distanceTo(airportsDal.getAirports().get("SDU"),airportsDal.getAirports().get("FOR")));
//
//
//      //TESTE DA IMPLEMETACAO DA RELACAO DE DISTANCIAS
        HashMap<String, HashMap<String, Double>> dist = new Distancia().custos(airportsDal.getAirports());
        for(Map.Entry<String,HashMap<String, Double>> entry : dist.entrySet()){
            System.out.println("Chave: " + entry.getKey());
            for(Map.Entry<String,Double> entry1 : entry.getValue().entrySet()){
                System.out.println(" " + entry1.getKey() + " " + entry1.getValue());
            }
        }
//
//        MAPEAR AEROPORTOS BASEADOS NA CHAVE
//        Map<String,Airports> distancias = new HashMap<>();
//        for (int i=0; i < airportsDal.getAirports().size(); i++){
//            distancias.put((String) airportsDal.getAirports().get(i).getIata(), airportsDal.getAirports().get(i));
//        }
//
//        for(Map.Entry<String,Airports> entry : distancias.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue().getNome() + " " +entry.getValue().getLatitude()+"/"+entry.getValue().getLongitude());
//        }




        //CRIAR REGISTRO NO BD
//        Airports airports = new Airports();
//        System.out.println(airports);
//        airports.setIata("SDU");
//        airports.setNome("Aeroporto Santos Dummont");
//        airports.setLocal("Santos Dummond, Rio de Janeiro, RJ");
//        airports.setLatitude(-24.2222);
//        airports.setLongitude(-43.6666);
//
//        airportsDal.save(airports);

        //Visualizar TODOS os registros do BD
//        int i=1;
//        for(Airports a : airportsDal.getAirports()){
//            System.out.println(i + " - Aeroporto: " + a.getIata());
//            i++;
//        }


    }
}
