package br.com.faculdade.projetopoo.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe responsável por exibir a tela de verificação.
 * A tela de verificação é usada para autenticar e verificar a identidade do usuário
 * antes de permitir o acesso ao sistema.
 * @author joaog
 */
public class TelaVerificacao extends Application {


	private static Stage stage;
	public static Scene scene;

        /**
         * Inicia a aplicação, configurando a janela da tela de verificação.
         * @param t o estágio primário da aplicação
         * @throws Exception se ocorrer um erro ao carregar o arquivo FXML
         */
	@Override
	public void start(Stage t) throws Exception {
		stage = new Stage();
		
		stage.setResizable(false);

		Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaVerificacao.fxml"));
		scene = new Scene(painel);
                
                stage.setTitle("Tela Verificação"); 
                stage.getIcons().add(new Image(TelaPrincipal.class.getResourceAsStream( "gerenciamento-de-projetos.png" ))); 

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
	 * Obtém o estágio da janela da tela de verificação.
	 *
	 * @return o estágio da janela
	 */
	public static Stage getStage() {
		return stage;
	}

        /**
	 * Obtém a cena da tela de verificação.
	 *
	 * @return a cena da tela
	 */
	public static Scene getScene() {
		return scene;
	}

        /**
	 * Define a cena da tela de verificação.
	 *
	 * @param scene a cena da tela
	 */
	public static void setScene(Scene scene) {
		TelaVerificacao.scene = scene;
	}

}
