/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.view.TelaCadastroUser;
import java.net.URL;
import java.util.ResourceBundle;

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
    void logar() {

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
    }
    
    @FXML
    void btSair(ActionEvent event) {
    	System.exit(0);
    }
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}