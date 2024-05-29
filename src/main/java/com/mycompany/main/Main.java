/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author aluno
 */
public class Main {

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Produto p = new Produto("Leite 1L", 4.79);
        estoque.adicionarProdutos(p);
        p = new Produto("Açaí 3,5Kg", 23.50);
        estoque.adicionarProdutos(p);
        p = new Produto("Pct Pão de Queijo 1 Kg", 15.99);
        estoque.adicionarProdutos(p);
        
        estoque.imprimeEstoque();
        
        estoque.removerProdutos(3);
        
        estoque.imprimeEstoque();
        
        System.out.println("Total de produtos cadastrados: " + (Produto.getAutoIncrement() - 1));
    }
}
