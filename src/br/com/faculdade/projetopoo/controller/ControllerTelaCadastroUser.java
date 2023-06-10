package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.services.UsuarioService;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
import br.com.faculdade.projetopoo.view.TelaVerificacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerTelaCadastroUser implements Initializable {

    @FXML
    private AnchorPane Pane;
    
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
        if (UsuarioService.validateEmail(txEmail.getText())) {
            if(!UsuarioService.findByEmail(txEmail.getText()).getEmail().equals("")){
                Alertas.informacao("E-mail inválido!", "O E-mail Informado já está cadastrado.");
                valida = false;
            }
        } else {
            Alertas.informacao("E-mail inválido!", "O E-mail Informado não tem um formato correto.");
            valida = false;
        }
        if(!UsuarioService.validateCpf(txCpf.getText()).equals("")){
            if (!UsuarioService.findByCpf(txCpf.getText()).getCpf().equals("")) {
                valida = false;
                Alertas.informacao("Cpf inválido!", "O Cpf Informado já está cadastrado.");
           }   
        } else {
            Alertas.informacao("Cpf inválido!", "O Cpf Informado não tem um formato correto.");
            valida = false;
        }
        if (valida) {
            Global.email = txEmail.getText();
            Global.tipoVerificacao = "Cadastrar Usuario";
            TelaVerificacao tela = new TelaVerificacao();
            try {
                Global.usuario = new Usuario( txCpf.getText(),txEmail.getText(),
                                              txNome.getText(), psSenha.getText());
                tela.start(new Stage());
                TelaVerificacao.getStage().showAndWait();
                if(Global.validar){
                    Alertas.informacao("Sucesso", "Usuário cadastrado com sucesso.");
                }
            } catch (Exception ex) {
                System.out.println("Exception ao criar a tela de cadastro\n"+ex);
            }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // TODO Auto-generated method stub	
    }

}
