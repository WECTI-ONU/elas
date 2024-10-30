package br.com.edu.unicid.wectielas;

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle;
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import android.widget.Switch; // Importa a classe Switch

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telacriarconta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telacriarconta);

        // Configura o listener para o Switch
        Switch switchNomeSocial = findViewById(R.id.switchNomeSocial); // Acesse o Switch
        switchNomeSocial.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Inicia a nova Activity quando o Switch for ativado
                Intent intent = new Intent(telacriarconta.this, telacriarconta2.class);
                startActivity(intent); // Inicie a nova Activity
                switchNomeSocial.setChecked(false);
            }
        });

        // Configura o listener para o botão "Entrar"
        Button btnEntrar = findViewById(R.id.btnentrar); // Encontra o botão
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telacriarconta.this, telaprincipal.class); // Altere para o nome da sua tela principal
                startActivity(intent); // Inicie a nova Activity
            }
        });

        // Configura o listener para aplicar os insets na visualização principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btneventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
