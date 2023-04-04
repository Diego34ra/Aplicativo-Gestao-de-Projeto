/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

/**
 *
 * @author Diego
 */
public class Usuario {
    
    private Long codUsuario;
    private String cpf;
    private String email;
    private String nome;
    private String senha;
    private String codRecuperacao;

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCodRecuperacao() {
        return codRecuperacao;
    }

    public void setCodRecuperacao(String codRecuperacao) {
        this.codRecuperacao = codRecuperacao;
    }

    public Usuario(Long codUsuario, String cpf, String email, String nome, String senha, String codRecuperacao) {
        this.codUsuario = codUsuario;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.codRecuperacao = codRecuperacao;
    }

    public Usuario() {
    }
    
}
