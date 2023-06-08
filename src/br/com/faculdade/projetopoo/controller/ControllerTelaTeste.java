/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.view.TelaPerfilUsuario;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class ControllerTelaTeste {
    
    @FXML
    private HBox hbox;

    @FXML
    private AnchorPane PaneMeio;

    @FXML
    void teste() {

    }
    
    @FXML
    void btPerfilUser(ActionEvent event) throws IOException {
           TelaPerfilUsuario telaPerfilUsuario = new TelaPerfilUsuario ();
    try {
        telaPerfilUsuario.start(new Stage());
        //Fecha a tela atual
        /*Stage stage = (Stage) Pane.getScene().getWindow();
        stage.close();*/
    } catch (Exception ex) {
        System.out.println("Erro ao abrir a tela de Perfil: " + ex.getMessage());
    }
    }

    @FXML
    void getPaneProjeto() throws IOException {
        Parent menuRecebimento = FXMLLoader.load(getClass().getResource("/br/com/faculdade/projetopoo/view/FXMLTelaProjeto2.fxml"));
        AnchorPane.setTopAnchor(menuRecebimento, 72.0);
        AnchorPane.setBottomAnchor(menuRecebimento, 23.0);
        AnchorPane.setLeftAnchor(menuRecebimento, 23.0);
        AnchorPane.setRightAnchor(menuRecebimento, 23.0);
        PaneMeio.getChildren().setAll(menuRecebimento);
    }

}
