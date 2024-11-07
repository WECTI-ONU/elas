package br.com.edu.unicid.wectielas;

import android.os.Parcel;
import android.os.Parcelable;

public class Cursos implements Parcelable {
    private String nomeCurso;
    private String especialidade;
    private String data;
    private String horario;
    private boolean checked;

    public Cursos(String nomeCurso, String especialidade, String data, String horario) {
        this.nomeCurso = nomeCurso;
        this.especialidade = especialidade;
        this.data = data;
        this.horario = horario;
        this.checked = false; // Inicia como não selecionado
    }

    // Métodos Parcelable
    protected Cursos(Parcel in) {
        nomeCurso = in.readString();
        especialidade = in.readString();
        data = in.readString();
        horario = in.readString();
        checked = in.readByte() != 0;
    }

    public static final Creator<Cursos> CREATOR = new Creator<Cursos>() {
        @Override
        public Cursos createFromParcel(Parcel in) {
            return new Cursos(in);
        }

        @Override
        public Cursos[] newArray(int size) {
            return new Cursos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeCurso);
        dest.writeString(especialidade);
        dest.writeString(data);
        dest.writeString(horario);
        dest.writeByte((byte) (checked ? 1 : 0));
    }

    // Getters e Setters
    public String getNomeCurso() { return nomeCurso; }
    public String getEspecialidade() { return especialidade; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
}
