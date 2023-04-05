package br.com.faculdade.projetopoo.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.faculdade.projetopoo.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ControllerTelaCadastroUser implements Initializable {

        @FXML
        private Button btCadastrarUser;

        @FXML
        private PasswordField psSenha;

        @FXML
        private TextField txCpf;
        
        @FXML
        private TextField txEmail;

        @FXML
        private TextField txNome;

        private Usuario usuario;

	@FXML
        void recuperarSenha() {

        }
        
        @FXML
        void logar() {
            
        }
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub	
	}

}
