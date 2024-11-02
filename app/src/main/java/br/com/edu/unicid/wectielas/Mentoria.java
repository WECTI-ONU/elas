package br.com.edu.unicid.wectielas;

import android.os.Parcel;
import android.os.Parcelable;

public class Mentoria implements Parcelable {
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

    // Métodos Parcelable
    protected Mentoria(Parcel in) {
        nomeMedico = in.readString();
        especialidade = in.readString();
        data = in.readString();
        horario = in.readString();
        selected = in.readByte() != 0; // Converte byte para boolean
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeMedico);
        dest.writeString(especialidade);
        dest.writeString(data);
        dest.writeString(horario);
        dest.writeByte((byte) (selected ? 1 : 0)); // Converte boolean para byte
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mentoria> CREATOR = new Creator<Mentoria>() {
        @Override
        public Mentoria createFromParcel(Parcel in) {
            return new Mentoria(in);
        }

        @Override
        public Mentoria[] newArray(int size) {
            return new Mentoria[size];
        }
    };
}