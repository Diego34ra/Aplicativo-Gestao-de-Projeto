/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.dao;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class ProjetoDao {
    
    public void create(Projeto projeto){
        ConnectionBD con = new ConnectionBD();
        String sql = "INSERT INTO projeto (codProjeto, nome, descricao, dataCriacao) VALUES (?,?,?,NOW())";
        System.out.println("br.com.faculdade.projetopoo.dao.ProjetoDao.create()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, projeto.getCodProjeto().toString());
            stmt.setString(2, projeto.getNome());
            stmt.setString(3, projeto.getDescricao());
            if (stmt.execute()) {
                
            }
            StatusDao statusService = new StatusDao();
            Status status = new Status("Em espera", "O projeto ainda não foi iniciado.", projeto.getCodProjeto().toString());
            statusService.create(status);
    
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
    
    public boolean deleteById(Long codProjeto){
        ConnectionBD con = new ConnectionBD();
        String sql = "DELETE FROM projeto WHERE codProjeto = ?";
        System.out.println("br.com.faculdade.projetopoo.dao.ProjetoDao.deleteById()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, codProjeto.toString());
            stmt.execute();
            stmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static List<Projeto> findAll(){
        ConnectionBD con = new ConnectionBD();
        List<Projeto> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM projeto";
        System.out.println("br.com.faculdade.projetopoo.dao.ProjetoDao.findAll()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
                Projeto projeto = new Projeto();
            	projeto.setCodProjeto(rs.getLong("codProjeto"));
            	projeto.setNome(rs.getString("nome"));
            	projeto.setDataCriacao(rs.getString("dataCriacao"));
            	projeto.setDescricao(rs.getString("descricao"));
                projeto.setStatus(StatusDao.findById(projeto.getCodProjeto()).get(0));
                lista.add(projeto);
            	
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
    
    public static List<Projeto> findByName(String consulta){
        ConnectionBD con = new ConnectionBD();
        List<Projeto> lista = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM projeto WHERE nome LIKE ?";
        System.out.println("br.com.faculdade.projetopoo.dao.ProjetoDao.findByName()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, "%"+consulta+"%");
            rs = stmt.executeQuery(); 
            while(rs.next()) {
                Projeto projeto = new Projeto();
            	projeto.setCodProjeto(rs.getLong("codProjeto"));
            	projeto.setNome(rs.getString("nome"));
            	projeto.setDataCriacao(rs.getString("dataCriacao"));
            	projeto.setDescricao(rs.getString("descricao"));
                projeto.setStatus(StatusDao.findById(projeto.getCodProjeto()).get(0));
                lista.add(projeto);
            	
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
    
    public static Projeto findById(String codigo){
        ConnectionBD con = new ConnectionBD();
        Projeto projeto = new Projeto();
        projeto.setCodProjeto(0L);
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PROJETO WHERE CODPROJETO = '"+codigo+"'";
        System.out.println("br.com.faculdade.projetopoo.dao.ProjetoDao.findById()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
            	projeto.setCodProjeto(rs.getLong("codProjeto"));
            	projeto.setNome(rs.getString("nome"));
            	projeto.setDataCriacao(rs.getString("dataCriacao"));
            	projeto.setDescricao(rs.getString("descricao"));
                projeto.setStatus(StatusDao.findById(projeto.getCodProjeto()).get(0));
            	
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
        return projeto;
    }
    
}
