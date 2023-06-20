package br.com.faculdade.projetopoo.view;

import static br.com.faculdade.projetopoo.view.TelaPrincipal.stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe responsável por exibir a tela de alteração de senha.
 * Extende a classe Application do JavaFX para permitir a inicialização da aplicação.
 * @author joaog
 */
public class TelaAlterarSenha extends Application {

    private static Stage stage;
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
        stage = new Stage();

        stage.setMaxWidth(301);
        stage.setMaxHeight(388);
        //valor padrao da tela
        stage.setWidth(301);
        stage.setHeight(388);
        //para não diminuir
        stage.setMinWidth(301);
        stage.setMinHeight(388);

        stage.setResizable(false);

        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaAlterarSenha.fxml"));
        scene = new Scene(painel);

        stage.setTitle("Tela Recuperação");
        stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" )));    

//        stage.show();

        stage.setScene(scene);

        stage.setOnCloseRequest((WindowEvent t1) -> {
                t1.consume();
                stage.close();
        });
    }

     /**
     * Método principal da aplicação.
     * Inicia a aplicação JavaFX.
     * @param args 
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
    public static Scene getScene() {
        return scene;
    }

    /**
     * Define o objeto Scene da janela.
     * @param scene O objeto Scene a ser definido.
     */
    public static void setScene(Scene scene) {
        TelaCadastroUser.scene = scene;
    }

}
