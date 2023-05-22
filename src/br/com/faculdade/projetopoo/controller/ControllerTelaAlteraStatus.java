/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Status;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Diego
 */
public class ControllerTelaAlteraStatus implements Initializable{
    @FXML
    private TableView<Status> tbStatus;
    private final TableColumn cellStatusNome = new TableColumn("Status");
    
    @FXML
    void getStatus() {

    }
    
    private void carregaTabelaTarefa(ObservableList<Status> list){
        tbStatus.getColumns().clear();
        formataTabelaTarefa();
        tbStatus.setItems(list);
        tbStatus.getColumns().addAll(cellStatusNome);
    }
    
    private void formataTabelaTarefa(){
        cellStatusNome.setMinWidth(200);
        cellStatusNome.setPrefWidth(295);
        cellStatusNome.setResizable(false);
        cellStatusNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellStatusNome.setStyle("-fx-alignment: center;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregaTabelaTarefa(FXCollections.observableArrayList(Global.tipoStatus()));
    }
    
}
