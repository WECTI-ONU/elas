package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MeusEventos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EventoAdapter adapter;
    private List<Evento> eventos;
    private FloatingActionButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao_eventos);

        recyclerView = findViewById(R.id.recyclerViewMeusEventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtém a lista de eventos inscritos a partir da intent
        Intent intent = getIntent();
        eventos = intent.getParcelableArrayListExtra("EVENTOS_INSCRITOS");
        if (eventos == null) eventos = new ArrayList<>(); // Evita NullPointerException se a lista for nula

        // Configura o adapter com a lista de eventos
        adapter = new EventoAdapter(eventos, null);
        recyclerView.setAdapter(adapter);

        // Configuração do botão de voltar
        btnVoltar = findViewById(R.id.btnvoltarEventos);
        btnVoltar.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
    }
}
