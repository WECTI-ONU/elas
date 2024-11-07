package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MeusCursos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CursosAdapter adapter;
    private List<Cursos> cursos;
    private FloatingActionButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_cursos); // Certifique-se de que o layout esteja configurado para cursos

        recyclerView = findViewById(R.id.recyclerView); // Id do RecyclerView para cursos
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtém a lista de cursos inscritos a partir da intent
        Intent intent = getIntent();
        cursos = intent.getParcelableArrayListExtra("CURSOS_SELECIONADOS");  // Usando a mesma chave definida na tela anterior

        if (cursos == null) {
            cursos = new ArrayList<>(); // Evita NullPointerException se a lista for nula
        }

        // Configura o adapter com a lista de cursos
        adapter = new CursosAdapter(this, cursos);
        recyclerView.setAdapter(adapter);

        // Configuração do botão de voltar
        btnVoltar = findViewById(R.id.btnvoltar6); // Id do botão de voltar para cursos
        btnVoltar.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
    }
}
