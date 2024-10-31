package br.com.edu.unicid.wectielas;

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle;
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch; // Importa a classe Switch

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class telacriarconta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telacriarconta);

        EditText edtNome1 = findViewById(R.id.edtNome1);
        EditText edtCpf1 = findViewById(R.id.edtCpf1);
        EditText edtDataDeNascimento1 = findViewById(R.id.edtDataDeNascimento1);
        EditText edtCep1 = findViewById(R.id.edtCep1);
        EditText edtRua1 = findViewById(R.id.edtRua1);
        EditText edtComplemento1 = findViewById(R.id.edtComplemento1);
        EditText edtCidade1 = findViewById(R.id.edtCidade1);
        EditText edtNumero1 = findViewById(R.id.edtNumero1);
        EditText edtBairro1 = findViewById(R.id.edtBairro1);
        EditText edtEstado1 = findViewById(R.id.edtEstado1);
        EditText edtEmail1 = findViewById(R.id.edtEmail1);
        EditText edtSenha1 = findViewById(R.id.edtSenha1);

        Switch switchNomeSocial = findViewById(R.id.switchNomeSocial);
        EditText myEditText = findViewById(R.id.edtNomeSocial);
        myEditText.setVisibility(View.GONE);

        switchNomeSocial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myEditText.setVisibility(View.VISIBLE);
                } else {
                    myEditText.setVisibility(View.GONE);
                }
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

        // Configuração do OnClickListener para o botão btnvoltar8
        FloatingActionButton btnVoltarCadastro = findViewById(R.id.btnVoltarCadastro);
        btnVoltarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telacriarconta.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
