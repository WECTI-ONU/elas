package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MinhasMentorias extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MentoriaAdapter adapter;
    private List<Mentoria> mentorias;
    private FloatingActionButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao_mentoria);

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewMinhasMentorias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Recuperar lista de mentorias inscritas
        Intent intent = getIntent();
        mentorias = intent.getParcelableArrayListExtra("MENTORIAS_INSCRITAS");

        // Configurar adapter
        adapter = new MentoriaAdapter(mentorias, null);
        recyclerView.setAdapter(adapter);

        // Botão de voltar
        btnVoltar = findViewById(R.id.btnvoltar6);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK); // Retorna um resultado para a Activity chamadora
                finish(); // Finaliza a tela atual
            }
        });
    }
}