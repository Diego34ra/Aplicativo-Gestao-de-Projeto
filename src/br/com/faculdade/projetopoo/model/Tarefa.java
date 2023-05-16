/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class Tarefa {
    
    private Long codTarefa;
    private String nome;
    private String descricao;
    private String dataCriacao;
    private String status;
    private Projeto projeto;
    private Usuario usuario;

    public Tarefa(Long codTarefa, String nome, String descricao, Projeto projeto, Usuario usuario) {
        this.codTarefa = codTarefa;
        this.nome = nome;
        this.descricao = descricao;
        this.projeto = projeto;
        this.dataCriacao = LocalDate.now().toString();
        this.usuario = usuario;
        this.status = "Em Espera";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public Tarefa() {
    }

    public Long getCodTarefa() {
        return codTarefa;
    }

    public void setCodTarefa(Long codTarefa) {
        this.codTarefa = codTarefa;
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
    
}
