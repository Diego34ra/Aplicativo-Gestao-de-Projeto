/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.dao.UsuarioDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 2022101202010058
 */
public class ControllerTelaConsultaUsuario implements Initializable{
    
    @FXML
    private AnchorPane Pane;
    
    @FXML
    private TableView<Usuario> tbUsuario;
    private final TableColumn cellUsuarioId = new TableColumn("Código");
    private final TableColumn cellUsuarioNome = new TableColumn("Nome");
    @FXML
    private ComboBox<String> cbConsulta;

    @FXML
    private TextField txConsulta;
    
    private ObservableList<Usuario> obj = null;

    @FXML
    void buscar() {
        switch (cbConsulta.getSelectionModel().getSelectedItem()) {
            case "Todos":
                obj = FXCollections.observableArrayList(UsuarioDao.findAll());
                break;
            case "Nome":
                obj = FXCollections.observableArrayList(UsuarioDao.findByName(txConsulta.getText()));
                break;
            case "Código":
                List<Usuario> lista= new ArrayList<>();
                Usuario usuario = UsuarioDao.findById(txConsulta.getText());
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
        formataTabelaProjeto();
        tbUsuario.setItems(list);
        tbUsuario.getColumns().addAll(cellUsuarioId,cellUsuarioNome);
    }
    
    private void formataTabelaProjeto(){
        cellUsuarioId.setMinWidth(100);
        cellUsuarioId.setPrefWidth(150);
        cellUsuarioId.setResizable(false);
        cellUsuarioId.setCellValueFactory (new PropertyValueFactory <> ( "codUsuario" ));
        cellUsuarioId.setCellFactory( cell -> {              
            return new TableCell<AbstractMethodError, Long>() {
                @Override
                protected void updateItem( Long item, boolean empty) {
                   super.updateItem(item, empty);
                   if(item == null|| empty) {
                       setText("");
                       setGraphic(null);
                   }else {
                        setText(item.toString());
                   }
                }
            };
         });
        cellUsuarioId.setStyle("-fx-alignment: center;");
        
        cellUsuarioNome.setMinWidth(200);
        cellUsuarioNome.setPrefWidth(350);
        cellUsuarioNome.setResizable(false);
        cellUsuarioNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellUsuarioNome.setStyle("-fx-alignment: center;");
    }
    
    @FXML
    void getUsuario(MouseEvent event) {
        int x = tbUsuario.getSelectionModel().getSelectedIndex();
        
        Global.consulta = tbUsuario.getItems().get(x);
        Stage stage = (Stage) Pane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbConsulta.getItems().addAll(Global.tipoConsulta("usuario"));
        
        cbConsulta.getSelectionModel().selectFirst();
    }
}
