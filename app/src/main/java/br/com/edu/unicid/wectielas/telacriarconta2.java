package br.com.edu.unicid.wectielas;

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle;
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class telacriarconta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telacriarconta2); // Verifique se o layout está correto

        // Configura o listener para o Switch
        Switch switchNomeSocial2 = findViewById(R.id.switchNomeSocial2); // Acesse o Switch
        switchNomeSocial2.setChecked(true);
        switchNomeSocial2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!switchNomeSocial2.isChecked()) {
                // Inicia a nova Activity quando o Switch for ativado
                Intent intent = new Intent(telacriarconta2.this, telacriarconta.class);
                startActivity(intent); // Inicie a nova Activity
            }
        });

        // Configura o listener para o botão "Entrar"
        Button btnEntrar = findViewById(R.id.btnentrar2); // Acesse o botão pelo ID correto
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a tela principal ao clicar no botão
                Intent intent = new Intent(telacriarconta2.this, telaprincipal.class);
                startActivity(intent); // Inicie a nova Activity
                finish(); // Finaliza a tela atual
            }
        });
    }
}
