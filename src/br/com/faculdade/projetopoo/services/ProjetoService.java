/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class ProjetoService {
    
    public void create(Projeto projeto){
        ConnectionBD con = new ConnectionBD();
        Statement stmt = null;
        String sql = "INSERT INTO `projeto` (`codProjeto`, `nome`, `descricao`, `dataCriacao`)\n"
        		   + "VALUES ('"+projeto.getCodProjeto()+"', '"+projeto.getNome()+"', '"+projeto.getDescricao()+"',\n"
        		   + "str_to_date('"+projeto.getDataCriacao()+"', '%d/%m/%Y'))";
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
    
    public static List<Projeto> findAll(){
        ConnectionBD con = new ConnectionBD();
        List<Projeto> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM `projeto`";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
                Projeto projeto = new Projeto();
            	projeto.setCodProjeto(rs.getLong("codProjeto"));
            	projeto.setNome(rs.getString("nome"));
            	projeto.setDataCriacao(rs.getString("dataCriacao"));
            	projeto.setDescricao(rs.getString("descricao"));
                projeto.setStatus(StatusService.findById(projeto.getCodProjeto()).getNome());
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
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PROJETO WHERE CODPROJETO = '"+codigo+"'";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
            	projeto.setCodProjeto(rs.getLong("codProjeto"));
            	projeto.setNome(rs.getString("nome"));
            	projeto.setDataCriacao(rs.getString("dataCriacao"));
            	projeto.setDescricao(rs.getString("descricao"));
                projeto.setStatus(StatusService.findById(projeto.getCodProjeto()).getNome());
            	
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
