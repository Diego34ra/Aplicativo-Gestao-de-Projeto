package br.com.faculdade.projetopoo.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

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
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
