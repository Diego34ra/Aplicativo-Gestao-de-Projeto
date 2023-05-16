/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.services.UsuarioService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author 2022101202010058
 */
public class ControllerTelaConsultaUsuario implements Initializable{
    
    @FXML
    private TableView<Usuario> tbUsuario;

    @FXML
    private ComboBox<String> cbConsulta;

    @FXML
    private TextField txConsulta;
    
    private ObservableList<Usuario> obj = null;

    @FXML
    void buscar() {
//        ObservableList<Projeto> obj = null;
        switch (cbConsulta.getSelectionModel().getSelectedItem()) {
            case "Todos":
                obj = FXCollections.observableArrayList(UsuarioService.findAll());
                break;
            case "Nome":
                obj = FXCollections.observableArrayList(UsuarioService.findByName(txConsulta.getText()));
                break;
            case "Código":
                List<Usuario> lista= new ArrayList<>();
                Usuario usuario = UsuarioService.findById(txConsulta.getText());
                if(!usuario.getCodUsuario().equals(0L)){
                    lista.add(usuario);
                }
                obj = FXCollections.observableArrayList(lista);
                break;
        }
        carregaTabelaProjeto(obj);
    }

    private void carregaTabelaProjeto(ObservableList<Usuario> list){
        tbUsuario.getColumns().clear();
//        formataTabelaProjeto();
        tbUsuario.setItems(list);
//        tbUsuario.getColumns().addAll(cellProTarefas,cellProId,cellProNome,cellProDescricao,cellProStatus,cellProDtCriacao,cellProDelete);
    }
    
    @FXML
    void getUsuario() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbConsulta.getItems().addAll(Global.tipoConsulta("usuario"));
        
        cbConsulta.getSelectionModel().selectFirst();
    }
}
