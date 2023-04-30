/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class Initialize {
    
    public void generateDB(){
        if (!verifyTable("usuario")) {
            createTable("CREATE TABLE `usuario` (\n" +
                    "  `codUsuario` varchar(45) NOT NULL,\n" +
                    "  `nome` varchar(45) NOT NULL,\n" +
                    "  `email` varchar(45) NOT NULL,\n" +
                    "  `cpf` varchar(45) NOT NULL,\n" +
                    "  `codRecuperacao` varchar(45) DEFAULT NULL,\n" +
                    "  `senha` varchar(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`codUsuario`),\n" +
                    "  UNIQUE KEY `cpf_UNIQUE` (`cpf`),\n" +
                    "  UNIQUE KEY `email_UNIQUE` (`email`)\n" +
                    ") ENGINE=MyISAM DEFAULT CHARSET=latin1");
        }
        if(!verifyTable("projeto")){
            createTable("CREATE TABLE `projeto` (\n" +
                    "  `codProjeto` varchar(45) NOT NULL,\n" +
                    "  `nome` varchar(45) NOT NULL,\n" +
                    "  `descricao` varchar(45) NOT NULL,\n" +
                    "  `dataCriacao` datetime NOT NULL,\n" +
                    "  PRIMARY KEY (`codProjeto`)\n" +
                    ") ENGINE=MyISAM DEFAULT CHARSET=latin1");
        }
        
        if(!verifyTable("status")){
            createTable("CREATE TABLE `status` (\n" +
                     "  `codStatus` int(11) NOT NULL AUTO_INCREMENT,\n" +
                     "  `projeto_id` int(11) NOT NULL,\n" +
                     "  `nome` varchar(45) NOT NULL,\n" +
                     "  `descricao` varchar(45) NOT NULL,\n" +
                     "  `dataHora` datetime NOT NULL,\n" +
                     "  PRIMARY KEY (`codStatus`),\n" +
                     "  KEY `projeto_id` (`projeto_id`)\n" +
                     ") ENGINE=MyISAM DEFAULT CHARSET=latin1");
        }
        
    }
    
    public void createTable(String sql){
        ConnectionBD con = new ConnectionBD();
        Statement stmt = null;
        try {
            stmt = con.getConnection().createStatement();
            stmt.execute(sql);    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public Boolean verifyTable(String table){
        String sql = "SELECT 1 AS RESULTADO \n" +
                     "  FROM information_schema.TABLES \n" +
                     "    WHERE table_schema = 'projeto'\n" +
                     "    AND table_name = '"+table+"'";
        Boolean valida = false;
        ConnectionBD con = new ConnectionBD();
        Statement stmt = null;
        ResultSet rs = null;
         try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
            	valida = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valida;
    }
}
