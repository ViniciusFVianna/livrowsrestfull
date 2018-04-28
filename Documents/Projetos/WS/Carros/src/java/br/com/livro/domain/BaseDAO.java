/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vinicius.Vianna
 */
public class BaseDAO {

    public BaseDAO() {
        try {
            //Necessário para utilizar o drive JDBC do MYSQL
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //Erro de driver JDBC (adicione o driver .jar do MYSQL em WEB-INF/lib)
            e.printStackTrace();
        }
    }//fecha construtor
    
    protected Connection getConnection() throws SQLException{
        //URL de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/livro";
        //Conecta utilizando a URL, usuario e senha
        Connection conn = DriverManager.getConnection(url, "livro","livro123");
        return conn;
    }//fecha getConnection
    
}//fecha classe
