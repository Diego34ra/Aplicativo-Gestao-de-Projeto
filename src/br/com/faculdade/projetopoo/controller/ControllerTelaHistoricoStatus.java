/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.dao.StatusDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *  Controller da tela que exibe o histórico de status de um projeto.
 * @author 2022101202010058
 */
public class ControllerTelaHistoricoStatus implements Initializable{
    @FXML
    private AnchorPane Pane;

    @FXML
    private TableView<Status> tbStatus;
    private final TableColumn cellStatusNome = new TableColumn("Nome");
    private final TableColumn cellStatusDescricao = new TableColumn("Descrição");
    private final TableColumn cellStatusData = new TableColumn("Data de alteração");

    private final StatusDao StatusService = new StatusDao();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregaTabelaHistorico(FXCollections.observableArrayList(StatusService.findById(Global.projeto.getCodProjeto())));
    }
    /**
     * Carrega o histórico de status na tabela.
     * @param list A lista de status a ser exibida na tabela.
     */
    private void carregaTabelaHistorico(ObservableList<Status> list){
        tbStatus.getColumns().clear();
        formataTabelaHistorico();
        tbStatus.setItems(list);
        tbStatus.getColumns().addAll(cellStatusNome,cellStatusDescricao,cellStatusData);
    }
    
    /**
     * Formata as colunas na tabela de histórico.
     */
    private void formataTabelaHistorico(){
        cellStatusNome.setMinWidth(100);
        cellStatusNome.setPrefWidth(110);
        cellStatusNome.setResizable(false);
        cellStatusNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellStatusNome.setStyle("-fx-alignment: center;");
        
        cellStatusDescricao.setMinWidth(200);
        cellStatusDescricao.setPrefWidth(300);
        cellStatusDescricao.setResizable(false);
        cellStatusDescricao.setCellValueFactory (new PropertyValueFactory <> ( "descricao" ));
        cellStatusDescricao.setStyle("-fx-alignment: center;");
        
        cellStatusData.setMinWidth(200);
        cellStatusData.setPrefWidth(300);
        cellStatusData.setResizable(false);
        cellStatusData.setCellValueFactory (new PropertyValueFactory <> ( "dataHora" ));
        cellStatusData.setStyle("-fx-alignment: center;");
    }
}
