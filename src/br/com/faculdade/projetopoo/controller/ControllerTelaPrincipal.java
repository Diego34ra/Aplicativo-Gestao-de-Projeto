/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Diego
 */
public class ControllerTelaPrincipal implements Initializable {    
   
	
    @FXML
    private Button btSair;

    @FXML
    private Button btTelaCadastro;

    @FXML
    private Button btTelaLogin;

    @FXML
    private PasswordField txSenha;

    @FXML
    private TextField txEmail;

    @FXML
    private Label txRecuperaSenha;

    @FXML
    void recuperarSenha() {
        System.out.println("recuperar senha");
    }
    @FXML
    void logar() {

    }
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
	
	
	
	
	
	
	
	
	
	/*@FXML
    private Pane painel;
    
    @FXML
    protected TextField txCodigo;

    @FXML
    protected TextField txUsuario;

    @FXML
    protected PasswordField txSenha;

    @FXML
    protected Button btLogin;

    @FXML
    protected ComboBox<String> cbIntegradora;

    @FXML
    protected Label lbSenha;
    
//    ProdutoSystemBean item = new ProdutoSystemBean();
    
    
    
    @FXML
    protected void tecla(KeyEvent event){
        
    }
       
    /**
     * Função para validar o acesso do operador e da produtoFab
     */
  /*  @FXML
    protected void logar() {
        
    }
    
    @FXML
    protected void validaNumero(){
        
    }
    
    @FXML
    protected void consultaCodigoUsuario(){
        
    }
    
    @FXML
    protected void consultaUsuario(){
        
    }
    
    /**
     * Confirma a senha digitada
     * @param senha descricao
     * @return  descricao
     */
  /*  private Boolean validaSenha(String senha){
        return true;
    }

    /**
     * Veririca a permissão para o usuario na filial
     */
//    private void iniciaTela(){
//        TelaInicial tela = new TelaInicial();
//        try {
//            tela.start(new Stage());
//            TelaInicial.getStage().show();
//        } catch (Exception ex) {
//            System.out.println("br.com.lopesecia.integracaoIfc.controller.ControllerTelaLogin.iniciaTela() Exception ao criar a nova tela\n"+ex);
//        }
//        
//        //Fecha a tela atual
//        Stage stage = (Stage) painel.getScene().getWindow();
//        stage.close();
//    }
    
    /**
     * Apresentação da tela inicial
     */
   /* private void comportamentoInicial(){
        lbSenha.setVisible(false);
        txSenha.setVisible(false);
        txSenha.setEditable(false);
        btLogin.setVisible(false);
    }
    
    /**
     * Apresentação da tela com operador validado
     */
   /* private void comportamentoValidandoUsuario(){
        lbSenha.setVisible(true);
        txSenha.setVisible(true);
        txSenha.setEditable(true);
        btLogin.setVisible(true);
        txSenha.requestFocus();
    }*/
    
    /**
     * Verifica o nome informado na tela
     * @param matricula campo também pode 0, se nome estiver preenchido
     * @param nome campo também pode null, se matricula estiver preenchido
     * @param metodo dever ser preenchido como @codigo ou como @nome
     * @return  descricao
     */
   /* private Boolean verificarUsuario(Integer matricula,String nome, String metodo){
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
 */
}