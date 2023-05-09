/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.services.EmailService;
import br.com.faculdade.projetopoo.services.ProjetoService;
import br.com.faculdade.projetopoo.services.UsuarioService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author Diego
 */
public class ProjetoPOO {
    
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static void main(String[] args) throws Exception {
      Projeto projeto = new Projeto();
        projeto.setDescricao("teste");
        projeto.setNome("TESTE PROJETO");
        projeto.setDataCriacao("01/04/2023");
        ProjetoService service = new ProjetoService();
        service.create(projeto);
            //Encode
//         EmailService email = new EmailService();
//         String destinatario[] = {"diegoribeiro13ra@hotmail.com"};
//         email.sendEmail("test",destinatario , "teste123");
        
    }
}
