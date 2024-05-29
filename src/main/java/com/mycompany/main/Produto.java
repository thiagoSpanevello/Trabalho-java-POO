/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author aluno
 */
public class Produto {
    private int idProduto;
    private String descricao;
    private double valor;
    
    static int autoIncrement = 1;

    public Produto(String descricao, double valor) {
        this.idProduto = Produto.autoIncrement;
        this.descricao = descricao;
        this.valor = valor;
        
        Produto.autoIncrement += 1;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static int getAutoIncrement() {
        return Produto.autoIncrement;
    }
    
    
}
