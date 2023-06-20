/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.view.TelaPerfilUsuario;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Controller da tela de teste.
 * Responsável por gerenciar os eventos e ações na tela de teste.
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
    
    /**
     * Ação do botão "Perfil do Usuário".
     * Abre a tela de perfil do usuário.
     * @throws IOException Lança uma exceção IOException se ocorrer um erro ao carregar a tela.
     */
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

    /**
     * Ação para obter o painel do projeto.
     * Carrega o painel do projeto na parte central da tela.
     * @throws IOException Lança uma exceção IOException se ocorrer um erro ao carregar o painel.
     */
    @FXML
    void getPaneProjeto() throws IOException {
        Parent menuRecebimento = FXMLLoader.load(getClass().getResource("/br/com/faculdade/projetopoo/view/FXMLTelaProjeto2.fxml"));
        AnchorPane.setTopAnchor(menuRecebimento, 72.0);
        AnchorPane.setBottomAnchor(menuRecebimento, 23.0);
        AnchorPane.setLeftAnchor(menuRecebimento, 23.0);
        AnchorPane.setRightAnchor(menuRecebimento, 23.0);
        PaneMeio.getChildren().setAll(menuRecebimento);
    }
    
    /**
     * Ação para sair da tela atual.
     * Fecha a tela atual e abre a tela principal.
     */
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
