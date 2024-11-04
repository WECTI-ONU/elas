package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class telavagas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private itemsAdapter itemsAdapter;
    private List<Elementos> listarElementos;
    private SearchView searchView;

    private FloatingActionButton voltar7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telavagas);
        voltar7 = findViewById(R.id.voltar7);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Definindo OnClickListener para iniciar a telaprincipal
        voltar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telavagas.this, telaprincipal.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adicione cidades à lista
        listarElementos = new ArrayList<>();

        listarElementos.add(new Elementos("Faxineira", "Limpeza",
                "Salário - R$ 2.100,00 + VA (R$ 850,00) + VT\nRealizar Limpeza de banheiros, pisos e faxinas no geral."));

        listarElementos.add(new Elementos("Motorista", "Transporte",
                "Salário - R$ 2.500,00 + VA (R$ 600,00) + VT\nResponsável por transportar passageiros e cargas."));

        listarElementos.add(new Elementos("Atendente", "Vendas",
                "Salário - R$ 1.800,00 + Comissão\nAtendimento ao cliente e realização de vendas."));

        listarElementos.add(new Elementos("Gerente de Loja", "Vendas",
                "Salário - R$ 3.500,00 + VA (R$ 700,00)\nGestão da equipe de vendas e controle de estoque."));

        listarElementos.add(new Elementos("Analista de Marketing", "Marketing",
                "Salário - R$ 4.000,00\nPlanejamento e execução de campanhas de marketing."));

        listarElementos.add(new Elementos("Programadora", "Tecnologia",
                "Salário - R$ 5.000,00\nDesenvolvimento de software e manutenção de sistemas."));

        listarElementos.add(new Elementos("Recepcionista", "Administração",
                "Salário - R$ 1.600,00 + VA (R$ 300,00)\nRecepção e atendimento ao público."));

        listarElementos.add(new Elementos("Coordenadora de Projetos", "Administração",
                "Salário - R$ 6.000,00\nCoordenação de projetos e gerenciamento de equipes."));

        listarElementos.add(new Elementos("Engenheira Civil", "Engenharia",
                "Salário - R$ 7.000,00\nPlanejamento e execução de obras civis."));

        listarElementos.add(new Elementos("Auxiliar Administrativa", "Administração",
                "Salário - R$ 1.500,00\nApoio nas atividades administrativas da empresa."));

        listarElementos.add(new Elementos("Assistente Financeira", "Finanças",
                "Salário - R$ 2.200,00\nAuxílio na gestão financeira e controle de contas."));

        listarElementos.add(new Elementos("Estágio em Recursos Humanos", "Recursos Humanos",
                "Bolsa - R$ 1.200,00\nApoio nas atividades de recrutamento e seleção."));

        listarElementos.add(new Elementos("Desenvolvedora Web", "Tecnologia",
                "Salário - R$ 4.500,00\nCriação e manutenção de websites."));

        listarElementos.add(new Elementos("Analista de Dados", "Tecnologia",
                "Salário - R$ 5.500,00\nAnálise de dados e geração de relatórios."));

        listarElementos.add(new Elementos("Técnica de Enfermagem", "Saúde",
                "Salário - R$ 3.000,00\nApoio aos enfermeiros e atendimento ao paciente."));

        listarElementos.add(new Elementos("Mecânica", "Manutenção",
                "Salário - R$ 2.800,00\nManutenção e reparo de veículos."));

        listarElementos.add(new Elementos("Arquiteta", "Arquitetura",
                "Salário - R$ 6.500,00\nDesenvolvimento de projetos arquitetônicos."));

        listarElementos.add(new Elementos("Vendedora", "Vendas",
                "Salário - R$ 1.800,00 + Comissão\nAtendimento ao cliente e vendas."));

        listarElementos.add(new Elementos("Promotora de Vendas", "Vendas",
                "Salário - R$ 1.500,00 + VA (R$ 400,00)\nPromoção de produtos em pontos de venda."));

        listarElementos.add(new Elementos("Barman", "Alimentação",
                "Salário - R$ 2.200,00\nPreparação de bebidas e atendimento ao cliente."));

        listarElementos.add(new Elementos("Garçonete", "Alimentação",
                "Salário - R$ 1.800,00 + Gorjetas\nAtendimento a clientes em restaurantes."));

        listarElementos.add(new Elementos("Auxiliar de Cozinha", "Alimentação",
                "Salário - R$ 1.500,00\nApoio nas atividades da cozinha."));

        listarElementos.add(new Elementos("Padeira", "Alimentação",
                "Salário - R$ 2.300,00\nProdução de pães e outros produtos de panificação."));

        listarElementos.add(new Elementos("Chefe de Cozinha", "Alimentação",
                "Salário - R$ 3.500,00\nGerenciamento da cozinha e da equipe."));

        listarElementos.add(new Elementos("Designer Gráfica", "Design",
                "Salário - R$ 4.000,00\nCriação de artes e material gráfico."));

        listarElementos.add(new Elementos("Consultora de Vendas", "Vendas",
                "Salário - R$ 2.800,00 + Comissão\nAssessoria a clientes na compra de produtos."));

        listarElementos.add(new Elementos("Técnica em Informática", "Tecnologia",
                "Salário - R$ 2.500,00\nSuporte técnico e manutenção de equipamentos."));

        listarElementos.add(new Elementos("Tradutora", "Linguística",
                "Salário - R$ 3.000,00\nTradução de documentos e textos."));

        listarElementos.add(new Elementos("Professora", "Educação",
                "Salário - R$ 3.200,00\nEnsino em diversas disciplinas."));

        listarElementos.add(new Elementos("Porteira", "Segurança",
                "Salário - R$ 1.500,00\nControle de acesso e segurança de prédios."));

        listarElementos.add(new Elementos("Recepcionista Bilíngue", "Administração",
                "Salário - R$ 2.500,00\nAtendimento ao público em duas línguas."));

        listarElementos.add(new Elementos("Analista de Recursos Humanos", "Recursos Humanos",
                "Salário - R$ 4.000,00\nGestão de talentos e desenvolvimento organizacional."));

        listarElementos.add(new Elementos("Coordenadora de Eventos", "Eventos",
                "Salário - R$ 5.000,00\nPlanejamento e execução de eventos corporativos."));

        itemsAdapter = new itemsAdapter(listarElementos);
        recyclerView.setAdapter(itemsAdapter);
        setupSearchView();
    }
    private void setupSearchView() {
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemsAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}