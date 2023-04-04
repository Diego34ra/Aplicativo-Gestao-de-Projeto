package br.com.faculdade.projetopoo.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TelaLogin extends Application {
    private static Stage stage;
    public static Scene scene;
    
    @Override
    public void start(Stage t) throws Exception {
        stage = new Stage();
        //para não esticar as laterais
        stage.setMaxWidth(420);
        stage.setMaxHeight(390);
        //valor padrao da tela
        stage.setWidth(420);
        stage.setHeight(390);
        //para não diminuir
        stage.setMinWidth(420);
        stage.setMinHeight(390);
        //desativando o botão maximixar e minimizar
        stage.setResizable(false);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaLogin.fxml"));
        scene = new Scene(painel);
        
        stage.setTitle("Login Integração b2b");
//        stage.getIcons().add(new Image(TelaLogin.class.getResourceAsStream( "icon.png" ))); 
        
        stage.show();
        
        stage.setScene(scene);
        
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

    public static void setScene(Scene scene) {
        TelaLogin.scene = scene;
    }
    
}