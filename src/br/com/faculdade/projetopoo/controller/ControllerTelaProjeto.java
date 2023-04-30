/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.services.ProjetoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Diego
 */
public class ControllerTelaProjeto {
    
    
    @FXML
    private TableView<Projeto> tbProjeto;
    private final TableColumn cellProId = new TableColumn("Código");
    private final TableColumn cellProNome = new TableColumn("Nome");
    private final TableColumn cellProDtCriacao = new TableColumn("Data de Criação");
    private final TableColumn cellProDescricao = new TableColumn("Descrição");
    private final TableColumn cellProStatus = new TableColumn("Status");
//    private final TableColumn<ClienteBean,ClienteBean> cellCliDelete = new TableColumn("Delete");
//    private final TableColumn<ClienteBean,ClienteBean> cellCliIntegerar = new TableColumn("Integra");
    
    private void carregaTabelaProjeto(ObservableList<Projeto> list){
        tbProjeto.getColumns().clear();
        formataTabelaProjeto();
        tbProjeto.setItems(list);
        tbProjeto.getColumns().addAll(cellProId,cellProNome,cellProDescricao,cellProStatus,cellProDtCriacao);
    }
    
//    switch (cbTipoConsultaClienteGeral.getSelectionModel().getSelectedItem()){
//                    case "Nome":
//                        sql = "SELECT C.NAME AS NOME, \n" +
//                            "C.DOCUMENTNR AS CGC, \n" +
//                            "C.INTEGRADO,C.CUSTOMERID,\n" +
//                            "C.INTEGRADORA AS IDINTEGRADORA\n" +
//                            "FROM CLIENTE C WHERE C.INTEGRADORA = "+conf.getId()+
//                            "\n AND C.NAME LIKE '%"+txClienteGeral.getText()+"%'";
//                        
//                        carregaTabelaClienteGeral(ClienteIntegradoDao.getListCliente(sql));
//                        ObservableList<ClienteBean> obj = FXCollections.observableArrayList(lista);
//                        break;
//    }
            
    @FXML
    void teste() {
        ObservableList<Projeto> obj = FXCollections.observableArrayList(ProjetoService.findAll());
        carregaTabelaProjeto(obj);
//                        ObservableList<ClienteBean> obj = FXCollections.observableArrayList(lista);
    }
    
