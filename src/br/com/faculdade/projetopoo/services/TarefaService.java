/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Tarefa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author 2022101202010058
 */
public class TarefaService {
    
    public void create(Tarefa tarefa){
        ConnectionBD con = new ConnectionBD();
        String sql = "INSERT INTO tarefa (codTarefa, codProjeto, codUsuario, nome, descricao, status, dtCriacao) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, tarefa.getCodTarefa().toString());
            stmt.setString(2, tarefa.getProjeto().getCodProjeto().toString());
            stmt.setString(3, tarefa.getUsuario().getCodUsuario().toString());
            stmt.setString(4, tarefa.getNome());
            stmt.setString(5, tarefa.getDescricao());
            stmt.setString(6, tarefa.getStatus());
            stmt.setDate(7, Date.valueOf(tarefa.getDataCriacao()));
            stmt.execute();
    
            stmt.close();
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
