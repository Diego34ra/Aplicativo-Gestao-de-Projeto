/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Diego
 */
public class ControllerTelaInicial {
    @FXML
    private AnchorPane Pane;

    @FXML
    private MenuItem menuUsuario;

    @FXML
    void cadastrarUsuario() {
        
    }
    
    @FXML
    void getPaneProjeto() throws IOException {
        Parent menuRecebimento = FXMLLoader.load(getClass().getResource("/br/com/faculdade/projetopoo/view/FXMLTelaProjeto.fxml"));
        AnchorPane.setTopAnchor(menuRecebimento, 72.0);
        AnchorPane.setBottomAnchor(menuRecebimento, 23.0);
        AnchorPane.setLeftAnchor(menuRecebimento, 23.0);
        AnchorPane.setRightAnchor(menuRecebimento, 23.0);
        Pane.getChildren().setAll(menuRecebimento);
    }


}
