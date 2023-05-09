/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Diego
 */
public class Global {
    
    public static String email;
    public static Usuario usuario = new Usuario();
    
    public static List<String>  tipoConsulta(String tipo){
        List<String> tipoConsulta = new ArrayList<>();
        switch (tipo) {
            case "projeto":
                tipoConsulta.add("Todos");
                tipoConsulta.add("Código");
                break;
            default:
                throw new AssertionError();
        }
        
        ObservableList<String> options = FXCollections.observableArrayList(tipoConsulta);
        
        return tipoConsulta;
    }
}
