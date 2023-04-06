package br.com.faculdade.projetopoo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.services.EmailService;
import br.com.faculdade.projetopoo.services.UsuarioService;
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
        void cadastrar(ActionEvent event) {
            boolean valida = true;
            if(!UsuarioService.findByEmail(txEmail.getText()).getEmail().equals("")){
                System.out.println("E-mail já cadastrado");
                valida = false;
            }  else if(!UsuarioService.findByCpf(txCpf.getText()).getCpf().equals("")){
                System.out.println("Cpf já cadastrado");
                valida = false;
            }
            if (valida) {
                Random random = new Random();
                String codigo = String.valueOf((long)(random.nextDouble() * 10000L));
                EmailService email = new EmailService();
                String destinatario [] = {txEmail.getText()};
                email.sendEmail("Código de verificação", destinatario, codigo);
                Scanner scan = new Scanner(System.in);
                String cod = scan.nextLine();
                if(codigo.equals(cod)){
                    Usuario usuario = new Usuario( txCpf.getText(),txEmail.getText(),
                                              txNome.getText(), psSenha.getText());
                    UsuarioService.createUsuario(usuario);
                    System.out.println("Usuario cadastrado com sucesso");
                } else {
                    System.out.println("codigo de verificação incorreto");
                }
            }
        }
        
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub	
	}

}
