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

public class telanotificacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telanotificacao);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referência ao botão de voltar
        FloatingActionButton btnVoltar5 = findViewById(R.id.btnvoltar5);
        btnVoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para voltar à tela principal
                Intent intent = new Intent(telanotificacao.this, telaprincipal.class);
                startActivity(intent);
                finish(); // Opcional: chama finish() para remover a tela atual da pilha
            }
        });
    }
}
