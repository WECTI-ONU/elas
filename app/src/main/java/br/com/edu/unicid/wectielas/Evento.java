package br.com.edu.unicid.wectielas;

public class Evento {
    private String titulo;
    private String descricao;
    private String descricaoCompleta;
    private String data;

    public Evento(String titulo, String descricao, String descricaoCompleta, String data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.descricaoCompleta = descricaoCompleta;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public String getData() {
        return data;
    }
}
