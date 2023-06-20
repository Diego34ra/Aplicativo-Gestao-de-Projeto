package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Global;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Controller para a tela de perfil do usuário.
 * @author joaog
 */
public class ControllerTelaPerfilUsuario implements Initializable{
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private HBox hbox;
    
    @FXML
    private Label txNome;

    @FXML
    private Label txEmail;

    @FXML
    private Label txCpf;

    /**
     * Fecha a tela atual.
     */
    @FXML
    void fechar() {
        //Fecha a tela atual
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String cpf = Global.usuario.getCpf();
        txEmail.setText(Global.usuario.getEmail());
        txNome.setText(Global.usuario.getNome());
        txCpf.setText(cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11));
    }
}

