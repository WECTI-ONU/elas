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

public class telaeventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaeventos);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configuração do OnClickListener para o botão btnvoltar8
        FloatingActionButton btnvoltar8 = findViewById(R.id.btnvoltar8);
        btnvoltar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaeventos.this, telaprincipal.class);
                startActivity(intent);
                finish();
            }
        });

        // Configuração do OnClickListener para o botão notificacao2
        FloatingActionButton notificacao2 = findViewById(R.id.notificacao2);
        notificacao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaeventos.this, telanotificacao.class);
                startActivity(intent);
            }
        });
    }
}
