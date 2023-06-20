/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

import java.time.LocalDate;
import java.util.Random;

/**
 * Classe Status
 * @author Diego
 */
public class Status {
    
    private int codStatus;
    private String nome;
    private String descricao;
    private String dataCriacao;
    private String codProjeto;

    /**
     * Metodo que pega o codigo do 
     * Projeto
     * @return 
     */
    public String getCodProjeto() {
        return codProjeto;
    }

    /**
     * Metodo que seta o codigo do projeto
     * @param codProjeto codigo do projeto
     */
    public void setCodProjeto(String codProjeto) {
        this.codProjeto = codProjeto;
    }

    /**
     * Metodo que retorna o codigo do status
     * @return codigo do status
     */
    public int getCodStatus() {
        return codStatus;
    }

    /**
     * Metodo que seta o codigo do status
     * @param codStatus codigo do status
     */
    public void setCodStatus(int codStatus) {
        this.codStatus = codStatus;
    }

    /**
     * Metodo que pega o nome do status
     * @return nome do status
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que seta o nome do status
     * @param nome nome do status
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo que pega a descricao do status
     * @return descricao do status
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo que seta a descricao do status
     * @param descricao descricao do status
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo que pega a data de criacao do status
     * @return 
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Metodo que seta a data de criacao do status
     * @param dataCriacao data de criacao
     */
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * Construtor da classe status
     * @param nome nome do status
     * @param descricao descricao do status
     * @param codProjeto codProjeto do status
     */
    public Status(String nome, String descricao, String codProjeto) {
        Random random = new Random();
        this.codStatus = (int) (random.nextDouble() * 10000000);
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = LocalDate.now().toString();
        this.codProjeto = codProjeto;
    }
    
    /**
     * Contrutor da classe status
     * @param nome nome do status
     * @param descricao descricao do status
     */
    public Status(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    /**
     * Contrutor da classe status
     * @param nome nome do status
     */
    public Status(String nome) {
        this.nome = nome;
    }

    /**
     * Construtor da classe status
     */
    public Status() {
    }
    
    
    
    
}
