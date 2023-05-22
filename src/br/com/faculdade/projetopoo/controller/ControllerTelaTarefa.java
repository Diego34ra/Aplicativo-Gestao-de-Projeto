/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Tarefa;
import br.com.faculdade.projetopoo.services.ProjetoService;
import br.com.faculdade.projetopoo.services.TarefaService;
import br.com.faculdade.projetopoo.view.TelaAlteraStatus;
import br.com.faculdade.projetopoo.view.TelaNovaTarefa;
import br.com.faculdade.projetopoo.view.TelaNovoProjeto;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class ControllerTelaTarefa implements Initializable{
    
    @FXML
    private Button btAddNovaTarefa;
    
    @FXML
    private TableView<Tarefa> tbTarefa;
    private final TableColumn cellTarefaCodigo = new TableColumn("Código");
    private final TableColumn<Tarefa,Tarefa> cellTarefaDelete = new TableColumn("Deletar");
    private final TableColumn cellTarefaDescricao = new TableColumn("Descrição");
    private final TableColumn cellTarefaDtCriacao = new TableColumn("Data de criação");
    private final TableColumn cellTarefaNome = new TableColumn("Nome");
    private final TableColumn cellTarefaStatus = new TableColumn("Status");
    private final TableColumn cellTarefaAlteraStatus = new TableColumn("Alterar status");
    
    private ObservableList<Tarefa> obj = null;
    
    @FXML
    void addTarefa() {
     TelaNovaTarefa tela = new TelaNovaTarefa();
        try {
            tela.start(new Stage());
            TelaNovaTarefa.getStage().showAndWait();    
            TarefaService tarefa = new TarefaService();
            obj = FXCollections.observableArrayList(tarefa.findAll(Global.projeto.getCodProjeto()));
            carregaTabelaProjeto(obj);
        } catch (Exception ex) {
            System.out.println("Exception ao criar a tela de nova tarefa\n"+ex);
        }  
    }
    
    private void carregaTabelaProjeto(ObservableList<Tarefa> list){
        tbTarefa.getColumns().clear();
        formataTabelaTarefa();
        tbTarefa.setItems(list);
        tbTarefa.getColumns().addAll(cellTarefaCodigo,cellTarefaNome,cellTarefaDescricao,cellTarefaStatus, cellTarefaDtCriacao,cellTarefaAlteraStatus,cellTarefaDelete);
    }
    
    private void formataTabelaTarefa(){
        cellTarefaCodigo.setMinWidth(100);
        cellTarefaCodigo.setPrefWidth(120);
        cellTarefaCodigo.setResizable(false);
        cellTarefaCodigo.setCellValueFactory (new PropertyValueFactory <> ( "codTarefa" ));
        cellTarefaCodigo.setCellFactory( cell -> {              
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
        cellTarefaCodigo.setStyle("-fx-alignment: center;");
        
        cellTarefaNome.setMinWidth(150);
        cellTarefaNome.setPrefWidth(200);
        cellTarefaNome.setResizable(false);
        cellTarefaNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellTarefaNome.setStyle("-fx-alignment: center;");
        
        cellTarefaDescricao.setMinWidth(150);
        cellTarefaDescricao.setPrefWidth(200);
        cellTarefaDescricao.setResizable(false);
        cellTarefaDescricao.setCellValueFactory (new PropertyValueFactory <> ( "descricao" ));
        cellTarefaDescricao.setStyle("-fx-alignment: center;");
        
        cellTarefaStatus.setMinWidth(150);
        cellTarefaStatus.setPrefWidth(170);
        cellTarefaStatus.setResizable(false);
        cellTarefaStatus.setCellValueFactory (new PropertyValueFactory <> ( "status" ));
        cellTarefaStatus.setStyle("-fx-alignment: center;");
        
        cellTarefaAlteraStatus.setMinWidth(50);
        cellTarefaAlteraStatus.setPrefWidth(80);
        cellTarefaAlteraStatus.setResizable(false);
        cellTarefaAlteraStatus.setStyle("-fx-alignment: center");
        cellTarefaAlteraStatus.setCellFactory(col -> {
            TableCell<Tarefa, Tarefa> cell = new TableCell<Tarefa, Tarefa>() {
                @Override
                public void updateItem(Tarefa item, boolean empty) {
                    final Tooltip infAjuda = new Tooltip();
                    infAjuda.setText("Altera o status do projeto.");
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
                                TelaAlteraStatus tela = new TelaAlteraStatus();
                                try {
                                    tela.start(new Stage());
                                    TelaAlteraStatus.getStage().show();
                                } catch (Exception ex) {
                                    System.out.println("Exception ao criar a tela de alteração de status\n"+ex);
                                }  
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
        
        cellTarefaDtCriacao.setMinWidth(100);
        cellTarefaDtCriacao.setPrefWidth(200);
        cellTarefaDtCriacao.setResizable(true);
        cellTarefaDtCriacao.setCellValueFactory (new PropertyValueFactory<> ("dataCriacao"));
        cellTarefaDtCriacao.setCellFactory( coluna -> {              
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
        cellTarefaDtCriacao.setStyle("-fx-alignment: center;");
        
        cellTarefaDelete.setMinWidth(50);
        cellTarefaDelete.setPrefWidth(80);
        cellTarefaDelete.setResizable(false);
        cellTarefaDelete.setStyle("-fx-alignment: center");
        cellTarefaDelete.setCellFactory(col -> {
            TableCell<Tarefa, Tarefa> cell = new TableCell<Tarefa, Tarefa>() {
                @Override
                public void updateItem(Tarefa item, boolean empty) {
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
                                if (Alertas.confirmacao("Atenção","Deseja deletar a tarefa?") == 1) {
                                    TarefaService tarefaService = new TarefaService();
                                    tarefaService.deleteById(getTableView().getItems().get(getIndex()).getCodTarefa());
                                    Alertas.informacao("Sucesso", "A tarefa foi deletada com sucesso.");
                                    obj.remove(getTableView().getItems().get(getIndex()));
                                    carregaTabelaProjeto(obj);
                                }
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TarefaService tarefa = new TarefaService();
        obj = FXCollections.observableArrayList(tarefa.findAll(Global.projeto.getCodProjeto()));
        carregaTabelaProjeto(obj);
    }
}
