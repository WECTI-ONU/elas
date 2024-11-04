package br.com.edu.unicid.wectielas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.itemsViewHolder> {

    public List<Elementos> listarElementos;
    private List<Elementos> listarElementosFiltrados;

    public itemsAdapter(List<Elementos> listarElementos) {
        this.listarElementos = listarElementos;
        this.listarElementosFiltrados = new ArrayList<>(listarElementos);
    }

    @NonNull
    @Override

    public itemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_lista,
                parent, false);
        return new itemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemsViewHolder holder, int position) {
        Elementos elemento = listarElementos.get(position);
        holder.txtnomeVaga.setText(elemento.getNomeVaga());
        holder.txtcategoria.setText(elemento.getCategoria());
        holder.txtdescricao.setText(elemento.getDescricao());

        holder.btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui você pode implementar a lógica para o botão
                // Por exemplo, mostrar um Toast com o nome da cidade
                Toast.makeText(v.getContext(), "Candidatura Realizada com Sucesso!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listarElementosFiltrados.size();
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint.toString().toLowerCase().trim();
                FilterResults results = new FilterResults();

                if (query.isEmpty()) {
                    results.values = listarElementos; // Retorna a lista completa se a pesquisa estiver vazia
                } else {
                    List<Elementos> elementosFiltrados = new ArrayList<>();
                    for (Elementos elemento : listarElementos) {
                        // Filtra pelo nome da vaga ou categoria
                        if (elemento.getNomeVaga().toLowerCase().contains(query) || elemento.getCategoria().toLowerCase().contains(query)) {
                            elementosFiltrados.add(elemento);
                        }
                    }
                    results.values = elementosFiltrados;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listarElementosFiltrados.clear();
                if (results.values != null) {
                    listarElementosFiltrados.addAll((List<Elementos>) results.values);
                }
                notifyDataSetChanged();
            }
        };

    }
        public static class itemsViewHolder extends RecyclerView.ViewHolder {
            TextView txtnomeVaga, txtcategoria, txtdescricao;
            Button btnAplicar;

            public itemsViewHolder(@NonNull View itemView) {
                super(itemView);
                txtnomeVaga = itemView.findViewById(R.id.txtnomeVaga);
                txtcategoria = itemView.findViewById(R.id.txtcategoria);
                txtdescricao = itemView.findViewById(R.id.txtdescricao);
                btnAplicar = itemView.findViewById(R.id.btnAplicar);
            }
        }
}