package com.ime.application;

import com.ime.screens.InitialScreen;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        //configuração da interface gráfica
        JFrame frame = new JFrame("Melhor caminho entre dois Aeroportos");
        frame.setContentPane(new InitialScreen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
