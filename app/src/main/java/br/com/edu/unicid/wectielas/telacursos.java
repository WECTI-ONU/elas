package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class telacursos extends AppCompatActivity implements CursosAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private CursosAdapter cursosAdapter;
    private List<Cursos> cursosList;
    private Button btnConfirmarCursos;
    private Button btnMeusCursos;  // Botão para Meus Cursos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacursos);

        // Configura o RecyclerView para cursos
        recyclerView = findViewById(R.id.recyclerViewCursos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Cria lista de cursos de exemplo
        cursosList = new ArrayList<>();
        cursosList.add(new Cursos("Curso de Android", "Desenvolvimento", "01/01/2023", "10:00"));
        cursosList.add(new Cursos("Curso de Java", "Programação", "02/01/2023", "14:00"));
        cursosList.add(new Cursos("Curso de Design", "Criatividade", "03/01/2023", "16:00"));

        // Configura o adapter com o listener
        cursosAdapter = new CursosAdapter(this, cursosList);
        recyclerView.setAdapter(cursosAdapter);

        // Botão para confirmar cursos selecionados
        btnConfirmarCursos = findViewById(R.id.btnConfirmarCursos2);
        btnConfirmarCursos.setOnClickListener(view -> confirmarCursos());

        // Botão de voltar para a tela principal
        FloatingActionButton btnVoltar = findViewById(R.id.btnvoltar);
        btnVoltar.setOnClickListener(view -> {
            Intent intent = new Intent(telacursos.this, telaprincipal.class);
            startActivity(intent);
            finish();
        });

        // Botão para acessar os cursos selecionados (ir para Meus Cursos)
        btnMeusCursos = findViewById(R.id.btnMeusCursos2);
        btnMeusCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para navegar até a tela MeusCursos
                Intent intent = new Intent(telacursos.this, MeusCursos.class);
                startActivity(intent);
            }
        });
    }

    // Método chamado ao clicar no item do curso
    public void onItemClick(Cursos curso) {
        // Inverte o estado de seleção do curso
        curso.setChecked(!curso.isChecked());
        cursosAdapter.notifyDataSetChanged();
    }

    // Método para confirmar cursos selecionados
    private void confirmarCursos() {
        List<Cursos> cursosSelecionados = new ArrayList<>();

        // Filtra os cursos selecionados
        for (Cursos curso : cursosList) {
            if (curso.isChecked()) {
                cursosSelecionados.add(curso);
            }
        }

        if (!cursosSelecionados.isEmpty()) {
            // Exibe mensagem de confirmação
            Toast.makeText(this, "Cursos selecionados confirmados!", Toast.LENGTH_SHORT).show();

            // Envia os cursos selecionados para a tela de cursos
            Intent intent = new Intent(telacursos.this, MeusCursos.class);
            intent.putParcelableArrayListExtra("CURSOS_SELECIONADOS", (ArrayList<? extends Parcelable>) cursosSelecionados);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Selecione pelo menos um curso", Toast.LENGTH_SHORT).show();
        }
    }
}
