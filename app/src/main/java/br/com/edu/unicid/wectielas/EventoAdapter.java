package br.com.edu.unicid.wectielas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventosViewHolder> {
    private List<Evento> eventos;
    private int expandedPosition = -1;

    public EventoAdapter(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public EventosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false);
        return new EventosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventosViewHolder holder, int position) {
        Evento evento = eventos.get(position);
        holder.tituloEvento.setText(evento.getTitulo());
        holder.descricaoEvento.setText(evento.getDescricao());
        // Removido: holder.descricaoCompletaEvento.setText(evento.getDescricaoCompleta());
        holder.dataEvento.setText("Data: " + evento.getData());

        final boolean isExpanded = position == expandedPosition;
        // Removido: holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(view -> {
            expandedPosition = isExpanded ? -1 : position;
            notifyDataSetChanged();
        });

        holder.btnInscrever.setOnClickListener(v -> {
            // Lógica de inscrição no evento
        });
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    static class EventosViewHolder extends RecyclerView.ViewHolder {
        TextView tituloEvento, descricaoEvento, dataEvento;
        Button btnInscrever;

        EventosViewHolder(View itemView) {
            super(itemView);
            tituloEvento = itemView.findViewById(R.id.tituloEvento);
            descricaoEvento = itemView.findViewById(R.id.descricaoEvento);
            // Removido: descricaoCompletaEvento
            dataEvento = itemView.findViewById(R.id.dataEvento);
            // Removido: expandableLayout
            btnInscrever = itemView.findViewById(R.id.btnInscrever);
        }
    }
}
