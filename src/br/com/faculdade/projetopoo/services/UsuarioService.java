/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class UsuarioService {
    
    public static void createUsuario(Usuario usuario){
        ConnectionBD con = new ConnectionBD();
        Statement stmt = null;
        String sql = "INSERT INTO `usuario` (`codUsuario`, `nome`, `email`, `cpf`,`senha`)\n"
        		   + "VALUES ('"+usuario.getCodUsuario()+"', '"+usuario.getNome()+"', '"+usuario.getEmail()+"',\n"
        		   + "'"+usuario.getCpf()+"','"+usuario.getSenha()+"')";
        System.out.println("br.com.faculdade.projetopoo.services.UsuarioService.createUsuario()");
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
    
    public static Usuario findByEmail(String email){
        ConnectionBD con = new ConnectionBD();
        Usuario usuario = new Usuario();
        usuario.setEmail("");
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM `usuario` WHERE `email` = '" + email+"'";
        System.out.println("br.com.faculdade.projetopoo.services.UsuarioService()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
            	usuario.setCodUsuario(rs.getLong("codUsuario"));
            	usuario.setNome(rs.getString("nome"));
            	usuario.setCpf(rs.getString("cpf"));
            	usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            	
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
        return usuario;
    }
    
    public static Usuario findByCpf(String cpf){
        ConnectionBD con = new ConnectionBD();
        Usuario usuario = new Usuario();
        usuario.setCpf("");
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM `usuario` WHERE `cpf` = " + cpf;
        System.out.println("br.com.faculdade.projetopoo.services.UsuarioService()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
            	usuario.setCodUsuario(rs.getLong("codUsuario"));
            	usuario.setNome(rs.getString("nome"));
            	usuario.setCpf(rs.getString("cpf"));
            	usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            	
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
        return usuario;
    }
}
