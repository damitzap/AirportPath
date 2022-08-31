package com.ime.screens;

import com.ime.dal.Airports;
import com.ime.dal.ConnectionModule;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InitialScreen {
    //Habilitar inteface com o Banco de dados
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null; //show result of sql in app

    public JPanel panel1;
    private JButton calcularButton;

    public InitialScreen() {
        connection = ConnectionModule.connector();
        //Retorno do status de conexao
        System.out.println(connection);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"STATUS BD " + connection);
            }
        });
    }

}
