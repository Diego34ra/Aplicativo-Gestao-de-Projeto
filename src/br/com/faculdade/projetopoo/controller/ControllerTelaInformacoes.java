package br.com.faculdade.projetopoo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ControllerTelaInformacoes implements Initializable {

    @FXML
    private Button btDesc;

    @FXML
    private Button btPerfil;

    @FXML
    private Button btProjetos;

    @FXML
    private Button btSair;

    @FXML
    private Button btTelaInicial;

    @FXML
    void btDesc(ActionEvent event) {

    }

    @FXML
    void btInicio(ActionEvent event) {

    }

    @FXML
    void btPerfil(ActionEvent event) {

    }

    @FXML
    void btProjetos(ActionEvent event) {

    }

    @FXML
    void btSair(ActionEvent event) {
    	System.exit(0);
    }
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
