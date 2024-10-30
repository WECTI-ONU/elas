package br.com.edu.unicid.wectielas;

import android.content.Intent; // Adicione esta importação
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Adicione esta importação
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_login);

        // Configure o listener para o botão "Entrar"
        Button entrarButton = findViewById(R.id.btnentrar); // Acesse o botão "Entrar"
        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaLogin.this, telaprincipal.class);
                startActivity(intent); // Inicie a nova Activity
                finish(); // Opcional: Finaliza a Activity atual para que não volte a ela ao pressionar "voltar"
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
