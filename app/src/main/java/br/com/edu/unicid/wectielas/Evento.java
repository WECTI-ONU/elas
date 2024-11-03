package br.com.edu.unicid.wectielas;

import android.os.Parcel;
import android.os.Parcelable;

public class Evento implements Parcelable {
    private String titulo;
    private String descricao;
    private String descricaoCompleta;
    private String data;
    private boolean selected;

    public Evento(String titulo, String descricao, String descricaoCompleta, String data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.descricaoCompleta = descricaoCompleta;
        this.data = data;
        this.selected = false;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getDescricaoCompleta() { return descricaoCompleta; }
    public String getData() { return data; }
    public boolean isSelected() { return selected; }

    // Setters
    public void setSelected(boolean selected) { this.selected = selected; }

    // Métodos Parcelable
    protected Evento(Parcel in) {
        titulo = in.readString();
        descricao = in.readString();
        descricaoCompleta = in.readString();
        data = in.readString();
        selected = in.readByte() != 0; // Converte byte para boolean
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descricao);
        dest.writeString(descricaoCompleta);
        dest.writeString(data);
        dest.writeByte((byte) (selected ? 1 : 0)); // Converte boolean para byte
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Evento> CREATOR = new Creator<Evento>() {
        @Override
        public Evento createFromParcel(Parcel in) {
            return new Evento(in);
        }

        @Override
        public Evento[] newArray(int size) {
            return new Evento[size];
        }
    };
}
