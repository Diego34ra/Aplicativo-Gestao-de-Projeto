/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexao do banco de dado
 * @author Diego
 */
public class ConnectionBD {
private Connection con = null;	
private String hostName = null;
private String userName = null;
private String password = null;
private String url = null;
private String jdbcDriver = null;
private String dataBaseName = null;
private String dataBasePrefix = null;
private String dabaBasePort = null;

/**
 *  Construtor da ConnectionBD
 */
public ConnectionBD() {
    super();
    hostName = "localhost";
    userName = "root";
    password = "";
    jdbcDriver = "com.mysql.cj.jdbc.Driver";
    dataBaseName = "projeto";
    dataBasePrefix = "jdbc:mysql://";
    dabaBasePort = "3306";
    url = dataBasePrefix + hostName + ":"+dabaBasePort+"/" + dataBaseName ;
  }

/**
 * Metodo que faz a conexao com o banco de dados
 * @return conexao com o banco de dados
 */
public Connection getConnection() {
    try {
      if (con == null) {
        Class.forName(jdbcDriver);
        con = DriverManager.getConnection(url+"?useTimezone=true&serverTimezone=UTC&useSSL=false", userName, password);
      } else if (con.isClosed()) {
        con = null;
        return getConnection();
      }
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    } catch (SQLException e) {


      e.printStackTrace();
    }
    return con;
  }

/**
 * Metodo que fecha a conexao com o banco de dados
 */
public void closeConnection() {
    if (con != null) {
      try {
        con.close();
      } catch (SQLException e) {
        //TODO: use um sistema de log apropriado.
        e.printStackTrace();
      }
    }
  }
}
