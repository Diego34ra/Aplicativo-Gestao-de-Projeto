package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.dao.UsuarioDao;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
import br.com.faculdade.projetopoo.view.TelaVerificacao;
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
    
    private final UsuarioDao usuarioService = new UsuarioDao();

    @FXML
    void alterar() { 
        if(!txEmail.getText().equals("")){
            Usuario usuario = new Usuario();
            usuario = usuarioService.findByEmail(txEmail.getText());
            Global.email = txEmail.getText();
            Global.usuario = usuario;
            if(!usuario.getEmail().equals("")){
                TelaVerificacao telaVerificacao = new TelaVerificacao();
                Global.tipoVerificacao = "Trocar Senha";
                try{
                    telaVerificacao.start(new Stage());
                    TelaVerificacao.getStage().show();
                    Stage stage = (Stage) Pane.getScene().getWindow();
                    stage.close();
                } catch(Exception e){
                    System.out.println("Exception ao criar a tela de alteracao de senha \n"+e);
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
