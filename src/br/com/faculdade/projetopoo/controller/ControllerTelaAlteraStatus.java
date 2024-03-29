/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.dao.StatusDao;
import br.com.faculdade.projetopoo.dao.TarefaDao;
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
import javafx.stage.Stage;

/**
 * Controller da tela de alteracao de status
 * @author Diego
 */
public class ControllerTelaAlteraStatus implements Initializable{
    
    @FXML
    private AnchorPane Pane;
    
    @FXML
    private TableView<Status> tbStatus;
    private final TableColumn cellStatusNome = new TableColumn("Status");
    
    /**
     * Acao do botao que altera o status
     */
    @FXML
    void getStatus() {
        int x = tbStatus.getSelectionModel().getSelectedIndex();
        
        Status status = tbStatus.getItems().get(x);
        switch (Global.alteraStatus) {
            case "Tarefa":
                if(Alertas.confirmacao("Atenção!", "Realmente deseja atualizar o status da tarefa?") == 1){
                    Global.tarefa.setStatus(status.getNome());
                    if(status.getNome().equals("Finalizado")){
                        Global.tarefa.setDataFinalizacao("NOW()");
                    } else { 
                        Global.tarefa.setDataFinalizacao("null");
                    }
                    TarefaDao tarefaService = new TarefaDao();
                    tarefaService.update(Global.tarefa);
                    Alertas.informacao("Sucesso!", "Status da tarefa atualizado com sucesso.");
                    Stage stage = (Stage) Pane.getScene().getWindow();
                    stage.close();
                }
                break;
            case "Projeto":
                if(Alertas.confirmacao("Atenção!", "Realmente deseja atualizar o status do Projeto?") == 1){
                StatusDao statusService = new StatusDao();
                Status statusProjeto = new Status(status.getNome(), status.getDescricao(), Global.projeto.getCodProjeto().toString());
                statusService.create(statusProjeto);
                Alertas.informacao("Sucesso!", "Status da Projeto atualizado com sucesso.");
                Stage stage = (Stage) Pane.getScene().getWindow();
                stage.close();
                }
                break;
        }
        
        
    }
    
    /**
     * Metodo que carrega a tabela de status 
     * @param list 
     */
    private void carregaTabelaStatus(ObservableList<Status> list){
        tbStatus.getColumns().clear();
        formataTabelaStatus();
        tbStatus.setItems(list);
        tbStatus.getColumns().addAll(cellStatusNome);
    }
    
    /**
     * Metodo que formata a tabela de status
     */
    private void formataTabelaStatus(){
        cellStatusNome.setMinWidth(200);
        cellStatusNome.setPrefWidth(295);
        cellStatusNome.setResizable(false);
        cellStatusNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellStatusNome.setStyle("-fx-alignment: center;");
    }

    /**
     * Metodo que inicializa o controller de alteracao de status
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregaTabelaStatus(FXCollections.observableArrayList(Global.tipoStatus()));
    }
    
}
