/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo;

import br.com.faculdade.projetopoo.model.Projeto;
import br.com.faculdade.projetopoo.model.Status;
import br.com.faculdade.projetopoo.model.Tarefa;
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
    public static Usuario consulta = new Usuario();
    public static Projeto projeto = new Projeto();
    public static Boolean validar = false;
    public static Tarefa tarefa = new Tarefa();
    public static String alteraStatus = "";
    
    public static List<String>  tipoConsulta(String tipo){
        List<String> tipoConsulta = new ArrayList<>();
        switch (tipo) {
            case "projeto":
                tipoConsulta.add("Todos");
                tipoConsulta.add("Nome");
                tipoConsulta.add("Código");
                
                break;
            case "usuario":
                tipoConsulta.add("Todos");
                tipoConsulta.add("Nome");
                tipoConsulta.add("Código");
                
                break;
            default:
                throw new AssertionError();
        }
        
        ObservableList<String> options = FXCollections.observableArrayList(tipoConsulta);
        
        return tipoConsulta;
    }
    
    public static List<Status> tipoStatus(){
        List<Status> listStatus = new ArrayList<>();
        listStatus.add(new Status("Sem Fluxo","O projeto foi parado momentâneamente."));
        listStatus.add(new Status("Em Espera", "O projeto ainda não foi iniciado."));
        listStatus.add(new Status("Em Andamento","O projeto já foi iniciado."));
        listStatus.add(new Status("Finalizado", "O projeto foi finalizado."));
        return listStatus;
    }
}
