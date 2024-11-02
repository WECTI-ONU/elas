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
        recyclerView = findViewById(R.id.recyclerViewMentorias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Criar lista de mentorias
        mentorias = new ArrayList<>();
        mentorias.add(new Mentoria("Desvendando a Tecnologia: Carreiras e Oportunidades no Mundo Digital", "Dra. Ana Costa - Engenheira de Software e Consultora de Inovação", "Tecnologia e Inovação Digital", "11 NOV - 10Hrs às 12Hrs"));
        mentorias.add(new Mentoria("Do Sonho à Realidade: Criando e Gerindo Seu Próprio Negócio", "Dra. Luisa Almeida - Empreendedora e Coach de Negócios", "Empreendedorismo e Gestão de Negócios", "12 NOV - 15Hrs às 17Hrs"));
        mentorias.add(new Mentoria("Independência Financeira para Mulheres: Construindo o Futuro", "Dra. Carla Martins - Consultora Financeira", "Finanças Pessoais e Planejamento Financeiro", "14 NOV - 9Hrs às 11Hrs"));
        mentorias.add(new Mentoria("Liderança e Protagonismo Feminino: Conquistando Seu Espaço", "Dra. Sofia Ribeiro - Executiva de Recursos Humanos", "Liderança Feminina", "15 NOV - 18Hrs às 20Hrs"));
        mentorias.add(new Mentoria("Equilíbrio Emocional e Carreira: Como Gerenciar o Estresse", "Dra. Mariana Oliveira - Psicóloga", "Especialidade: Saúde Mental e Bem-Estar", "16 NOV - 14Hrs às  16Hrs"));
        mentorias.add(new Mentoria("Marketing para Mulheres Empreendedoras: Conquistando Clientes Online", "Dra. Juliana Antunes - Especialista Em Marketing Digital", "Marketing Digital e Redes Sociais", "17 NOV - 16Hrs às 18Hrs"));
        mentorias.add(new Mentoria("Explorando o Mundo Acadêmico: Caminhos e Oportunidades", "Dra. Paula Mendes - Professora Universitária", "Carreira Acadêmica e Pesquisa", "19 NOV - 10Hrs às 12Hrs"));

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

        // Botão de voltar
        FloatingActionButton btnVoltar = findViewById(R.id.btnvoltar6);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telamentorias.this, telaprincipal.class);
                startActivity(intent);
                finish();
            }
        });

        // Botão para Minhas Mentorías
        Button btnMinhasMentorias = findViewById(R.id.btnMinhasMentorias);
        btnMinhasMentorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telamentorias.this, MinhasMentorias.class);
                startActivity(intent);
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
        List<Mentoria> mentoriasSelecionadas = new ArrayList<>();

        for (Mentoria mentoria : mentorias) {
            if (mentoria.isSelected()) {
                mentoriasSelecionadas.add(mentoria);
            }
        }

        if (!mentoriasSelecionadas.isEmpty()) {
            Toast.makeText(this, "Inscrição confirmada!", Toast.LENGTH_SHORT).show();

            // Criar Intent para a tela Minhas Mentorías
            Intent intent = new Intent(telamentorias.this, MinhasMentorias.class);
            intent.putParcelableArrayListExtra("MENTORIAS_INSCRITAS", (ArrayList<? extends Parcelable>) mentoriasSelecionadas);
            startActivityForResult(intent, 1); // Usando startActivityForResult
        } else {
            Toast.makeText(this, "Selecione pelo menos uma mentoria", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Aqui você pode fazer algo se necessário quando retornar da tela de "Minhas Mentorías"
        }
    }
}