    private void formataTabelaProjeto(){
        cellProId.setMinWidth(100);
        cellProId.setPrefWidth(120);
        cellProId.setResizable(false);
        cellProId.setCellValueFactory (new PropertyValueFactory <> ( "codProjeto" ));
        cellProId.setCellFactory( cell -> {              
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
        cellProId.setStyle("-fx-alignment: center;");
        
        cellProNome.setMinWidth(200);
        cellProNome.setPrefWidth(350);
        cellProNome.setResizable(false);
        cellProNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellProNome.setStyle("-fx-alignment: center-left;");
        
        cellProStatus.setMinWidth(200);
        cellProStatus.setPrefWidth(350);
        cellProStatus.setResizable(false);
        cellProStatus.setCellValueFactory (new PropertyValueFactory <> ( "status" ));
        cellProStatus.setStyle("-fx-alignment: center;");
        
        cellProDtCriacao.setMinWidth(100);
        cellProDtCriacao.setPrefWidth(300);
        cellProDtCriacao.setResizable(true);
        cellProDtCriacao.setCellValueFactory (new PropertyValueFactory<> ("dataCriacao"));
        cellProDtCriacao.setCellFactory( coluna -> {              
            return new TableCell<AbstractMethodError, String>() {
                @Override
                protected void updateItem( String item, boolean empty) {
                   super.updateItem(item, empty);
                   if(item == null || empty) {
                       setText("");
                       setGraphic(null);
                   }else {
                        setText(item.substring(0,10));
                   }
                }
            };
         } );
        cellProDtCriacao.setStyle("-fx-alignment: center;");
        
        cellProDescricao.setMinWidth(100);
        cellProDescricao.setPrefWidth(200);
        cellProDescricao.setResizable(true);
        cellProDescricao.setCellValueFactory (new PropertyValueFactory<> ("descricao"));
        cellProDescricao.setCellFactory( coluna -> {              
            return new TableCell<AbstractMethodError, String>() {
                @Override
                protected void updateItem( String item, boolean empty) {
                   super.updateItem(item, empty);
                   if(item == null || empty) {
                       setText("");
                       setGraphic(null);
                   }else {
                       setText(item);
                   }
                }
            };        
         } );
        cellProDescricao.setStyle("-fx-alignment: center;");
        
//        cellCliDelete.setMinWidth(50);
//        cellCliDelete.setPrefWidth(80);
//        cellCliDelete.setResizable(false);
//        cellCliDelete.setStyle("-fx-alignment: center;");
//        cellCliDelete.setCellFactory(col -> {
//            TableCell<ClienteBean, ClienteBean> cell = new TableCell<ClienteBean, ClienteBean>() {
//                @Override
//                public void updateItem(ClienteBean item, boolean empty) {
//                    final Tooltip infAjuda = new Tooltip();
//                    infAjuda.setText("Exclui o cliente da integradora.");
//                    Button botao = new Button();
//                    String caminho = "icon/lixeira.png";
//                    File file = new File(caminho);
//                    Image imagem = new Image(file.toURI().toString());
//                    ImageView imv = new ImageView();
//                    {
//                        imv.setFitHeight(20l);
//                        imv.setFitWidth(20l);
//                    }
//                    imv.setImage(imagem);
//                    botao.setPickOnBounds(true);
//                    botao.setGraphic(imv);
//                    botao.setAlignment(Pos.CENTER);
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        setGraphic(null);
//                    } else {
//                        botao.setOnAction(event -> 
//                            { 
//                                if(Alertas.confirmacao("Confirma a exclusão do cliente?", "", "Sim", "Não") == 1){
//                                    deletaClienteGeral(getTableView().getItems().get(getIndex()));
//                                    Alertas.alertaInformacao("Processo finalizado!","");
//                                    consultaClienteGeral();
//                                } else
//                                    Alertas.alertaAtencao("Ok!", "Nada foi alterado!");
//                            }
//                        );
//                        setGraphic(botao);
//                    }
//                }
//            };
//            return cell ;
//        });
        
//        cellCliIntegerar.setMinWidth(50);
//        cellCliIntegerar.setPrefWidth(80);
//        cellCliIntegerar.setResizable(false);
//        cellCliIntegerar.setStyle("-fx-alignment: center;");
//        cellCliIntegerar.setCellFactory(col -> {
//            TableCell<ClienteBean, ClienteBean> cell = new TableCell<ClienteBean, ClienteBean>() {
//                @Override
//                public void updateItem(ClienteBean item, boolean empty) {
//                    final Tooltip infAjuda = new Tooltip();
//                    infAjuda.setText("Tenta integrar o cliente com o ERP.");
//                    Button botao = new Button();
//                    String caminho = "icon/integrar.png";
//                    File file = new File(caminho);
//                    Image imagem = new Image(file.toURI().toString());
//                    ImageView imv = new ImageView();
//                    {
//                        imv.setFitHeight(20l);
//                        imv.setFitWidth(20l);
//                    }
//                    imv.setImage(imagem);
//                    botao.setPickOnBounds(true);
//                    botao.setGraphic(imv);
//                    botao.setAlignment(Pos.CENTER);
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        setGraphic(null);
//                    } else {
//                        botao.setOnAction(event -> 
//                            { 
//                                if(Alertas.confirmacao("Confirma o processamento manual?", "", "Sim", "Não") == 1){
//                                    integraCliente(getTableView().getItems().get(getIndex()));
//                                    Alertas.alertaInformacao("Processo finalizado!","");
//                                    consultaClienteGeral();
//                                } else
//                                    Alertas.alertaAtencao("Ok!", "Nada foi alterado!");
//                            }
//                        );
//                        
//                        setGraphic(botao);
//                    }
//                }
//            };
//            return cell ;
//        });
        
    }
}
