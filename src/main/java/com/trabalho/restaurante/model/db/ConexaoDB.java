package com.trabalho.restaurante.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        String nomeBaseDados = "trabalho";
        String porta = "3306";
        String enderecoBaseDados = String.format("jdbc:mysql://localhost:%s/%s", porta, nomeBaseDados);

        String login = "root";
        String senha = "bTb2302@";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(enderecoBaseDados, login, senha);

    }
}
