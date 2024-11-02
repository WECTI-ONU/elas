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
        mentorias.add(new Mentoria("Desvendando a Tecnologia: Carreiras e Oportunidades no Mundo Digital", "Dra. Ana Costa - Engenheira de Software e Consultora de Inovação", "Tecnologia e Inovação Digital", "11 NOV - 10Hrs ás 12Hrs"));
        mentorias.add(new Mentoria("Do Sonho á Realidade: Criando e Gerindo Seu Próprio Negócio", "Dra. Luisa Almeida - Empreendedora e Coach de Negócios", "Empreendedorismo e Gestão de Negócios", "12 NOV - 15Hrs ás 17Hrs"));
        mentorias.add(new Mentoria("Independência Financeira para Mulheres: Construindo o Futuro", "Dra. Carla Martins - Consultora Financeira","Finanças Pessoais e Planejamento Financeiro", "14NOV - 9Hrs às 11Hrs"));
        mentorias.add(new Mentoria("Liderança e Protagonismo Feminino: Conquistando Seu Espaço", "Dra. Sofia Ribeiro - Executiva de Recursos Humanos","Liderança Feminina", "15NOV - 18Hrs às 20Hrs"));
        mentorias.add(new Mentoria("Equilíbrio Emocional e Carreira: Como Gerenciar o Estresse", "Dra. Mariana Oliveira - Psicóloga","Especialidade: Saúde Mental e Bem-Estar", "16NOV - 14Hrs às 16Hrs"));
        mentorias.add(new Mentoria("Marketing para Mulheres Empreendedoras: Conquistando Clientes Online", "Dra. Juliana Antunes - Especialista Em Markeing Digital"," Marketing Digital e Redes Sociais", "17NOV - 16Hrs às 18Hrs"));
        mentorias.add(new Mentoria("Explorando o Mundo Acadêmico: Caminhos e Oportunidades", "Dra. Paula Mendes - Professora Universitaria","Carreira Acadêmica e Pesquisa", "19NOV - 10Hrs às 12Hrs"));


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

        FloatingActionButton btnVoltar = findViewById(R.id.btnvoltar6);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telamentorias.this, telaprincipal.class);
                startActivity(intent);
                finish();
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