/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class StatusService {
    
    
    public static Status findById(Long codProjeto){
        ConnectionBD con = new ConnectionBD();
        Status status = new Status();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM status WHERE codProjeto = '"+codProjeto+"' ORDER BY DATAHORA ASC";
        System.out.println("br.com.faculdade.projetopoo.services.UsuarioService()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
                status.setCodStatus(rs.getInt("codStatus"));
                status.setCodProjeto(rs.getString("codProjeto"));
            	status.setNome(rs.getString("nome"));
            	status.setDataHora(rs.getString("dataHora"));
            	status.setDescricao(rs.getString("descricao"));
            	
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
        return status;
    }
    
    public void create(Status status){
        ConnectionBD con = new ConnectionBD();
        String sql = "INSERT INTO status (codStatus, codProjeto, nome, descricao, dataHora) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, status.getCodStatus());
            stmt.setString(2, status.getCodProjeto());
            stmt.setString(3, status.getNome());
            stmt.setString(4, status.getDescricao());
            stmt.setDate(5, Date.valueOf(status.getDataHora()));
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
}
