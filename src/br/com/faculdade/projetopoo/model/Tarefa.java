/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;
import java.util.Random;

import java.time.LocalDate;

/**
 * Classe Tarefa
 * @author Diego
 */
public class Tarefa {
    
    private Long codTarefa;
    private String nome;
    private String descricao;
    private String dataCriacao;
    private String dataFinalizacao;
    private String status;
    private Projeto projeto;
    private Usuario usuario;

    
    /**
     * Metodo que pega a data de finalizacao do tarefa
     * @return data de finalizacao
     */
    public String getDataFinalizacao() {
        return dataFinalizacao;
    }

    /**
     * Metodo que seta a data de finalizacao do tarefa
     * @param dataFinalizacao data de finalizacao do tarefa
     */
    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    /**
     * Metodo que pega o status da tarefa
     * @return status da tarefa
     */
    public String getStatus() {
        return status;
    }

    /**
     * Metodo que seta o status da tarefa
     * @param status status da tarefa
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Metodo que pega a data de criacao da tarefa
     * @return data de criacao da tarefa
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Metodo que seta a data de criacao da tarefa
     * @param dataCriacao data de criacao da tarefa
     */
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * Metodo que pega o projeto que a tarefa esta vinculada
     * @return codigo do projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * Metodo que seta o projeto que a tarefa sera vinculada
     * @param projeto projeto
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * Metodo que pega o usuario que a tarefa esta vinculada
     * @return 
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Metodo que seta o usuario que a tarefa sera vinculada
     * @param usuario usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que pega o codigo da tarefa
     * @return codigo da tarefa
     */
    public Long getCodTarefa() {
        return codTarefa;
    }

    /**
     * Metodo que seta o codigo da tarefa
     * @param codTarefa codigo da tarefa
     */
    public void setCodTarefa(Long codTarefa) {
        this.codTarefa = codTarefa;
    }

    /**
     * Metodo que pega o nome da tarefa
     * @return nome da tarefa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que seta o nome da tarefa
     * @param nome nome da tarefa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo que pega a descricao da tarefa
     * @return descricao da tarefa
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo que seta a descricao da tarefa
     * @param descricao descricao da tarefa
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Construtor da tarefa
     */
    public Tarefa() {
    }
    
    /**
     * Construtor da tarefa
     * @param nome nome da tarefa
     * @param descricao descricao da tarefa
     * @param projeto projeto que a tarefa esta vinculada
     * @param usuario usuario que a tarefa esta vinculada
     */
    public Tarefa(String nome, String descricao, Projeto projeto, Usuario usuario) {
        Random random = new Random();
        this.codTarefa = (long) (random.nextDouble() * 10000000L);
        this.nome = nome;
        this.descricao = descricao;
        this.projeto = projeto;
        this.dataCriacao = LocalDate.now().toString();
        this.usuario = usuario;
        this.status = "Em Espera";
    }
    
}
