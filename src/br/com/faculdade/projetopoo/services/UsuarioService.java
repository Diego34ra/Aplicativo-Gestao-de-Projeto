/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Usuario;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class UsuarioService {
    
    public void createUsuario(Usuario usuario){
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
    
    public void findByEmail(String email){
        
    }
}
