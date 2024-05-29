/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Arrays;

/**
 *
 * @author aluno
 */
public class Estoque {
    private Produto produtos[] = new Produto[50];
    private int index;
    
    public void adicionarProdutos(Produto p){
        produtos[index] = p;
        index+=1;
    }
    
    public void removerProdutos(int key){
        for(int i = 0; i < 50; i++){
            Produto p = produtos[i];
            if(p != null) {
                if(p.getIdProduto() == key){ 
                    index-=1;
                    produtos[i] = null;
                    break;
                }
            }
        }
        Arrays.sort(produtos);
    }
    
    public void imprimeEstoque(){
        System.out.println("Produtos no estoque:");
        for(int i = 0; i < 50; i++){
            Produto p = produtos[i];
            if(p != null) {
                System.out.printf("%d: %s, R$ %.2f\n", i+1, p.getDescricao(), p.getValor());
            }
        }
    }

    public int getIndex() {
        return index;
    }
}
