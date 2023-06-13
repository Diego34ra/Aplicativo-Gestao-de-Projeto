package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.EmailService;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.dao.UsuarioDao;
import br.com.faculdade.projetopoo.view.TelaAlterarSenha;
import br.com.faculdade.projetopoo.view.TelaCadastroUser;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
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
    private AnchorPane Pane;
    
    @FXML
    private Button txEnviar;

    @FXML
    private TextField txCodigo;

    @FXML
    private Button btSair;

    private String codigo;
    
    private final UsuarioDao usuarioDao = new UsuarioDao();
    
    @FXML
    void enviarCodigo() throws NoSuchAlgorithmException {
        if(txCodigo.getText().equals(codigo)){
            switch (Global.tipoVerificacao) {
                case "Trocar Senha":
                    usuarioDao.update(Global.usuario,codigo);
                    TelaTrocarSenha tela = new TelaTrocarSenha();
                    try{
                        tela.start(new Stage());
                        TelaTrocarSenha.getStage().show();
                        Stage stage = (Stage) Pane.getScene().getWindow();
                        stage.close();
                    } catch(Exception e){
                        System.out.println("Exception ao criar a tela de alteração de senha \n"+e);
                    }
                    break;
                case "Cadastrar Usuario":
                    UsuarioDao service = new UsuarioDao();
                    service.createUsuario(Global.usuario);
                    Alertas.informacao("Sucesso", "Usuário cadastrado com sucesso.");
                    TelaPrincipal telaPrincipal = new TelaPrincipal();
                    try{
                        telaPrincipal.start(new Stage());
                        TelaPrincipal.getStage().show();
                        Stage stage = (Stage) Pane.getScene().getWindow();
                        stage.close();
                    } catch(Exception e){
                        System.out.println("Exception ao criar a tela principal\n"+e);
                    }
                    
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
    void voltar() {
        switch (Global.tipoVerificacao) {
            case "Trocar Senha":
                TelaAlterarSenha telaAlterarSenha = new TelaAlterarSenha();
                try {
                    telaAlterarSenha.start(new Stage());
                    TelaAlterarSenha.getStage().show();
                    //Fecha a tela atual
                    Stage stage = (Stage) Pane.getScene().getWindow();
                    stage.close();
                } catch (Exception ex) {
                    System.out.println("Erro ao abrir tela de recuperação de senha: " + ex.getMessage());
                }
                break;
            case "Cadastrar Usuario":
                TelaCadastroUser tela = new TelaCadastroUser();
                try {
                    tela.start(new Stage());
                    TelaCadastroUser.getStage().show();
                    //Fecha a tela atual
                    Stage stage = (Stage) Pane.getScene().getWindow();
                    stage.close();
                } catch (Exception ex) {
                    System.out.println("Exception ao criar a tela de cadastro\n"+ex);
                }
                break;
            }
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
