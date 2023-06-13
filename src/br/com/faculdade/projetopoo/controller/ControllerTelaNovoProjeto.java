/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.dao.ProjetoDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 2022101202010066
 */
public class ControllerTelaNovoProjeto implements Initializable {
    
    
    @FXML
    private TextField txNome;

    @FXML
    private TextField txDescricao;
    
    @FXML
    private AnchorPane Pane;

    @FXML
    void addProjeto() {
        ProjetoDao projetoService = new ProjetoDao();
        if(txNome.getText().isEmpty() || txDescricao.getText().isEmpty()){
            Alertas.informacao("Erro!", "Preencha todos os campos.");
        } else{
            projetoService.create(new Projeto(txNome.getText(), txDescricao.getText()));
            Alertas.informacao("Sucesso!", "Projeto Criado com sucesso.");
            Stage stage = (Stage) Pane.getScene().getWindow();
            stage.close();
        }
        
    }
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
