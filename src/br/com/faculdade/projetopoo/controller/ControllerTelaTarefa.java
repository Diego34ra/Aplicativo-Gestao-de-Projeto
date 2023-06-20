/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.Alertas;
import br.com.faculdade.projetopoo.Global;
import br.com.faculdade.projetopoo.dao.ProjetoDao;
import br.com.faculdade.projetopoo.dao.StatusDao;
import br.com.faculdade.projetopoo.model.Tarefa;
import br.com.faculdade.projetopoo.model.Usuario;
import br.com.faculdade.projetopoo.dao.TarefaDao;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.view.TelaAlteraStatus;
import br.com.faculdade.projetopoo.view.TelaNovaTarefa;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controller para a tela de tarefas.
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
    private final TableColumn cellTarefaDtFinalizacao = new TableColumn("Data de Finalização");
    private final TableColumn cellTarefaNome = new TableColumn("Nome");
    private final TableColumn<Tarefa,Usuario> cellTarefaEncarregado = new TableColumn("Encarregado");
    private final TableColumn cellTarefaStatus = new TableColumn("Status");
    private final TableColumn cellTarefaAlteraStatus = new TableColumn("Alterar status");
    
    private ObservableList<Tarefa> obj = null;
    private List<Tarefa> tarefas = new ArrayList<>();
    private final TarefaDao tarefaDao = new TarefaDao();
    
    /**
     * Método chamado quando o botão "Adicionar Tarefa" é clicado.
     * Abre a tela de nova tarefa e atualiza a tabela de tarefas.
     */
    @FXML
    void addTarefa() {
     TelaNovaTarefa tela = new TelaNovaTarefa();
        try {
            tela.start(new Stage());
            TelaNovaTarefa.getStage().showAndWait();    
            
            geraTabela();
        } catch (Exception ex) {
            System.out.println("Exception ao criar a tela de nova tarefa\n"+ex);
        }  
    }
    /**
     * Carrega os dados da lista de tarefas na tabela de tarefas.
     * @param list Lista de tarefas a ser carregada na tabela
     */
    private void carregaTabelaProjeto(ObservableList<Tarefa> list){
        tbTarefa.getColumns().clear();
        formataTabelaTarefa();
        tbTarefa.setItems(list);
        tbTarefa.getColumns().addAll(cellTarefaCodigo,cellTarefaEncarregado, cellTarefaNome,cellTarefaDescricao,cellTarefaStatus, cellTarefaDtCriacao,cellTarefaDtFinalizacao,cellTarefaAlteraStatus,cellTarefaDelete);
    }
    
    /**
     * Configura a formatação das colunas da tabela de tarefas.
     */
    private void formataTabelaTarefa(){
        cellTarefaCodigo.setMinWidth(80);
        cellTarefaCodigo.setPrefWidth(100);
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
        
        cellTarefaEncarregado.setMinWidth(150);
        cellTarefaEncarregado.setPrefWidth(200);
        cellTarefaEncarregado.setResizable(false);
        cellTarefaEncarregado.setCellValueFactory (new PropertyValueFactory <> ( "usuario" ));
        cellTarefaEncarregado.setCellFactory( col -> {              
            return new TableCell<Tarefa, Usuario>() {
                @Override
                protected void updateItem( Usuario item, boolean empty) {
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
        cellTarefaEncarregado.setStyle("-fx-alignment: center;");
        
        cellTarefaNome.setMinWidth(100);
        cellTarefaNome.setPrefWidth(130);
        cellTarefaNome.setResizable(false);
        cellTarefaNome.setCellValueFactory (new PropertyValueFactory <> ( "nome" ));
        cellTarefaNome.setStyle("-fx-alignment: center;");
        
        cellTarefaDescricao.setMinWidth(150);
        cellTarefaDescricao.setPrefWidth(300);
        cellTarefaDescricao.setResizable(false);
        cellTarefaDescricao.setCellValueFactory (new PropertyValueFactory <> ( "descricao" ));
        cellTarefaDescricao.setStyle("-fx-alignment: center;");
        
        cellTarefaStatus.setMinWidth(150);
        cellTarefaStatus.setPrefWidth(150);
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
                    String caminho = "C:\\Users\\joaog\\OneDrive\\Documentos\\GitHub\\Aplicativo-Gestao-de-Projeto\\src\\br\\com\\faculdade\\projetopoo\\imagens\\stats.png";
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
                                    Global.tarefa = getTableView().getItems().get(getIndex());
                                    Global.alteraStatus = "Tarefa";
                                    tela.start(new Stage());
                                    TelaAlteraStatus.getStage().showAndWait();
                                } catch (Exception ex) {
                                    System.out.println("Exception ao criar a tela de alteração de status\n"+ex);
                                }
                                geraTabela();
                            }
                        );
                        setGraphic(botao);
                    }
                }
            };
            return cell ;
        });
        
        cellTarefaDtCriacao.setMinWidth(100);
        cellTarefaDtCriacao.setPrefWidth(150);
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
                        setText(item);
                   }
                }
            };
         } );
        cellTarefaDtCriacao.setStyle("-fx-alignment: center;");
        
        cellTarefaDtFinalizacao.setMinWidth(100);
        cellTarefaDtFinalizacao.setPrefWidth(150);
        cellTarefaDtFinalizacao.setResizable(true);
        cellTarefaDtFinalizacao.setCellValueFactory (new PropertyValueFactory<> ("dataFinalizacao"));
        cellTarefaDtFinalizacao.setCellFactory( coluna -> {              
            return new TableCell<AbstractMethodError, String>() {
                @Override
                protected void updateItem( String item, boolean empty) {
                   super.updateItem(item, empty);
                   if(item == null || empty) {
                       setText("");
                       setGraphic(null);
                   }else {
                       if(item.length() != 1){
                           setText(item);
                       } else {
                           setText(item);
                       }
                        
                   }
                }
            };
         } );
        cellTarefaDtFinalizacao.setStyle("-fx-alignment: center;");
        
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
                                if (Alertas.confirmacao("Atenção","Deseja deletar a tarefa?") == 1) {
                                    TarefaDao tarefaService = new TarefaDao();
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
        geraTabela();
    }
    
    
    /**
     * Gera a tabela de tarefas com base na lista de tarefas do projeto atual.
     * Os dados são obtidos do banco de dados e carregados na tabela.
     */
    public void geraTabela(){
        tarefas = tarefaDao.findAll(Global.projeto.getCodProjeto());
        validaStatus(tarefas);
        
        obj = FXCollections.observableArrayList(tarefas);
        carregaTabelaProjeto(obj);
    }
    
    /**
     * Valida o status do projeto com base na lista de tarefas.
     * Verifica se todas as tarefas estão com o mesmo status e atualiza o status do projeto, se necessário.
     * @param tarefas Lista de tarefas do projeto
     */
    public void validaStatus(List<Tarefa> tarefas){
        tarefas.stream().forEach(tarefa -> {System.out.println(tarefa.getStatus());});
        Long contador = tarefas.stream()
                .filter(tarefa ->  tarefa.getStatus().equals("Sem Fluxo"))
                .count();
        if(contador == tarefas.size()){
            if (!Global.projeto.getStatus().equals("Sem Fluxo")) {
                StatusDao statusDao = new StatusDao();
                Status statusProjeto = new Status("Sem Fluxo", "O projeto foi parado momentâneamente.", Global.projeto.getCodProjeto().toString());
                statusDao.create(statusProjeto);
                return;
            }
        }
        contador = tarefas.stream()
                .filter(tarefa ->  tarefa.getStatus().equals("Finalizado"))
                .count();
        if(contador == tarefas.size()){
            if (!Global.projeto.getStatus().equals("Finalizado")) {
                StatusDao statusDao = new StatusDao();
                Status statusProjeto = new Status("Finalizado", "O projeto foi finalizado.", Global.projeto.getCodProjeto().toString());
                statusDao.create(statusProjeto);
                return;
            }
        }
        contador = tarefas.stream()
                .filter(tarefa ->  tarefa.getStatus().equals("Em Espera"))
                .count();
        if(contador == tarefas.size()){
            if (!Global.projeto.getStatus().equals("Em Espera")) {
                StatusDao statusDao = new StatusDao();
                Status statusProjeto = new Status("Em Espera", "O projeto ainda não foi iniciado.", Global.projeto.getCodProjeto().toString());
                statusDao.create(statusProjeto);
                return;
            }
        } else { 
            if (!Global.projeto.getStatus().equals("Em Andamento")) {
                StatusDao statusDao = new StatusDao();
                Status statusProjeto = new Status("Em Andamento", "O projeto está sendo executado.", Global.projeto.getCodProjeto().toString());
                statusDao.create(statusProjeto);
            }
        }
    }
}
