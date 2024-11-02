package br.com.edu.unicid.wectielas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MentoriaAdapter extends RecyclerView.Adapter<MentoriaAdapter.MentoriaViewHolder> {
    private List<Mentoria> mentorias;
    private OnItemClickListener listener;

    // Construtor que aceita uma lista de mentorias
    public MentoriaAdapter(List<Mentoria> mentorias, OnItemClickListener listener) {
        this.mentorias = (mentorias != null) ? mentorias : new ArrayList<>(); // Inicializa com uma lista vazia se for null
        this.listener = listener;
    }

    @NonNull
    @Override
    public MentoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mentoria, parent, false);
        return new MentoriaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MentoriaViewHolder holder, int position) {
        Mentoria mentoria = mentorias.get(position);
        holder.bind(mentoria, listener); // Usa o listener correto
    }

    @Override
    public int getItemCount() {
        return mentorias.size(); // Isso não deve causar NullPointerException agora
    }

    static class MentoriaViewHolder extends RecyclerView.ViewHolder {
        TextView nomeMedico;
        TextView especialidade;
        TextView data;
        TextView horario;
        CardView cardView;

        MentoriaViewHolder(View itemView) {
            super(itemView);
            nomeMedico = itemView.findViewById(R.id.tvNomeMentor);
            especialidade = itemView.findViewById(R.id.tvEspecialidade);
            data = itemView.findViewById(R.id.tvData);
            horario = itemView.findViewById(R.id.tvHorario);
            cardView = itemView.findViewById(R.id.cardView);
        }

        void bind(final Mentoria mentoria, final OnItemClickListener listener) {
            nomeMedico.setText(mentoria.getNomeMedico());
            especialidade.setText(mentoria.getEspecialidade());
            data.setText(mentoria.getData());
            horario.setText(mentoria.getHorario());

            itemView.setOnClickListener(v -> listener.onItemClick(mentoria)); // Corrigido para chamar o método correto
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Mentoria mentoria); // Método para lidar com o clique
    }
}