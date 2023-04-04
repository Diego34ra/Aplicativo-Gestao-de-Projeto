/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

/**
 *
 * @author Diego
 */
public class Tarefa {
    
    private Long codTarefa;
    private String nome;
    private String descricao;

    public Tarefa(Long codTarefa, String nome, String descricao) {
        this.codTarefa = codTarefa;
        this.nome = nome;
        this.descricao = descricao;
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
