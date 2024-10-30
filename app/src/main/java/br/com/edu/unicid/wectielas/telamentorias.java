package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class telamentorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telamentorias);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referência para o FloatingActionButton btnvoltar6
        FloatingActionButton btnVoltar6 = findViewById(R.id.btnvoltar6);

        // Definindo OnClickListener para iniciar a telaprincipal
        btnVoltar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telamentorias.this, telaprincipal.class);
                startActivity(intent);
                finish();
            }
        });

        // Referência para o FloatingActionButton notificacao5
        FloatingActionButton notificacao5 = findViewById(R.id.notificacao5);

        // Definindo OnClickListener para iniciar a telanotificacao
        notificacao5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telamentorias.this, telanotificacao.class);
                startActivity(intent);
            }
        });
    }
}
