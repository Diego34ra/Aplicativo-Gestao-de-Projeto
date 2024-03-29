/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.dao.ProjetoDao;
import br.com.faculdade.projetopoo.view.TelaAlteraStatus;
import br.com.faculdade.projetopoo.view.TelaHistoricoStatus;
import br.com.faculdade.projetopoo.view.TelaNovoProjeto;
import br.com.faculdade.projetopoo.view.TelaTarefa;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * Controller responsável pela tela de projeto.
 * Implementa a interface Initializable do JavaFX.
 * @author joaog
 */
public class ControllerTelaProjeto implements Initializable{
    
     /**
     * Campo de texto para consulta.
     */
    @FXML
    private TextField txConsulta;

     /**
     * ComboBox para seleção do tipo de consulta.
     */
    @FXML
    private ComboBox<String> cbConsulta;
    
    /**
     * Botão para abrir a tela de novo projeto.
     */
    @FXML
    private Button btTelaNovoProjeto;
    
    private ObservableList<Projeto> obj = null;

     /**
     * Tabela de projetos.
     */
    @FXML
    private TableView<Projeto> tbProjeto;
    private final TableColumn cellProId = new TableColumn("Código");
    private final TableColumn cellProNome = new TableColumn("Nome");
    private final TableColumn cellProDtCriacao = new TableColumn("Data de Criação");
    private final TableColumn cellProDescricao = new TableColumn("Descrição");
    private final TableColumn cellProAlteraStatus = new TableColumn("Alterar status");
    private final TableColumn<Projeto,Status> cellProStatus = new TableColumn("Status");
    private final TableColumn<Projeto,Projeto> cellProHistoricoStatus = new TableColumn("Histórico de Status");
    private final TableColumn<Projeto,Projeto> cellProTarefas = new TableColumn("Tarefas");
    private final TableColumn<Projeto,Projeto> cellProDelete = new TableColumn("Deletar");
    
    /**
     * Carrega os dados na tabela de projetos.
     * @param list Lista observável de projetos
     */
    private void carregaTabelaProjeto(ObservableList<Projeto> list){
        tbProjeto.getColumns().clear();
        formataTabelaProjeto();
        tbProjeto.setItems(list);
        tbProjeto.getColumns().addAll(cellProTarefas,cellProId,cellProNome,cellProDescricao,cellProStatus,cellProDtCriacao,cellProAlteraStatus,cellProHistoricoStatus, cellProDelete);
    }
    
    /**
     * Método chamado ao clicar no botão "Novo Projeto".
     * Abre a tela de novo projeto.
     */
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
            
    /**
     * Método chamado ao clicar no botão "Buscar".
     * Realiza a busca de projetos.
     */
    @FXML
    void buscar() {
        switch (cbConsulta.getSelectionModel().getSelectedItem()) {
            case "Todos":
                obj = FXCollections.observableArrayList(ProjetoDao.findAll());
                break;
            case "Nome":
                obj = FXCollections.observableArrayList(ProjetoDao.findByName(txConsulta.getText()));
                break;
            case "Código":
                List<Projeto> lista= new ArrayList<>();
                if(!ProjetoDao.findById(txConsulta.getText()).getCodProjeto().equals(0L)){
                    lista.add(ProjetoDao.findById(txConsulta.getText()));
                }
                obj = FXCollections.observableArrayList(lista);
                break;
        }
        carregaTabelaProjeto(obj);
    }
    
    /**
    * Formata a tabela de projetos, definindo as configurações de cada coluna.
    * As configurações incluem largura, valor da célula, estilo e ações dos botões.
    */
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
        cellProNome.setPrefWidth(200);
        cellProNome.setResizable(false);
        cellProNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellProNome.setStyle("-fx-alignment: center;");
        
        cellProStatus.setMinWidth(200);
        cellProStatus.setPrefWidth(200);
        cellProStatus.setResizable(false);
        cellProStatus.setCellValueFactory (new PropertyValueFactory <> ( "status" ));
        cellProStatus.setCellFactory( col -> {              
            return new TableCell<Projeto, Status>() {
                @Override
                protected void updateItem( Status item, boolean empty) {
                   super.updateItem(item, empty);
                   if(item == null|| empty) {
                       setText("");
                       setGraphic(null);
                   }else {
                       setText(item.getNome());
                   }
                }
            };
         });
        cellProStatus.setStyle("-fx-alignment: center;");
        
