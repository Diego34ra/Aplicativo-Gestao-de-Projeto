/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.services.ProjetoService;
import br.com.faculdade.projetopoo.view.TelaNovoProjeto;
import br.com.faculdade.projetopoo.view.TelaTarefa;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class ControllerTelaProjeto implements Initializable{
    
    @FXML
    private TextField txConsulta;

    @FXML
    private ComboBox<String> cbConsulta;
    
    @FXML
    private Button btTelaNovoProjeto;

    @FXML
    private TableView<Projeto> tbProjeto;
    private final TableColumn cellProId = new TableColumn("Código");
    private final TableColumn cellProNome = new TableColumn("Nome");
    private final TableColumn cellProDtCriacao = new TableColumn("Data de Criação");
    private final TableColumn cellProDescricao = new TableColumn("Descrição");
    private final TableColumn cellProStatus = new TableColumn("Status");
    private final TableColumn<Projeto,Projeto> cellProTarefas = new TableColumn("Tarefas");
    private final TableColumn<Projeto,Projeto> cellProDelete = new TableColumn("Deletar");
    
    private void carregaTabelaProjeto(ObservableList<Projeto> list){
        tbProjeto.getColumns().clear();
        formataTabelaProjeto();
        tbProjeto.setItems(list);
        tbProjeto.getColumns().addAll(cellProTarefas,cellProId,cellProNome,cellProDescricao,cellProStatus,cellProDtCriacao,cellProDelete);
    }
    
    @FXML
    void novoProjeto() {
          TelaNovoProjeto tela = new TelaNovoProjeto();
        try {
            tela.start(new Stage());
            TelaNovoProjeto.getStage().show();
        } catch (Exception ex) {
            System.out.println("Exception ao criar a tela de novo projetos\n"+ex);
        }       
    }
            
    @FXML
    void buscar() {
        ObservableList<Projeto> obj = null;
        switch (cbConsulta.getSelectionModel().getSelectedItem()) {
            case "Todos":
                obj = FXCollections.observableArrayList(ProjetoService.findAll());
                break;
            case "Código":
                List<Projeto> lista= new ArrayList<>();
                if(!ProjetoService.findById(txConsulta.getText()).getCodProjeto().equals(0L)){
                    lista.add(ProjetoService.findById(txConsulta.getText()));
                }
                obj = FXCollections.observableArrayList(lista);
                break;
        }
        carregaTabelaProjeto(obj);
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
        
        cellProTarefas.setMinWidth(50);
        cellProTarefas.setPrefWidth(80);
        cellProTarefas.setResizable(false);
        cellProTarefas.setStyle("-fx-alignment: center;");
        cellProTarefas.setCellFactory(col -> {
            TableCell<Projeto, Projeto> cell = new TableCell<Projeto, Projeto>() {
                @Override
                public void updateItem(Projeto item, boolean empty) {
                    final Tooltip infAjuda = new Tooltip();
                    infAjuda.setText("Tarefas do projeto.");
                    Button botao = new Button();
                    String caminho = "C:\\Users\\joaog\\OneDrive\\Documentos\\GitHub\\Aplicativo-Gestao-de-Projeto\\src\\br\\com\\faculdade\\projetopoo\\imagens\\tarefaimg.png";
                    File file = new File(caminho);
                    Image imagem = new Image(file.toURI().toString());
                    ImageView imv = new ImageView();
                   {
                       imv.setFitHeight(20l);
                       imv.setFitWidth(20l);
                  }
                   imv.setImage(imagem);
                    botao.setPickOnBounds(true);
                    botao.setGraphic(imv);
                    botao.setAlignment(Pos.CENTER);
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        botao.setOnAction(event -> 
                            { 
                                System.out.println("Testando");
//                                if(Alertas.confirmacao("Confirma a exclusão do cliente?", "", "Sim", "Não") == 1){
//                                    deletaClienteGeral(getTableView().getItems().get(getIndex()));
//                                    Alertas.alertaInformacao("Processo finalizado!","");
//                                    consultaClienteGeral();
//                                } else
//                                    Alertas.alertaAtencao("Ok!", "Nada foi alterado!");

                                    TelaTarefa tela = new TelaTarefa();
                                          try {
                                                tela.start(new Stage());
                                                TelaTarefa.getStage().show();
                                               } catch (Exception ex) {
                                                 System.out.println("Exception ao criar a tela de tarefa\n"+ex);
                                               } 
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
        
        cellProDelete.setMinWidth(50);
        cellProDelete.setPrefWidth(80);
        cellProDelete.setResizable(false);
        cellProDelete.setStyle("-fx-alignment: center");
        cellProDelete.setCellFactory(col -> {
            TableCell<Projeto, Projeto> cell = new TableCell<Projeto, Projeto>() {
                @Override
                public void updateItem(Projeto item, boolean empty) {
                    final Tooltip infAjuda = new Tooltip();
                    infAjuda.setText("Deleta o projeto.");
                    Button botao = new Button();
                    String caminho = "C:\\Users\\joaog\\OneDrive\\Documentos\\GitHub\\Aplicativo-Gestao-de-Projeto\\src\\br\\com\\faculdade\\projetopoo\\imagens\\delete.png";
                    File file = new File(caminho);
                    Image imagem = new Image(file.toURI().toString());
                    ImageView imv = new ImageView();
                    {
                       imv.setFitHeight(20l);
                       imv.setFitWidth(20l);
                       
                    }
                   imv.setImage(imagem);
                    botao.setPickOnBounds(true);
                    botao.setGraphic(imv);
                    botao.setAlignment(Pos.CENTER);
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        botao.setOnAction(event -> 
                            { 
                                ProjetoService projetoService = new ProjetoService();
                                Boolean retorno = projetoService.deleteById(cellProDelete.getCellData(item).getCodProjeto());
                                if(retorno){
                                    Alertas.informacao("Sucesso!", "Projeto deletado com sucesso.");
                                } else {
                                    Alertas.informacao("Erro", "Erro ao deletar o projeto.");
                                }
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
        
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbConsulta.getItems().addAll(Global.tipoConsulta("projeto"));
        
        cbConsulta.getSelectionModel().selectFirst();
    }
}
