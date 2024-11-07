package br.com.edu.unicid.wectielas;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CursosViewHolder extends RecyclerView.ViewHolder {
    public TextView nomecurso;
    public TextView especialidade;
    public TextView data;
    public TextView horario;
    public CheckBox checkBoxInscreverCurso;

    public CursosViewHolder(View itemView) {
        super(itemView);
        nomecurso = itemView.findViewById(R.id.text_nome_curso);
        especialidade = itemView.findViewById(R.id.text_especialidade);
        data = itemView.findViewById(R.id.text_data);
        horario = itemView.findViewById(R.id.text_horario);
        checkBoxInscreverCurso = itemView.findViewById(R.id.checkBoxInscreverCurso);
    }
}