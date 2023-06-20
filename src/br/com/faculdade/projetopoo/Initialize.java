/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Inicializador do banco de dados
 * @author Diego
 */
public class Initialize {
    
    /**
     * Metodo que gera as tabelas do banco de dados caso elas nao existam
     */
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
                        "  UNIQUE KEY `cpf` (`cpf`)\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci");
        }
        if(!verifyTable("projeto")){
            createTable("CREATE TABLE `projeto` (\n" +
                        "  `codProjeto` varchar(45) NOT NULL,\n" +
                        "  `nome` varchar(45) NOT NULL,\n" +
                        "  `descricao` varchar(45) NOT NULL,\n" +
                        "  `dataCriacao` datetime NOT NULL,\n" +
                        "  PRIMARY KEY (`codProjeto`)\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci");
        }
        
        if(!verifyTable("status")){
            createTable("CREATE TABLE `status` (\n" +
                        "`codStatus` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "`codProjeto` varchar(45) DEFAULT NULL,\n" +
                        "`nome` varchar(45) NOT NULL,\n" +
                        "`descricao` varchar(45) NOT NULL,\n" +
                        "`dataHora` datetime NOT NULL,\n" +
                        "PRIMARY KEY (`codStatus`),\n" +
                        "KEY `codProjeto` (`codProjeto`),\n" +
                        "CONSTRAINT `status_ibfk_1` FOREIGN KEY (`codProjeto`) REFERENCES `projeto` (`codProjeto`)\n" +
                        "ON DELETE CASCADE\n" +
                        "ON UPDATE CASCADE\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci");
        }
        
        if(!verifyTable("tarefa")){
            createTable("CREATE TABLE `tarefa` (\n" +
                        "  `codTarefa` varchar(45) NOT NULL,\n" +
                        "  `codProjeto` varchar(45) DEFAULT NULL,\n" +
                        "  `codUsuario` varchar(45) DEFAULT NULL,\n" +
                        "  `nome` varchar(45) NOT NULL,\n" +
                        "  `descricao` varchar(45) NOT NULL,\n" +
                        "  `status` varchar(45) NOT NULL,\n" +
                        "  `dtCriacao` datetime NOT NULL,\n" +
                        "  `dtFinalizacao` datetime DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`codTarefa`),\n" +
                        "  KEY `codProjeto` (`codProjeto`),\n" +
                        "  KEY `codUsuario` (`codUsuario`),\n" +
                        "  CONSTRAINT `tarefa_ibfk_1` FOREIGN KEY (`codProjeto`) REFERENCES `projeto` (`codProjeto`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                        "  CONSTRAINT `tarefa_ibfk_2` FOREIGN KEY (`codUsuario`) REFERENCES `usuario` (`codUsuario`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci");
        }
        
    }
    
    /**
     * Metodo para criar as tabelas
     * @param sql sql da tabela que vai ser criada
     */
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
    
    /**
     * Metodo que verifica se a tabela existe no banco de dados
     * @param table tabela que vai ser verificada
     * @return verificacao da tabela
     */
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
