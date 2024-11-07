package br.com.edu.unicid.wectielas;

import android.content.Context;
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

public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.CursosViewHolder> {
    private List<Cursos> cursosList;
    private Context context;

    // Construtor que aceita o contexto e a lista de cursos
    public CursosAdapter(Context context, List<Cursos> cursosList) {
        this.context = context;
        this.cursosList = (cursosList != null) ? cursosList : new ArrayList<>();
    }

    @NonNull
    @Override
    public CursosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout para o item do curso
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cursos, parent, false);
        return new CursosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CursosViewHolder holder, int position) {
        Cursos curso = cursosList.get(position);

        // Define os textos nas views
        holder.nomecurso.setText(curso.getNomeCurso());
        holder.especialidade.setText(curso.getEspecialidade());
        holder.data.setText(curso.getData());
        holder.horario.setText(curso.getHorario());

        // Remove o listener anterior antes de definir o estado da CheckBox
        holder.checkBoxInscreverCurso.setOnCheckedChangeListener(null);
        holder.checkBoxInscreverCurso.setChecked(curso.isChecked());

        // Listener para a CheckBox
        holder.checkBoxInscreverCurso.setOnCheckedChangeListener((buttonView, isChecked) -> {
            curso.setChecked(isChecked); // Atualiza o estado do curso
        });
    }

    @Override
    public int getItemCount() {
        return cursosList.size();
    }

    public interface OnItemClickListener {
    }

    // ViewHolder para os itens de cursos
    public static class CursosViewHolder extends RecyclerView.ViewHolder {
        public TextView nomecurso;
        public TextView especialidade;
        public TextView data;
        public TextView horario;
        public CheckBox checkBoxInscreverCurso;
        public CardView cardView;

        public CursosViewHolder(View itemView) {
            super(itemView);
            nomecurso = itemView.findViewById(R.id.text_nome_curso);
            especialidade = itemView.findViewById(R.id.text_especialidade);
            data = itemView.findViewById(R.id.text_data);
            horario = itemView.findViewById(R.id.text_horario);
            checkBoxInscreverCurso = itemView.findViewById(R.id.checkBoxInscreverCurso);
            cardView = itemView.findViewById(R.id.cardViewCurso); // Se houver CardView no layout do item
        }
    }
}
