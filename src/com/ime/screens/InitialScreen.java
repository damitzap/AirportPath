package com.ime.screens;

import com.ime.application.Airports;
import com.ime.dal.AirportsDal;
import com.ime.dal.ConnectionModule;

import java.sql.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                JOptionPane.showMessageDialog(null,"STATUS BD " + connection);
            }
        });
        origemList.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                AirportsDal airportsDal = new AirportsDal();
                List<Airports> airportsList = airportsDal.getAirports();

                //limpar combobox
                origemList.removeAll();

                for(Airports a : airportsList){
                    origemList.addItem(a.getIata());
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
                List<Airports> airportsList = airportsDal.getAirports();

                //limpar combobox
                destinoList.removeAll();

                for(Airports a : airportsList){
                    destinoList.addItem(a.getIata());
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
