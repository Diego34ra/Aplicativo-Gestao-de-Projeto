/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.services.UsuarioService;
import br.com.faculdade.projetopoo.view.TelaCadastroUser;
import br.com.faculdade.projetopoo.view.TelaInformacoes;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class ControllerTelaPrincipal implements Initializable {    
   
    @FXML
    private AnchorPane Pane;
   
    @FXML
    private Button btSair;

    @FXML
    private Button btTelaCadastro;

    @FXML
    private Button btTelaLogin;

    @FXML
    private PasswordField txSenha;

    @FXML
    private TextField txEmail;

    @FXML
    private Label txRecuperaSenha;

    @FXML
    void recuperarSenha() {
        System.out.println("recuperar senha");
    }
    
    @FXML
    void logar() throws NoSuchAlgorithmException {
        Usuario usuario  = UsuarioService.findByEmail(txEmail.getText());
        if(txEmail.getText().equals(usuario.getEmail())){
            if (usuario.getSenha().equals(UsuarioService.cryptoPass(txSenha.getText()))) {
                TelaInformacoes tela = new TelaInformacoes();
                try {
                    tela.start(new Stage());
                    TelaInformacoes.getStage().show();
                } catch (Exception ex) {
                    System.out.println("Exception ao entrar no menu principal\n"+ex);
                } 
                //Fecha a tela atual
                Stage stage = (Stage) Pane.getScene().getWindow();
                stage.close();
            } else {
                Alertas.informacao("Senha incorreta!", "A senha digitada está incorreta.");
            }
        } else {
            Alertas.informacao("E-mail inválido!", "Não existe usuário cadastrado com esse e-mail.");
        }
    }
    
    @FXML
    void cadastrarUsuario() {
        TelaCadastroUser tela = new TelaCadastroUser();
        try {
            tela.start(new Stage());
            TelaCadastroUser.getStage().show();
        } catch (Exception ex) {
            System.out.println("Exception ao criar a tela de cadastro\n"+ex);
        }
        //Fecha a tela atual
        Stage stage = (Stage) Pane.getScene().getWindow();
        stage.close();
    }
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}