package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.services.EmailService;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerCodigoVerificacao implements Initializable {
	
    @FXML
    private AnchorPane painel;
    
    @FXML
    private Button txEnviar;

    @FXML
    private TextField txCodigo;

    @FXML
    private Button btSair;

    private String codigo;
    
    @FXML
    void enviarCodigo() {
        if(txCodigo.getText().equals(codigo)){
            Global.valida = true;
            System.out.println("status = "+Global.valida);
            Stage stage = (Stage) painel.getScene().getWindow();
            stage.close();
        } else {
            codigo = "";
            if(Alertas.confirmacao("Codigo Invalido!", "Deseja receber outro codigo ?") == 1){
                codigo = gerarCodigo();
            }
        }
    }

    @FXML
    void btSair(ActionEvent event) {
        Stage stage = (Stage) painel.getScene().getWindow();
        stage.close();
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codigo = gerarCodigo();
    }
    
    public static String gerarCodigo (){
        Random random = new Random();
        String codigo = String.valueOf((long)(random.nextDouble() * 10000L));
        EmailService email = new EmailService();
        String destinatario [] = {Global.email};
        email.sendEmail("Código de verificação", destinatario, codigo);
        return codigo;
    }

}
