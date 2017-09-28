package br.com.opet.tds.meusprodutosapp.DAO;

/**
 * Created by zx on 13/09/2017.
 */

public class Produto {
    private int ID;
    private String nome;
    private String descricao;
    private double preco;
    private boolean vendido;


    public Produto() {
    }

    public Produto(int ID, String nome, String descricao, double preco, boolean vendido) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.vendido = vendido;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
}
