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
 * Classe responsável por exibir a tela de tarefas.
 * A tela de tarefas exibe a lista de tarefas do sistema de gerenciamento de projetos.
 * Ela permite ao usuário visualizar, adicionar, editar ou excluir tarefas relacionadas a um projeto.
 * @author joaog
 */
public class TelaTarefa extends Application {
    
    public static Stage stage;
    public static Scene scene;
    
    /**
     * Inicia a aplicação, configurando a janela da tela de tarefas.
     * @param t o estágio primário da aplicação
     * @throws Exception se ocorrer um erro ao carregar o arquivo FXML
     */
    @Override
    public void start(Stage t) throws Exception {
        stage =  new Stage();
        
        stage.setWidth(1355);
        stage.setHeight(410);
        
        stage.setMinWidth(1355);
        stage.setMinHeight(410);
        
//        stage.setMaxWidth(608);
//        stage.setMaxHeight(443);
        
        stage.setResizable(false);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaTarefa.fxml"));
        
        scene = new Scene(painel);
        
        stage.setTitle("Tarefas");
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
     * Obtém o estágio da janela da tela de tarefas.
     *
     * @return o estágio da janela
     */
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Obtém a cena da tela de tarefas.
     *
     * @return a cena da tela
     */
    public static Scene getScene(){
        return scene;
    }
}
