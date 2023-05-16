/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.services.ProjetoService;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Diego
 */
public class ProjetoPOO {
    
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static void main(String[] args) throws Exception {
            
            Initialize init = new Initialize();
            init.generateDB();
            Projeto projeto = new Projeto("teste", "Testando");
            ProjetoService projetoService = new ProjetoService();
            projetoService.create(projeto);
            
        
 //       Projeto projeto = new Projeto();
 //       projeto.setDescricao("teste");
  //      projeto.setNome("TESTE PROJETO");
 //       projeto.setDataCriacao("01/04/2023");
   //     ProjetoService service = new ProjetoService();
  //      service.create(projeto);
            //Encode
//         EmailService email = new EmailService();
//         String destinatario[] = {"diegoribeiro13ra@hotmail.com"};
//         email.sendEmail("test",destinatario , "teste123");
        
    }
}
