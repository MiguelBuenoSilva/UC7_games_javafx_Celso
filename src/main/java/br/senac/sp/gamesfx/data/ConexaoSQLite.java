package br.senac.sp.gamesfx.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {

    public static Connection getConexao(){

        // String de conexão - URL do banco de dados
        String url = "jdbc:sqlite:/C:/Users/celso.mfurtado/banco_de_dados/db_games.db";

        try {
            Connection conexao = DriverManager.getConnection(url);
            System.out.println("Conexão SUCELSO!!!");
            return conexao;
        } catch (SQLException erro) {
            System.out.println("Ocorreu um erro durante a conexão com o banco.");
            erro.printStackTrace();
            return null;
        }


    }

}
