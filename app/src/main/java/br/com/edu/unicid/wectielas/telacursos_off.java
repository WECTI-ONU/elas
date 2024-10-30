package br.com.edu.unicid.wectielas;

import android.content.Intent; // Importar Intent para iniciar outra atividade
import android.os.Bundle;
import android.view.View; // Importar View para o OnClickListener
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class telacursos_off extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telacursos_off);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnvoltar3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referência ao botão de voltar
        FloatingActionButton btnVoltar2 = findViewById(R.id.btnvoltar4);
        btnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para voltar à tela de cursos
                Intent intent = new Intent(telacursos_off.this, telacursos.class);
                startActivity(intent);
                finish(); // Opcional: chama finish() para remover a tela atual da pilha
            }
        });

        // Referência ao botão de notificações
        FloatingActionButton btnNotificacao2 = findViewById(R.id.btnnotificacao2);
        btnNotificacao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para ir para a tela de notificações
                Intent intent = new Intent(telacursos_off.this, telanotificacao.class);
                startActivity(intent);
                finish(); // Opcional: chama finish() para remover a tela atual da pilha
            }
        });
    }
}
