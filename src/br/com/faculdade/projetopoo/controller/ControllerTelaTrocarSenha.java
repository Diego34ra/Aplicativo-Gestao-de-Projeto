/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.dao.UsuarioDao;
import br.com.faculdade.projetopoo.view.TelaPrincipal;
import br.com.faculdade.projetopoo.view.TelaVerificacao;
import java.security.NoSuchAlgorithmException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller da tela de troca de senha.
 * Responsável por gerenciar os eventos e ações na tela de troca de senha.
 * @author Diego
 */
public class ControllerTelaTrocarSenha {
    
    @FXML
    private PasswordField pwSenha;

    @FXML
    private AnchorPane Pane;

    @FXML
    private PasswordField pwSenha1;

    @FXML
    private Button salvar;
    
    UsuarioDao usuarioDao = new UsuarioDao();
    
    /**
     * Ação do botão "Salvar".
     * Verifica se as senhas digitadas são iguais e atualiza a senha do usuário.
     * Exibe uma mensagem de sucesso e abre a tela principal.
     * Fecha a tela atual.
     */
    @FXML
    void salvar(){
        if(pwSenha.getText().equals(pwSenha1.getText())){
            usuarioDao.updateSenha(Global.usuario, pwSenha.getText());
            Alertas.informacao("Sucesso!", "Senha alterada com sucesso.");
            TelaPrincipal tela = new TelaPrincipal();
            try{
                tela.start(new Stage());
                TelaPrincipal.getStage().showAndWait();
            } catch(Exception e){
                System.out.println("Exception ao criar a tela principal\n"+e);
            }
            Stage stage = (Stage) Pane.getScene().getWindow();
            stage.close();
        } else {
            Alertas.informacao("Erro!", "As senhas digitadas não são iguais.");
        }
    }
    
    /**
     * Ação do botão "Voltar".
     * Abre a tela de verificação.
     * Fecha a tela atual.
     */
     @FXML
    void voltar() {
        try{
            TelaVerificacao telaVerificacao = new TelaVerificacao();
            telaVerificacao.start(new Stage());
            TelaVerificacao.getStage().show();
            Stage stage = (Stage) Pane.getScene().getWindow();
            stage.close();
        } catch(Exception e){
            System.out.println("Exception ao criar a tela de alteracao de senha \n"+e);
        } 
    }
}
