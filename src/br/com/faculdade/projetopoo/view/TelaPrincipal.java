package br.com.faculdade.projetopoo.view;

import br.com.faculdade.projetopoo.Initialize;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TelaPrincipal extends Application {
        public static Stage stage;
    public static Scene scene;
    
    public void start(Stage t) throws Exception {
        stage = new Stage();
        //para não esticar as laterais
        stage.setMaxWidth(323);
        stage.setMaxHeight(426);
        //valor padrao da tela
        stage.setWidth(323);
        stage.setHeight(426);
        //para não diminuir
        stage.setMinWidth(323);
        stage.setMinHeight(426);
        //desativando o botão maximixar e minimizar
        stage.setResizable(false);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaPrincipal.fxml"));
        scene = new Scene(painel);
        
        stage.setTitle("Gestão de Projeto");
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" ))); 
        stage.show();
        
        stage.setScene(scene);
        
//        Initialize init = new Initialize();
//        init.generateDB();
        
        stage.setOnCloseRequest((WindowEvent t1) -> {
            t1.consume();
            stage.close();
            Platform.exit();
            System.exit(0);
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