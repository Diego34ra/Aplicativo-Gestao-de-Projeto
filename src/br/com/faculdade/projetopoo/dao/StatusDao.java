/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.dao;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Status;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Dao do status
 * @author Diego
 */
public class StatusDao {
    
    /**
     * Metodo que retorna uma lista de status pelo codigo do projeto
     * @param codProjeto codigo do projeto que o status esta vinculado
     * @return lista de status
     */
    public static List<Status> findById(Long codProjeto){
        List<Status> listaStatus = new ArrayList<>();
        ConnectionBD con = new ConnectionBD();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM status WHERE codProjeto = '"+codProjeto+"' ORDER BY DATAHORA DESC";
        System.out.println("br.com.faculdade.projetopoo.dao.findById()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
                Status status = new Status();
                status.setCodStatus(rs.getInt("codStatus"));
                status.setCodProjeto(rs.getString("codProjeto"));
            	status.setNome(rs.getString("nome"));
            	status.setDataCriacao(rs.getString("dataHora"));
            	status.setDescricao(rs.getString("descricao"));
            	listaStatus.add(status);
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
        return listaStatus;
    }
    
    /**
     * Metodo que cria um status 
     * @param status status
     */
    public void create(Status status){
        ConnectionBD con = new ConnectionBD();
        String sql = "INSERT INTO status (codStatus, codProjeto, nome, descricao, dataHora) VALUES (?,?,?,?,NOW())";
        System.out.println("br.com.faculdade.projetopoo.dao.create()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, status.getCodStatus());
            stmt.setString(2, status.getCodProjeto());
            stmt.setString(3, status.getNome());
            stmt.setString(4, status.getDescricao());
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
        
    /**
     * Metodo que deleta um status pelo codigo do projeto 
     * @param codProjeto 
     */
    public static void deleteByIdProjeto(Long codProjeto){
        ConnectionBD con = new ConnectionBD();
        String sql = "DELETE FROM `status` WHERE `status`.codProjeto = ?";
        System.out.println("br.com.faculdade.projetopoo.dao.deleteByIdProjeto()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, codProjeto.toString());
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
