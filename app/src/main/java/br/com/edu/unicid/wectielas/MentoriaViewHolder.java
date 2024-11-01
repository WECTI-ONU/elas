package br.com.edu.unicid.wectielas;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MentoriaViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewNome;
    private TextView textViewEspecialidade;
    private TextView textViewData;
    private TextView textViewHorario;

    public MentoriaViewHolder(View itemView) {
        super(itemView);
        textViewNome = itemView.findViewById(R.id.textView);
        textViewEspecialidade = itemView.findViewById(R.id.tvEspecialidade);
        textViewData = itemView.findViewById(R.id.textView);
        textViewHorario = itemView.findViewById(R.id.tvHorario);
    }

    public void bind(final Mentoria mentoria, final MentoriaAdapter.OnMentoriaClickListener listener) {
        textViewNome.setText(mentoria.getNomeMedico());
        textViewEspecialidade.setText(mentoria.getEspecialidade());
        textViewData.setText(mentoria.getData());
        textViewHorario.setText(mentoria.getHorario());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMentoriaClick(mentoria);
            }
        });
    }
}

