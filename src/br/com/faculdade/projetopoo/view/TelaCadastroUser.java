package br.com.faculdade.projetopoo.view;

import static br.com.faculdade.projetopoo.view.TelaPrincipal.stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe responsavel por exibir a tela de cadastro do usuario
 * @author joaog
 */
public class TelaCadastroUser extends Application {

    private static Stage stage;
    public static Scene scene;

    /**
     * Inicia a aplicação, configurando a janela de cadastro do usuário.
     * @param t o estágio primário da aplicação
     * @throws Exception  Exception se ocorrer um erro ao carregar o arquivo FXML
     */
    @Override
    public void start(Stage t) throws Exception {
        stage = new Stage();

        stage.setMaxWidth(458);
        stage.setMaxHeight(365);
        //valor padrao da tela
        stage.setWidth(458);
        stage.setHeight(365);
        //para não diminuir
        stage.setMinWidth(458);
        stage.setMinHeight(365);

        stage.setResizable(false);

        Parent painel = FXMLLoader.load(getClass().getResource("FXMLCadastrarUser.fxml"));
        scene = new Scene(painel);

        stage.setTitle("Tela Cadastro");
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" ))); 

        stage.show();

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
     * Obtém o estágio da janela da tela de cadastro.
     *
     * @return o estágio da janela
     */
    public static Stage getStage() {
            return stage;
    }

    /**
     * Obtém a cena da tela de cadastro.
     *
     * @return a cena da tela
     */
    public static Scene getScene() {
            return scene;
    }

     /**
     * Define a cena da tela de cadastro.
     *
     * @param scene a cena a ser definida
     */
    public static void setScene(Scene scene) {
            TelaCadastroUser.scene = scene;
    }

}
