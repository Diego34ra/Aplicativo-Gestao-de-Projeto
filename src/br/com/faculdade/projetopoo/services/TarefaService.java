/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Tarefa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2022101202010058
 */
public class TarefaService {
    
    public void create(Tarefa tarefa){
        ConnectionBD con = new ConnectionBD();
        String sql = "INSERT INTO tarefa (codTarefa, codProjeto, codUsuario, nome, descricao, status, dtCriacao) VALUES (?,?,?,?,?,?,NOW())";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, tarefa.getCodTarefa().toString());
            stmt.setString(2, tarefa.getProjeto().getCodProjeto().toString());
            stmt.setString(3, tarefa.getUsuario().getCodUsuario().toString());
            stmt.setString(4, tarefa.getNome());
            stmt.setString(5, tarefa.getDescricao());
            stmt.setString(6, tarefa.getStatus());
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
    
    public static Boolean deleteByIdProjeto(Long codigo){
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
    
    public Boolean deleteById(Long codigo){
        ConnectionBD con = new ConnectionBD();
        Boolean rs = false;
        String sql = "DELETE FROM tarefa WHERE codTarefa = ?";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setLong(1, codigo);
            rs = stmt.execute(); 
            
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
    
    public List<Tarefa> findAll(Long codigo){
        ConnectionBD con = new ConnectionBD();
        List<Tarefa> lista = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tarefa WHERE codProjeto = ?";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, codigo.toString());
            rs = stmt.executeQuery(); 
            while(rs.next()) {
                Tarefa tarefa = new Tarefa();
            	tarefa.setCodTarefa(rs.getLong("codTarefa"));
            	tarefa.setNome(rs.getString("nome"));
            	tarefa.setDataCriacao(rs.getString("dtCriacao"));
                tarefa.setDataFinalizacao(rs.getString("dtFinalizacao"));
                if(tarefa.getDataFinalizacao() == null){
                    tarefa.setDataFinalizacao("-");
                }
            	tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setUsuario(UsuarioService.findById(rs.getString("codUsuario")));
                lista.add(tarefa);
            	
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
        return lista;
    
    }
    
    public void update(Tarefa tarefa){
        ConnectionBD con = new ConnectionBD();
        String sql = "UPDATE tarefa SET status = ?, dtFinalizacao = "+tarefa.getDataFinalizacao()+" WHERE codTarefa = ?";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, tarefa.getStatus());
            stmt.setString(2, tarefa.getCodTarefa().toString());
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
