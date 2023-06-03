package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.services.UsuarioService;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
import br.com.faculdade.projetopoo.view.TelaTrocarSenha;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerTelaAlterarSenha {

    @FXML
    private AnchorPane Pane;

    @FXML
    private Button txAlterarSenha;

    @FXML
    private TextField txEmail;
    
    private final UsuarioService usuarioService = new UsuarioService();

    @FXML
    void alterar() {
        
        if(!txEmail.getText().equals("")){
            Usuario usuario = new Usuario();
            usuario = usuarioService.findByEmail(txEmail.getText());
            if(!usuario.getEmail().equals("")){
                TelaTrocarSenha tela = new TelaTrocarSenha();
                try{
                    tela.start(new Stage());
                    TelaTrocarSenha.getStage().showAndWait();
                } catch(Exception e){
                    System.out.println("Exception ao criar a tela de alteração de senha \n"+e);
                }
            } else{
                Alertas.informacao("Erro!", "Não foi encontrado nenhum usuário cadastrado com esse E-mail.");
            }
            
        } else{
            Alertas.informacao("Erro!", "Deve ser informado algo no Campo de E-mail.");
        }
    }

    @FXML
    void voltar() {
        TelaPrincipal tela = new TelaPrincipal();
        try{
            tela.start(new Stage());
            TelaPrincipal.getStage().showAndWait();
        } catch(Exception e){
            System.out.println("Exception ao criar a tela principal\n"+e);
        }
        //Fecha a tela atual
        Stage stage = (Stage) Pane.getScene().getWindow();
        stage.close();
    }

}
