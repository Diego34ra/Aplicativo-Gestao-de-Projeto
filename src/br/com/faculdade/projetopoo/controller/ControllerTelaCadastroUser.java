package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Global;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.services.EmailService;
import br.com.faculdade.projetopoo.services.UsuarioService;
import br.com.faculdade.projetopoo.view.TelaVerificacao;
import java.util.Random;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerTelaCadastroUser implements Initializable {

        @FXML
        private TextField txNome;

        @FXML
        private TextField txCpf;

        @FXML
        private TextField txEmail;

        @FXML
        private PasswordField psSenha;

        @FXML
        private Button btCadastrarUser;

        private Usuario usuario;

        @FXML
        void cadastrar() {
            boolean valida = true;
            if(!UsuarioService.findByEmail(txEmail.getText()).getEmail().equals("")){
                System.out.println("E-mail já cadastrado");
                valida = false;
            }  else if(!UsuarioService.findByCpf(txCpf.getText()).getCpf().equals("")){
                System.out.println("Cpf já cadastrado");
                valida = false;
            }
            if (valida) {
                Global.email = txEmail.getText();
                TelaVerificacao tela = new TelaVerificacao();
                try {
                    tela.start(new Stage());
                    TelaVerificacao.getStage().show();
                } catch (Exception ex) {
                    System.out.println("Exception ao criar a tela de cadastro\n"+ex);
                } 
            }
            System.out.println("valor do global = "+Global.valida);
                if(Global.valida){
                    Usuario usuario = new Usuario( txCpf.getText(),txEmail.getText(),
                                              txNome.getText(), psSenha.getText());
                    UsuarioService.createUsuario(usuario);
                    System.out.println("Usuario cadastrado com sucesso");
                } 
        }
        
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub	
	}

}
