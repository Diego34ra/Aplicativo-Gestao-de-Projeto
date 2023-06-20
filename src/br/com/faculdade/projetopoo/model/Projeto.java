/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

/**
 * Classe Projeto
 * @author Diego
 */
public class Projeto {
    
    private Long codProjeto;
    private String nome;
    private String dataCriacao;
    private String descricao;
    private Status status;

    /**
     *  Metodo que pega o status do projeto
     * @return status do projeto
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Metodo que seta o status do projeto
     * @param status status do projeto 
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Metodo que pega o codigo do projeto
     * @return codigo do projeto
     */
    public Long getCodProjeto() {
        return codProjeto;
    }

    /**
     * Metodo que seta o codigo do proejto
     * @param codProjeto codigo do projeto
     */
    public void setCodProjeto(Long codProjeto) {
        this.codProjeto = codProjeto;
    }

    /**
     * Metodo que pega o nome do projeto
     * @return nome do projeto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que seta o nome do projeto
     * @param nome nome do projeto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo que pega a data de criacao do projeto
     * @return data de criacao do projeto
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Metodo que seta a data de criacao do projeto
     * @param dataCriacao data de criacao do projeto
     */
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * Metodo que pega a descricao do projeto
     * @return descricao do projeto
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo que seta a descricao do projeto
     * @param descricao descricao do projeto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Construtor da classe Projeto
     * @param nome nome do projeto
     * @param descricao descricao do projeto
     */
    public Projeto(String nome, String descricao) {
        Random random = new Random();
        this.codProjeto = (long) (random.nextDouble() * 10000000L);
        this.nome = nome;
        this.dataCriacao = Date.valueOf(LocalDate.now()).toString();
        this.descricao = descricao;
    }

    /**
     * Construtor da classe Projeto
     */
    public Projeto() {
    }
    
}
