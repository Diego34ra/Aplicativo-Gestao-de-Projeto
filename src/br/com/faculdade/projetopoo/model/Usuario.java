/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.model;

import java.util.Random;

/**
 * Classe usuario
 * @author Diego
 */
public class Usuario {
    
    private Long codUsuario;
    private String cpf;
    private String email;
    private String nome;
    private String senha;
    private String codRecuperacao;

    /**
     * Metodo que pega o codigo do usuario
     * @return codigo do usuario
     */
    public Long getCodUsuario() {
        return codUsuario;
    }

    /**
     * Metodo que seta o codigo do usuario
     * @param codUsuario codigo do usuario
     */
    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * Metodo que pega o cpf do usuario
     * @return cpf do usuario
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Metodo que seta o cpf do usuario
     * @param cpf cpf do usuario
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Metodo que pega o email do usuario
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que pega o email do usuario
     * @param email email do usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que pega o nome do usuario
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que seta o nome do usuario
     * @param nome nome do usuario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo que pega o senha do usuario
     * @return 
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Metodo que seta a senha do usuario
     * @param senha senha do usuario
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Metodo que pega o codigo de recuperacao do usuario
     * @return 
     */
    public String getCodRecuperacao() {
        return codRecuperacao;
    }

    /**
     * Metodo que seta o codigo de recuperacao do usuario
     * @param codRecuperacao codigo de recuperacao
     */
    public void setCodRecuperacao(String codRecuperacao) {
        this.codRecuperacao = codRecuperacao;
    }

    /**
     * Contrutor do usuario
     * @param cpf cpf do usuario
     * @param email email do usuario
     * @param nome nome do usuario
     * @param senha senha do usuario
     */
    public Usuario( String cpf, String email, String nome, String senha) {
        Random random = new Random();
        this.codUsuario = (long) (random.nextDouble() * 10000000L);
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    /**
     * Construtor do usuario
     */
    public Usuario() {
        Random random = new Random();
        this.codUsuario = (long) (random.nextDouble() * 10000000L);
    }
    
}
