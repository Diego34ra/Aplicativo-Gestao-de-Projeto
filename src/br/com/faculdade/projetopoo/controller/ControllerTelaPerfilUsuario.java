package br.com.faculdade.projetopoo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author joaog
 */
public class ControllerTelaPerfilUsuario {
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private HBox hbox;

    @FXML
    void fechar() {
        //Fecha a tela atual
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }
}

