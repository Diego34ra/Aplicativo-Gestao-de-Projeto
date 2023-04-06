/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class Alertas {
    public static Integer confirmacao(String cabeca,String corpo){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Gestão de Projetos");
        alert.setHeaderText(cabeca);
        alert.setContentText(corpo);
        
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        ButtonType cancela = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(new Image(TelaLogin.class.getResourceAsStream( "icon.png" )));
        alert.getButtonTypes().setAll(sim, nao, cancela);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == sim){
            return 1;
        } else if (result.get() == nao) {
            return 2;
        } else {
            return 0;
        }
    }
    
    public static void alertaInformacao(String cabeca,String corpo){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gestão de Projetos");
        alert.setHeaderText(cabeca);
        alert.setContentText(corpo);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(new Image(TelaLogin.class.getResourceAsStream( "icon.png" )));
        alert.showAndWait();
    }
}
