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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configure o listener para o botão de login
        Button loginButton = findViewById(R.id.button); // Acesse o botão de login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, telaLogin.class);
                startActivity(intent); // Inicie a nova Activity
            }
        });

        // Configure o listener para o botão de criar conta
        Button criarContaButton = findViewById(R.id.btnentrar); // Acesse o botão de criar conta
        criarContaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, telacriarconta.class);
                startActivity(intent); // Inicie a nova Activity
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}