package com.ime.screens;

import com.ime.algorithm.Distancia;
import com.ime.application.Airports;
import com.ime.dal.AirportsDal;
import com.ime.dal.ConnectionModule;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InitialScreen {
    //Habilitar inteface com o Banco de dados
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null; //show result of sql in app

    public JPanel panel1;
    private JButton calcularButton;
    private JComboBox origemList;
    private JComboBox destinoList;
    private JTextArea resultado;

    public InitialScreen() throws Exception{
        connection = ConnectionModule.connector();
        //Retorno do status de conexao
        if(connection!=null){
            System.out.println(connection);
            System.out.println("Conexao OK");
            connection.close();
        }

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Origem: " + origemList.getSelectedItem() + "\n" +" Destino: " + destinoList.getSelectedItem());
                AirportsDal airportsDal = new AirportsDal();
                resultado.setText("Origem: "+ (String)origemList.getSelectedItem() +"\n"
                                +"Destino: " + destinoList.getSelectedItem() +"\n"
                                +"Distancia entre os aeroportos: "
                        + new Distancia().distanceTo(airportsDal.getAirports().get(origemList.getSelectedItem()),airportsDal.getAirports().get(destinoList.getSelectedItem())) );

            }
        });
        origemList.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                AirportsDal airportsDal = new AirportsDal();
                Map<String,Airports> airportsList = airportsDal.getAirports();

                //limpar combobox
                origemList.removeAll();

                for(Map.Entry<String,Airports> entry : airportsList.entrySet()){
                    origemList.addItem(entry.getValue().getIata());
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
        destinoList.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                AirportsDal airportsDal = new AirportsDal();
                Map<String,Airports> airportsList = airportsDal.getAirports();

                //limpar combobox
                destinoList.removeAll();

                for(Map.Entry<String,Airports> entry : airportsList.entrySet()){
                    destinoList.addItem(entry.getValue().getIata());
                }

            }
            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });


    }



}
