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
 *
 * @author Diego
 */
public class TelaAlteraStatus extends Application{
    
    public static Stage stage;
    public static Scene scene;
    
    @Override
    public void start(Stage t) throws Exception {
        stage =  new Stage();
        
        stage.setWidth(300);
        stage.setHeight(200);
        
        stage.setMinWidth(300);
        stage.setMinHeight(200);
        
        stage.setMaxWidth(300);
        stage.setMaxHeight(200);
        
        stage.setResizable(false);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaAlteraStatus.fxml"));
        
        scene = new Scene(painel);
        
        stage.setTitle("Alterar Status");
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" ))); 
        
        stage.setScene(scene);
        
        stage.setOnCloseRequest((WindowEvent t1) -> {
            t1.consume();
            stage.close();
        });
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getStage() {
        return stage;
    }
    
    public static Scene getScene(){
        return scene;
    }
}
