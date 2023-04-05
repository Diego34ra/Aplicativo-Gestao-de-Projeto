package br.com.faculdade.projetopoo.view;

import java.awt.event.MouseEvent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class TelaPrincipal extends Application {
    private static Stage stage;
    public static Scene scene;
    
    private double x = 0;
    private double y = 0;
    
    @Override
    public void start(Stage t) throws Exception {
        stage = new Stage();
        //desativando o botão maximixar e minimizar
        stage.setResizable(false);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaPrincipal.fxml"));
        scene = new Scene(painel);
        
        stage.setTitle("Tela inicial 1.0");
//        stage.getIcons().add(new Image(TelaLogin.class.getResourceAsStream( "icon.png" ))); 
        
        
        painel.setOnMousePressed((javafx.scene.input.MouseEvent event) ->{
        	x = event.getSceneX();
        	y = event.getSceneY();
        });
        
        painel.setOnMouseDragged((javafx.scene.input.MouseEvent event) ->{
        	stage.setX(event.getScreenX() - x);
        	stage.setY(event.getScreenY() - y);
        	
        	stage.setOpacity(.8);
        });
        
        painel.setOnMouseReleased((javafx.scene.input.MouseEvent event) ->{
        	stage.setOpacity(1);
        });
        		
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
        
        
        
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
        TelaPrincipal.scene = scene;
    }
    
}