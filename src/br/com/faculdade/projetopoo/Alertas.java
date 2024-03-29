/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.view.TelaPrincipal;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class Alertas {
    
    /**
     * Metodo que chama uma tela de confirmacao
     * @param cabeca cabeçalho da tela de confimacao
     * @param corpo frase de confirmacao
     * @return retorna a confirmacao do usuario
     */
    public static Integer confirmacao(String cabeca,String corpo){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Gestão de Projetos");
        alert.setHeaderText(cabeca);
        alert.setContentText(corpo);
        
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        ButtonType cancela = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" )));
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
    /**
     * Metodo que chama uma tela de informacao
     * @param cabeca cabecalho da tela de informacao
     * @param corpo frase de informacao
     */
    public static void informacao(String cabeca,String corpo){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gestão de Projetos");
        alert.setHeaderText(cabeca);
        alert.setContentText(corpo);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" )));
        alert.showAndWait();
    }
}
