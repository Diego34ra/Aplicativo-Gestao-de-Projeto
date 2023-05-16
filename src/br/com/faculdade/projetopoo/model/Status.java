/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class Status {
    
    private int codStatus;
    private String nome;
    private String descricao;
    private String dataHora;
    private String codProjeto;

    public String getCodProjeto() {
        return codProjeto;
    }

    public void setCodProjeto(String codProjeto) {
        this.codProjeto = codProjeto;
    }

    public int getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(int codStatus) {
        this.codStatus = codStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Status(String nome, String descricao, String codProjeto) {
        Random random = new Random();
        this.codStatus = (int) (random.nextDouble() * 10000000);
        this.nome = nome;
        this.descricao = descricao;
        this.dataHora = LocalDate.now().toString();
        this.codProjeto = codProjeto;
    }

    public Status() {
    }
    
    
    
    
}
