/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import br.com.faculdade.projetopoo.model.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Diego
 */
public class ControllerTelaTarefa {
    
    @FXML
    private TableView<Projeto> tbTarefa;
    private final TableColumn cellExcluir = new TableColumn("Excluir");
    private final TableColumn cellDescricao = new TableColumn("Descrição");
    private final TableColumn cellNome = new TableColumn("Nome");
    private final TableColumn cellStatus = new TableColumn("Status");
    
    @FXML
    void addTarefa(ActionEvent event) {

    }
}
