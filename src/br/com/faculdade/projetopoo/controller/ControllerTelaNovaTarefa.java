/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
import javafx.fxml.Initializable;
    import javafx.scene.control.TextField;

/**
 *
 * @author 2022101202010066
 */
public class ControllerTelaNovaTarefa implements Initializable{
   
    @FXML
    private TextField txNome;

    @FXML
    private TextField txDescricao;

    @FXML
    private TextField txEncarregado;

    @FXML
    void add(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}


