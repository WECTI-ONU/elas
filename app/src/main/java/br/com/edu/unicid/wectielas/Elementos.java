package br.com.edu.unicid.wectielas;

public class Elementos {
    private String nomeVaga;
    private String categoria;
    private String descricao;

    public Elementos(String nomeVaga, String categoria, String descricao){
        this.nomeVaga = nomeVaga;
        this.categoria = categoria;
        this.descricao = descricao;

    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }
}
