// telaeventos.java
package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class telaeventos extends AppCompatActivity implements EventoAdapter.OnItemClickListener {

    private RecyclerView recyclerEventos;
    private EventoAdapter adapter;
    private List<Evento> eventos;
    private Button btnConfirmarInscricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaeventos);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerEventos = findViewById(R.id.recyclerEventos);
        recyclerEventos.setLayoutManager(new LinearLayoutManager(this));

        eventos = new ArrayList<>();
        eventos.add(new Evento("Workshop de Liderança Feminina", "Aprenda técnicas de liderança...", "Neste workshop, discutiremos abordagens inovadoras de liderança feminina, com estratégias baseadas nos ODS.", "2024-11-01"));
        eventos.add(new Evento("Palestra sobre Empreendedorismo Social", "Com Ana Souza, especialista...", "Ana Souza abordará como o empreendedorismo pode promover a igualdade de gênero e apoiar o desenvolvimento sustentável.", "2024-11-15"));
        eventos.add(new Evento("Oficina de Autocuidado e Saúde Mental", "Focada no bem-estar feminino...", "Explore práticas de autocuidado e a importância da saúde mental para uma vida equilibrada e produtiva.", "2024-11-20"));
        eventos.add(new Evento("Mesa Redonda sobre Direitos Humanos", "Debate com diversas especialistas...", "Uma conversa aprofundada sobre os direitos das mulheres e a importância de políticas públicas inclusivas.", "2024-11-25"));

        adapter = new EventoAdapter(eventos, this);
        recyclerEventos.setAdapter(adapter);

        btnConfirmarInscricao = findViewById(R.id.btnConfirmarInscricao);
        btnConfirmarInscricao.setOnClickListener(v -> confirmarInscricao());

        FloatingActionButton btnVoltar = findViewById(R.id.btnvoltar8);
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(telaeventos.this, telaprincipal.class);
            startActivity(intent);
            finish();
        });

        Button btnMeusEventos = findViewById(R.id.btnMinhasEventos);
        btnMeusEventos.setOnClickListener(v -> {
            Intent intent = new Intent(telaeventos.this, MeusEventos.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemClick(Evento evento) {
        evento.setSelected(!evento.isSelected());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemCheck(Evento evento, boolean isChecked) {
        evento.setSelected(isChecked);
        adapter.notifyDataSetChanged();
    }

    private void confirmarInscricao() {
        List<Evento> eventosSelecionados = new ArrayList<>();

        for (Evento evento : eventos) {
            if (evento.isSelected()) {
                eventosSelecionados.add(evento);
            }
        }

        if (!eventosSelecionados.isEmpty()) {
            Toast.makeText(this, "Inscrição confirmada!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(telaeventos.this, MeusEventos.class);
            intent.putParcelableArrayListExtra("EVENTOS_INSCRITOS", (ArrayList<? extends Parcelable>) eventosSelecionados);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Selecione pelo menos um evento para confirmar a inscrição.", Toast.LENGTH_SHORT).show();
        }
    }
}
