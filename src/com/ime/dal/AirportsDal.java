package com.ime.dal;
import com.ime.application.Airports;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportsDal {
//    Connection connection = null;
//    PreparedStatement pst = null;
//    ResultSet rs = null; //show result of sql in app
    public void save(Airports airports){
        String sql = "INSERT INTO airports(iata, Nome, location, latitude, longitude) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement pstm = null;

        try{
            //Criar conexao com o Banco de Dados
            connection = ConnectionModule.connector();
            //Criar um PreparedStatemente para executar uma query;
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            //Adicao de valores que sao esperados pela query
            pstm.setString(1,airports.getIata());
            pstm.setString(2,airports.getNome());
            pstm.setString(3,airports.getLocal());
            pstm.setDouble(4,airports.getLatitude());
            pstm.setDouble(5,airports.getLongitude());

            //Execucao da query
            pstm.execute();

            System.out.println("Aeroporto Salvo com Sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //fechar conexoes
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public Map<String,Airports> getAirports(){
        String sql = "SELECT * FROM  airports";
        //criacao de list para armazenar os dados dos aeroportos
        Map<String,Airports> airportsList = new HashMap<>();

        Connection connection = null;
        PreparedStatement pstm = null;
        //Classe que ira recuperar os dados do Banco de Dados ***SELECT****
        ResultSet rset = null;

        try{
            connection = ConnectionModule.connector();

            pstm = (PreparedStatement) connection.prepareStatement(sql);

            rset = pstm.executeQuery();
            //Percorrer os dados do Banco
            while (rset.next()){
                Airports airports = new Airports();

                //Recuperar o iata
                airports.setIata(rset.getString("iata"));
                //Recuperar o Nome
                airports.setNome(rset.getString("Nome"));
                //Recuperar o Local
                airports.setLocal(rset.getString("location"));
                //Recuperar a Latitude
                airports.setLatitude(rset.getDouble("latitude"));
                //Recuperar a Longitude
                airports.setLongitude(rset.getDouble("longitude"));

                airportsList.put(airports.getIata(), airports);
            }
        }catch (Exception  e){
            e.printStackTrace();
        }finally {
            try{//tratamento para fechar as conexoes
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return airportsList;
    }

}
