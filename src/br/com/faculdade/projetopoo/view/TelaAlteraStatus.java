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
 * Classe responsável por exibir a tela de alteração de status.
 * Extende a classe Application do JavaFX para permitir a inicialização da aplicação.
 * @author joaog
 */
public class TelaAlteraStatus extends Application{
    
    public static Stage stage;
    public static Scene scene;
    
     /**
     * Método de inicialização da tela.
     * Configura o tamanho e as propriedades da janela.
     * Carrega o arquivo FXML da interface gráfica.
     * Define o título da janela e o ícone.
     * Define o comportamento de fechamento da janela.
     */
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
     *  Método principal da aplicação.
     * Inicia a aplicação JavaFX.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Obtém o objeto Stage da janela.
     * @return O objeto Stage da janela.
     */
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Obtém o objeto Scene da janela.
     * @return O objeto Scene da janela.
     */
    public static Scene getScene(){
        return scene;
    }
}
