/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Diego
 */
public class UsuarioService {
    
    public static void createUsuario(Usuario usuario) throws NoSuchAlgorithmException{
        ConnectionBD con = new ConnectionBD();
//        PreparedStatement stmt = null;
//        String sql = "INSERT INTO `usuario` (`codUsuario`, `nome`, `email`, `cpf`,`senha`)\n"
//        		   + "VALUES ('"+usuario.getCodUsuario()+"', '"+usuario.getNome()+"', '"+usuario.getEmail()+"',\n"
//        		   + "'"+usuario.getCpf()+"','"+cryptoPass(usuario.getSenha())+"')";
        String sql = "INSERT INTO usuario (codUsuario, nome, email, cpf, senha) VALUES (?,?,?,?,?)";
        System.out.println("br.com.faculdade.projetopoo.services.UsuarioService.createUsuario()");
        try {
            String cryptoSenha = cryptoPass(usuario.getSenha());
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, usuario.getCodUsuario().toString());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, cryptoSenha);
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
    
    public static List<Usuario> findAll(){
        ConnectionBD con = new ConnectionBD();
        List<Usuario> usuarios = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuario";
        System.out.println("br.com.faculdade.projetopoo.services.UsuarioService()");
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
                Usuario usuario = new Usuario();
            	usuario.setCodUsuario(rs.getLong("codUsuario"));
            	usuario.setNome(rs.getString("nome"));
            	usuario.setCpf(rs.getString("cpf"));
            	usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            	usuarios.add(usuario);
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
        return usuarios;
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
    
    public static List<Usuario> findByName(String consulta){
        ConnectionBD con = new ConnectionBD();
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, "%"+consulta+"%");
            rs = stmt.executeQuery(); 
            while(rs.next()) {
                Usuario usuario = new Usuario();
            	usuario.setCodUsuario(rs.getLong("codUsuario"));
            	usuario.setNome(rs.getString("nome"));
            	usuario.setEmail(rs.getString("email"));
            	usuario.setCpf(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
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
        return usuarios;
    }
    
    public static Usuario findById(String codigo){
        ConnectionBD con = new ConnectionBD();
        Usuario usuario = new Usuario();
        usuario.setCodUsuario(0L);
        ResultSet rs = null;
        String sql = "SELECT * FROM usuario WHERE codUsuario = ?";
        System.out.println("br.com.faculdade.projetopoo.services.ProjetoService.findAll()");
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery(); 
            while(rs.next()) {
            	usuario.setCodUsuario(rs.getLong("codUsuario"));
            	usuario.setNome(rs.getString("nome"));
            	usuario.setEmail(rs.getString("email"));
            	usuario.setCpf(rs.getString("cpf"));
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
        String sql = "SELECT * FROM `usuario` WHERE `cpf` = '" + cpf+"'";
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
    
    public static String cryptoPass(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
 
        return String.format("%32x", hash);
    }
    
    public static String validateCpf(String cpf){
        CPFValidator cpfValidator = new CPFValidator(); 
        try{ cpfValidator.assertValid(cpf); 
            return cpf; 
        }catch(Exception e){ 
            System.out.println("Cpf digitado está inválido: " +cpf+"\n"+ e.getMessage());
            return ""; 
        } 
    }

    public static String removeAcentos(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
    public static boolean validateEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}