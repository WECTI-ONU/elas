package br.com.edu.unicid.wectielas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class telamentorias extends AppCompatActivity implements MentoriaAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private MentoriaAdapter adapter;
    private List<Mentoria> mentorias;
    private Button btnConfirmarInscricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telamentorias);

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewMentorias); // Ajustado para o ID correto do seu layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Criar lista de mentorias
        mentorias = new ArrayList<>();
        mentorias.add(new Mentoria("Dr. Ana Silva", "Cardiologia", "10/12/2023", "14:00"));
        mentorias.add(new Mentoria("Dr. João Santos", "Pediatria", "11/12/2023", "15:30"));
        mentorias.add(new Mentoria("Dr. Fernando Fortunato", "Pediatria", "11/12/2023", "15:30"));

        // Configurar adapter
        adapter = new MentoriaAdapter(mentorias, this);
        recyclerView.setAdapter(adapter);

        // Configurar botão de confirmar inscrição
        btnConfirmarInscricao = findViewById(R.id.btnConfirmarInscricao2);
        btnConfirmarInscricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarInscricao();
            }
        });
    }

    @Override
    public void onItemClick(Mentoria mentoria) {
        // Inverte o estado de seleção da mentoria
        mentoria.setSelected(!mentoria.isSelected());
        adapter.notifyDataSetChanged();
    }

    private void confirmarInscricao() {
        boolean algumaSelecionada = false;
        for (Mentoria mentoria : mentorias) {
            if (mentoria.isSelected()) {
                algumaSelecionada = true;
                break;
            }
        }

        if (algumaSelecionada) {
            Toast.makeText(this, "Inscrição confirmada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Selecione pelo menos uma mentoria", Toast.LENGTH_SHORT).show();
        }
    }
}