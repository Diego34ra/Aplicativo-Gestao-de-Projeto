/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Projeto;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 2022101202010058
 */
public class TarefaService {
    
    public static Boolean deleteById(Long codigo){
        ConnectionBD con = new ConnectionBD();
        Statement stmt = null;
        Boolean rs = false;
        String sql = "DELETE FROM TAREFA WHERE CODPROJETO = '"+codigo+"'";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.execute(sql); 
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
