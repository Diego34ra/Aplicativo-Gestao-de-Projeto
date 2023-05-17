/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author 2022101202010066
 */
public class TelaConsultaUsuario extends Application{
    
    public static Stage stage;
    public static Scene scene;
    
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
//        stage.getIcons().add(new Image(TelaInicial.class.getResourceAsStream( "icon.png" ))); 
        
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
