package com.ime.dal;
import com.ime.dal.ConnectionModule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Airports {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null; //show result of sql in app

    public void teste(){
        connection = ConnectionModule.connector();
        //Retorno do status de conexao
        System.out.println(connection);

    }
}
