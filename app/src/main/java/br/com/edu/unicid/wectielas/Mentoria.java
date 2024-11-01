package br.com.edu.unicid.wectielas;

public class Mentoria {
    private String nomeMedico;
    private String especialidade;
    private String data;
    private String horario;
    private boolean selected;

    public Mentoria(String nomeMedico, String especialidade, String data, String horario) {
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.data = data;
        this.horario = horario;
        this.selected = false;
    }

    // Getters
    public String getNomeMedico() { return nomeMedico; }
    public String getEspecialidade() { return especialidade; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
    public boolean isSelected() { return selected; }

    // Setters
    public void setSelected(boolean selected) { this.selected = selected; }
}