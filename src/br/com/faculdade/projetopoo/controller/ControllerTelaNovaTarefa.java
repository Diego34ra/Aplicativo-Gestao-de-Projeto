/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Tarefa;
import br.com.faculdade.projetopoo.dao.TarefaDao;
import br.com.faculdade.projetopoo.view.TelaConsultaUsuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 2022101202010066
 */
public class ControllerTelaNovaTarefa implements Initializable{
   
    @FXML
    private AnchorPane Pane;
    
    @FXML
    private TextField txNome;

    @FXML
    private TextField txDescricao;

    @FXML
    private TextField txEncarregado;

    @FXML
    void add(ActionEvent event) {
        if(txDescricao.getText().isEmpty() || txNome.getText().isEmpty() || txEncarregado.getText().isEmpty()){
            Alertas.informacao("Erro!", "Preciso que preencha todos os campos.");
        } else {
            try {
                Tarefa tarefa = new Tarefa(txNome.getText(), txDescricao.getText(), Global.projeto, Global.consulta);
                TarefaDao tarefaService = new TarefaDao();
                tarefaService.create(tarefa);
                Alertas.informacao("Sucesso!", "Tarefa Criada com sucesso.");
                Stage stage = (Stage) Pane.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                Alertas.informacao("Erro!", "Houve um problema ao cadastrar a tarefa.");
                System.out.println(e);
            }
       }
    }
    
    @FXML
    void buscar() {
        TelaConsultaUsuario tela = new TelaConsultaUsuario();
        try {
            tela.start(new Stage());
            TelaConsultaUsuario.getStage().showAndWait();
        } catch (Exception ex) {
            System.out.println("Exception ao entrar na Tela de consulta de Usuario\n"+ex);
        }
        if(Global.consulta != null){
            txEncarregado.setText(Global.consulta.getNome());
            
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}


