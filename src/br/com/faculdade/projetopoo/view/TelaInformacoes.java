package br.com.faculdade.projetopoo.view;

import static br.com.faculdade.projetopoo.view.TelaPrincipal.stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe responsavel pela tela de informações do sistema
 * @author joaog
 */
public class TelaInformacoes extends Application {
    public static Stage stage;
    public static Scene scene;
    
    /**
     * Inicia a aplicação, configurando a janela de informações.
     * @param t o estágio primário da aplicação
     * @throws Exception se ocorrer um erro ao carregar o arquivo FXML
     */
    @Override
    public void start(Stage t) throws Exception {
        stage =  new Stage();
        
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        
        stage.setMinWidth(700);
        stage.setMinHeight(500);
        
        stage.setResizable(true);
        
        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaTeste.fxml"));
        
        scene = new Scene(painel);
        
        stage.setTitle("Gestão de Projetos");
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" ))); 
        
        stage.setScene(scene);
        
        stage.setOnCloseRequest((WindowEvent t1) -> {
            t1.consume();
            stage.close();
            Platform.exit();
            System.exit(0);
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
     * Obtém o estágio da janela da tela de informações.
     *
     * @return o estágio da janela
     */
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Obtém a cena da tela de informações.
     *
     * @return a cena da tela
     */
    public static Scene getScene(){
        return scene;
    }
    
}