/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.view;

import static br.com.faculdade.projetopoo.view.TelaPrincipal.stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Tela de consulta do usuario
 * @author 2022101202010066
 */
public class TelaConsultaUsuario extends Application{
    
    public static Stage stage;
    public static Scene scene;
    
    /**
     * Inicia a aplicação, configurando a janela de consulta de usuário.
     * @param t o estágio primário da aplicação
     * @throws Exception se ocorrer um erro ao carregar o arquivo FXML
     */
    @Override
    public void start(Stage t) throws Exception {
        stage =  new Stage();
        
        stage.setWidth(600);
        stage.setHeight(440);
        
        stage.setMinWidth(600);
        stage.setMinHeight(440);
        
        stage.setMaxWidth(600);
        stage.setMaxHeight(440);
        
        stage.setResizable(false);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaConsultaUsuario.fxml"));
        
        scene = new Scene(painel);
        
        stage.setTitle("Consulta Usuario");
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" ))); 
        
        stage.setScene(scene);
        
        stage.setOnCloseRequest((WindowEvent t1) -> {
            t1.consume();
            stage.close();
        });
        
    }

   /**
     * O método principal que inicia a aplicação.
     *
     * @param args os argumentos da linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Obtém o estágio da janela da tela de consulta de usuário.
     *
     * @return o estágio da janela
     */
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Obtém a cena da tela de consulta de usuário.
     *
     * @return a cena da tela
     */
    public static Scene getScene(){
        return scene;
    }
}
