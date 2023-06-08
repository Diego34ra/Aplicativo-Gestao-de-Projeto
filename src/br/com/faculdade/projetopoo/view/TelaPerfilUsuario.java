package br.com.faculdade.projetopoo.view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author joaog
 */
public class TelaPerfilUsuario extends Application {
    public static Stage stage;
    public static Scene scene;
    
    @Override
    public void start(Stage t) throws Exception {
        stage =  new Stage();
        
       // stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
       // stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        
     /*   stage.setMinWidth(700);
        stage.setMinHeight(500);
        
        stage.setResizable(false);*/
     
        //para não esticar as laterais
        stage.setMaxWidth(700);
        stage.setMaxHeight(600);
        //valor padrao da tela
        stage.setWidth(700);
        stage.setHeight(600);
        //para não diminuir
        stage.setMinWidth(700);
        stage.setMinHeight(600);
        //desativando o botão maximixar e minimizar
        stage.setResizable(false);
        
        stage.initStyle(StageStyle.UNDECORATED);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaPerfilUsuario.fxml"));
        
        scene = new Scene(painel);
        
        stage.setTitle("Perfil Usuário");
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