        cellProDtCriacao.setMinWidth(100);
        cellProDtCriacao.setPrefWidth(200);
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
                        setText(item);
                   }
                }
            };
         } );
        cellProDtCriacao.setStyle("-fx-alignment: center;");
        
        cellProDescricao.setMinWidth(100);
        cellProDescricao.setPrefWidth(253);
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
                    Path resourcePath = Paths.get("");
                    File file = new File(resourcePath.toAbsolutePath().toString() + "\\src\\br\\com\\faculdade\\projetopoo\\imagens\\tarefaimg.png");
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
                                Global.projeto = getTableView().getItems().get(getIndex());
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
                    Path resourcePath = Paths.get("");
                    File file = new File(resourcePath.toAbsolutePath().toString() + "\\src\\br\\com\\faculdade\\projetopoo\\imagens\\delete.png");
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
                                ProjetoDao projetoService = new ProjetoDao();
                                if(Alertas.confirmacao("Atenção!", "Realmente deseja deletar o projeto "+getTableView().getItems().get(0).getNome()+" ?") == 1){
                                    Boolean retorno = projetoService.deleteById(getTableView().getItems().get(0).getCodProjeto());
                                    if(retorno){
                                        Alertas.informacao("Sucesso!", "Projeto deletado com sucesso.");
                                        obj.remove(getTableView().getItems().get(0));
                                        carregaTabelaProjeto(obj);
                                    } else {
                                        Alertas.informacao("Erro", "Erro ao deletar o projeto.");
                                    }
                                }
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
        
        cellProAlteraStatus.setMinWidth(50);
        cellProAlteraStatus.setPrefWidth(80);
        cellProAlteraStatus.setResizable(false);
        cellProAlteraStatus.setStyle("-fx-alignment: center");
        cellProAlteraStatus.setCellFactory(col -> {
            TableCell<Projeto, Projeto> cell = new TableCell<Projeto, Projeto>() {
                @Override
                public void updateItem(Projeto item, boolean empty) {
                    final Tooltip infAjuda = new Tooltip();
                    infAjuda.setText("Altera o status do projeto.");
                    Button botao = new Button();
                    Path resourcePath = Paths.get("");
                    File file = new File(resourcePath.toAbsolutePath().toString() + "\\src\\br\\com\\faculdade\\projetopoo\\imagens\\stats.png");
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
                                    Global.projeto = getTableView().getItems().get(getIndex());
                                    Global.alteraStatus = "Projeto";
                                    tela.start(new Stage());
                                    TelaAlteraStatus.getStage().showAndWait();
                                } catch (Exception ex) {
                                    System.out.println("Exception ao criar a tela de alteração de status\n"+ex);
                                }
                                carregaTabelaProjeto(obj);
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
        
        cellProHistoricoStatus.setMinWidth(100);
        cellProHistoricoStatus.setPrefWidth(120);
        cellProHistoricoStatus.setResizable(false);
        cellProHistoricoStatus.setStyle("-fx-alignment: center");
        cellProHistoricoStatus.setCellFactory(col -> {
            TableCell<Projeto, Projeto> cell = new TableCell<Projeto, Projeto>() {
                @Override
                public void updateItem(Projeto item, boolean empty) {
                    final Tooltip infAjuda = new Tooltip();
                    infAjuda.setText("Altera o status do projeto.");
                    Button botao = new Button();
                    Path resourcePath = Paths.get("");
                    File file = new File(resourcePath.toAbsolutePath().toString() + "\\src\\br\\com\\faculdade\\projetopoo\\imagens\\stats-history.png");
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
                                TelaHistoricoStatus tela = new TelaHistoricoStatus();
                                try {
                                    Global.projeto = getTableView().getItems().get(getIndex());
                                    tela.start(new Stage());
                                    TelaHistoricoStatus.getStage().show();
                                } catch (Exception ex) {
                                    System.out.println("Exception ao criar a tela de histórico de status\n"+ex);
                                }
                                carregaTabelaProjeto(obj);
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
        cbConsulta.getItems().addAll(Global.tipoConsulta("projeto"));
        cbConsulta.getSelectionModel().selectFirst();
    }
}