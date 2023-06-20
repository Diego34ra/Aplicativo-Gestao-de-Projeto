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

/**
 * Classe responsável por exibir a tela principal do sistema.
 * A tela principal exibe a interface gráfica principal do sistema de gestão de projetos.
 * Ela é a primeira tela exibida ao iniciar a aplicação e geralmente contém um menu ou
 * painel de navegação para acessar outras funcionalidades do sistema.
 * @author joaog
 */
public class TelaPrincipal extends Application {
        public static Stage stage;
    public static Scene scene;
    
    /**
     * Inicia a aplicação, configurando a janela da tela principal.
     * @param t o estágio primário da aplicação
     * @throws Exception se ocorrer um erro ao carregar o arquivo FXML
     */
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
     * O método principal que inicia a aplicação.
     *
     * @param args os argumentos da linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Obtém o estágio da janela da tela principal.
     *
     * @return o estágio da janela
     */
    public static Stage getStage() {
        return stage;
    }
    
     /**
     * Obtém a cena da tela principal.
     *
     * @return a cena da tela
     */
    public static Scene getScene(){
        return scene;
    }
    
}