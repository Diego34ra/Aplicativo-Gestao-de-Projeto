package br.com.faculdade.projetopoo.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TelaCadastroUser extends Application {

	private static Stage stage;
	public static Scene scene;

	@Override
	public void start(Stage t) throws Exception {
		stage = new Stage();
		
		stage.setResizable(false);

		Parent painel = FXMLLoader.load(getClass().getResource("FXMLCadastrarUser.fxml"));
		scene = new Scene(painel);

		stage.setTitle("Tela Cadastro 1.0");
//	        stage.getIcons().add(new Image(TelaLogin.class.getResourceAsStream( "icon.png" ))); 

		stage.show();

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

	public static Scene getScene() {
		return scene;
	}

	public static void setScene(Scene scene) {
		TelaCadastroUser.scene = scene;
	}

}
