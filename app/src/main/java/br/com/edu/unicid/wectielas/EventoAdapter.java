package br.com.edu.unicid.wectielas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {
    private List<Evento> eventos;
    private OnItemClickListener listener;

    // Construtor que aceita uma lista de eventos
    public EventoAdapter(List<Evento> eventos, OnItemClickListener listener) {
        this.eventos = (eventos != null) ? eventos : new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false);
        return new EventoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {
        Evento evento = eventos.get(position);
        holder.bind(evento, listener);
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    static class EventoViewHolder extends RecyclerView.ViewHolder {
        TextView tituloEvento;
        TextView descricaoEvento;
        TextView dataEvento;
        CheckBox checkBoxInscrever;
        CardView cardView;

        EventoViewHolder(View itemView) {
            super(itemView);
            tituloEvento = itemView.findViewById(R.id.tituloEvento);
            descricaoEvento = itemView.findViewById(R.id.descricaoEvento);
            dataEvento = itemView.findViewById(R.id.dataEvento);
            checkBoxInscrever = itemView.findViewById(R.id.checkBoxInscrever);
            cardView = itemView.findViewById(R.id.cardViewEvento);
        }

        void bind(final Evento evento, final OnItemClickListener listener) {
            tituloEvento.setText(evento.getTitulo());
            descricaoEvento.setText(evento.getDescricao());
            dataEvento.setText(evento.getData());

            // Configura o estado do CheckBox
            checkBoxInscrever.setOnCheckedChangeListener(null); // Remove listener anterior para evitar loops de chamada
            checkBoxInscrever.setChecked(evento.isSelected());

            // Configura o CheckBox para alterar o estado de seleção
            checkBoxInscrever.setOnCheckedChangeListener((buttonView, isChecked) -> {
                evento.setSelected(isChecked);
                if (listener != null) {
                    listener.onItemCheck(evento, isChecked);
                }
            });

            // Configura o clique no item do evento
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(evento);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Evento evento);
        void onItemCheck(Evento evento, boolean isChecked);
    }
}
