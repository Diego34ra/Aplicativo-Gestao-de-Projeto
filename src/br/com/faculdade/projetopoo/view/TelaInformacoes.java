package br.com.faculdade.projetopoo.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class TelaInformacoes extends Application {

	private static Stage stage;
	public static Scene scene;
	
	 @Override
	    public void start(Stage t) throws Exception {
	        stage = new Stage();
	        //desativando o botão maximixar e minimizar
	        stage.setResizable(false);
	        
	        Parent painel = FXMLLoader.load(getClass().getResource("FXMLTelaInformacoes.fxml"));
	        scene = new Scene(painel);
	        
	        stage.setTitle("Informações");
	        
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
	        TelaInformacoes.scene = scene;
	    }

}
