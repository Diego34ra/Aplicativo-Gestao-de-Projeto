package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.services.EmailService;
import br.com.faculdade.projetopoo.services.UsuarioService;
import br.com.faculdade.projetopoo.view.TelaTrocarSenha;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerCodigoVerificacao implements Initializable {
	
    @FXML
    private AnchorPane painel;
    
    @FXML
    private Button txEnviar;

    @FXML
    private TextField txCodigo;

    @FXML
    private Button btSair;

    private String codigo;
    
    @FXML
    void enviarCodigo() throws NoSuchAlgorithmException {
        if(txCodigo.getText().equals(codigo)){
            switch (Global.tipoVerificacao) {
                case "Trocar Senha":
                    TelaTrocarSenha tela = new TelaTrocarSenha();
                    try{
                        tela.start(new Stage());
                        TelaTrocarSenha.getStage().show();
                        Stage stage = (Stage) painel.getScene().getWindow();
                        stage.close();
                    } catch(Exception e){
                        System.out.println("Exception ao criar a tela de alteração de senha \n"+e);
                    }
                    break;
                case "Cadastrar Usuario":
                    UsuarioService service = new UsuarioService();
                    service.createUsuario(Global.usuario);
                    Global.validar = true;
                    Stage stage = (Stage) painel.getScene().getWindow();
                    stage.close();
                    break;
                default:
                    throw new AssertionError();
            }
            
        } else {
            codigo = "";
            if(Alertas.confirmacao("Codigo Invalido!", "Deseja receber outro codigo ?") == 1){
                codigo = gerarCodigo();
            }
        }
    }

    @FXML
    void btSair() {
        Stage stage = (Stage) painel.getScene().getWindow();
        stage.close();
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codigo = gerarCodigo();
    }
    
    public static String gerarCodigo (){
        Random random = new Random();
        String codigo = String.valueOf((long)(random.nextDouble() * 10000L));
        System.out.println("codigo = " + codigo);
        EmailService email = new EmailService();
        String destinatario [] = {Global.email};
        email.sendEmail("Código de verificação", destinatario, codigo);
        return codigo;
    }

}
