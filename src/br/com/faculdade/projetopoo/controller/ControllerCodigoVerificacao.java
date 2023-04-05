package br.com.faculdade.projetopoo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ControllerCodigoVerificacao implements Initializable {
	
	@FXML
    private AnchorPane Pane;
   
    @FXML
    private Button btSair;
    
    @FXML
    void btSair(ActionEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
