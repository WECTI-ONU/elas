package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Importação necessária para botões normais
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class telaprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaprincipal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Acessando o FloatingActionButton de notificações
        FloatingActionButton notificacaoButton = findViewById(R.id.notificacao);

        // Definindo o OnClickListener para abrir a tela de notificações
        notificacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaprincipal.this, telanotificacao.class);
                startActivity(intent);
            }
        });

        // Outros botões e configurações
        FloatingActionButton seuperfilButton = findViewById(R.id.seuperfil);
        seuperfilButton.setOnClickListener(view -> startActivity(new Intent(telaprincipal.this, telaperfil.class)));

        Button botaoCursos = findViewById(R.id.btncursos);
        botaoCursos.setOnClickListener(view -> startActivity(new Intent(telaprincipal.this, telacursos.class)));

        Button botaoMentorias = findViewById(R.id.btnmentorias);
        botaoMentorias.setOnClickListener(view -> startActivity(new Intent(telaprincipal.this, telamentorias.class)));

        Button botaoVagas = findViewById(R.id.btnvagas);
        botaoVagas.setOnClickListener(view -> startActivity(new Intent(telaprincipal.this, telavagas.class)));

        Button botaoEventos = findViewById(R.id.btneventos);
        botaoEventos.setOnClickListener(view -> startActivity(new Intent(telaprincipal.this, telaeventos.class)));
    }
}
