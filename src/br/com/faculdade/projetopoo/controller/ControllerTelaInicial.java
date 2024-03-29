/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *  Classe controller utilizada para testes
 * @author João Gabriel
 */
public class ControllerTelaInicial {
    @FXML
    private AnchorPane Pane;
    
    @FXML
    void teste() {
        System.out.println("TESTANDO");
    }

    @FXML
    void cadastrarUsuario( ) {
        System.out.println("CADASTRANDO");
    }
    
    @FXML
    void getPaneProjeto() throws IOException {
        Parent menuRecebimento = FXMLLoader.load(getClass().getResource("/br/com/faculdade/projetopoo/view/FXMLTelaProjeto2.fxml"));
        AnchorPane.setTopAnchor(menuRecebimento, 72.0);
        AnchorPane.setBottomAnchor(menuRecebimento, 23.0);
        AnchorPane.setLeftAnchor(menuRecebimento, 23.0);
        AnchorPane.setRightAnchor(menuRecebimento, 23.0);
        Pane.getChildren().setAll(menuRecebimento);
    }


}
