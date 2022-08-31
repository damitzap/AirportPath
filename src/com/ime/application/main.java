package com.ime.application;

import com.ime.dal.AirportsDal;
import com.ime.screens.InitialScreen;
import javax.swing.*;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws Exception {
        //configuração da interface gráfica
        JFrame frame = new JFrame("Melhor caminho entre dois Aeroportos");
        frame.setContentPane(new InitialScreen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //AirportsDal airportsDal = new AirportsDal();

//        Airports airports = new Airports();
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
