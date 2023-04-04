/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import br.com.faculdade.projetopoo.connection.ConnectionBD;
import br.com.faculdade.projetopoo.model.Projeto;
import java.sql.Statement;

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
}
