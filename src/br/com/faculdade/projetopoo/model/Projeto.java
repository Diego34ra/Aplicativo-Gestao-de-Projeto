/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

import java.sql.Timestamp;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class Projeto {
    
    protected Long codProjeto;
    private String nome;
    private String dataCriacao;
    private String descricao;

    public Long getCodProjeto() {
        return codProjeto;
    }

    public void setCodProjeto(Long codProjeto) {
        this.codProjeto = codProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Projeto(String nome, String dataCriacao, String descricao) {
        Random random = new Random();
        this.codProjeto = (long) (random.nextDouble() * 10000000L);
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
    }

    public Projeto() {
        Random random = new Random();
        this.codProjeto = (long) (random.nextDouble() * 10000000L);
    }
    
}
