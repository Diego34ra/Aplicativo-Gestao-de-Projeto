/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.view.TelaPerfilUsuario;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class ControllerTelaTeste implements Initializable{
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private HBox hbox;

    @FXML
    private AnchorPane PaneMeio;

    @FXML
    void teste() {

    }
    
    @FXML
    void btPerfilUser() throws IOException {
           
    try {
        TelaPerfilUsuario telaPerfilUsuario = new TelaPerfilUsuario ();
        telaPerfilUsuario.start(new Stage());
        TelaPerfilUsuario.getStage().show();
        //Fecha a tela atual
//        Stage stage = (Stage) Pane.getScene().getWindow();
//        stage.close();
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
    
    @FXML
    public void sair( ){
        //Fecha a tela atual
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
        
        try {
            TelaPrincipal telaPrincipal = new TelaPrincipal ();
            telaPrincipal.start(new Stage());
        } catch (Exception ex) {
            System.out.println("Erro ao abrir ao abrir a tela principal: " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
