package br.com.edu.unicid.wectielas;

import android.annotation.SuppressLint;
import android.content.Intent; // Importa a classe Intent
import android.os.Bundle;
import android.util.Log;
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class telacriarconta extends AppCompatActivity {

    EditText edtNome1;
    EditText edtCpf1;
    EditText edtdataNasci1;
    EditText edtcep1;
    EditText edtRua1;
    EditText edtCidade1;
    EditText edtNumero1;
    EditText edtBairro1;
    EditText edtEstado1;
    EditText edtEmail1;
    EditText edtSenha1;
    EditText edtnomeSocial1;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telacriarconta);

        edtNome1 = findViewById(R.id.edtNome1);
        edtCpf1 = findViewById(R.id.edtCpf1);
        edtdataNasci1 = findViewById(R.id.edtdataNasci1);
        edtcep1 = findViewById(R.id.cep1);
        edtRua1 = findViewById(R.id.edtRua1);
        edtCidade1 = findViewById(R.id.edtCidade1);
        edtNumero1 = findViewById(R.id.edtNumero1);
        edtBairro1 = findViewById(R.id.edtBairro1);
        edtEstado1 = findViewById(R.id.edtEstado1);
        edtEmail1 = findViewById(R.id.edtEmail1);
        edtSenha1 = findViewById(R.id.edtSenha1);
        edtnomeSocial1 = findViewById(R.id.edtnomeSocial1);



        // Configura o listener para o botão "Entrar"
        Button btnEntrar = findViewById(R.id.btnentrar); // Encontra o botão
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (validarCampos()) {
                    // Todos os campos estão preenchidos, prosseguir com a ação
                    Intent intent = new Intent(telacriarconta.this, telaprincipal.class);
                    startActivity(intent);
                } else {
                    // Exibir mensagem de erro ou realizar outra ação
                    Toast.makeText(telacriarconta.this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
                }
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


    //Função que confere se os campos estão preenchidos
    private boolean validarCampos() {
        boolean camposValidos = true;

        List<EditText> editTexts = new ArrayList<>();
        editTexts.add(edtNome1);
        editTexts.add(edtCpf1);
        editTexts.add(edtdataNasci1);
        editTexts.add(edtcep1);
        editTexts.add(edtRua1);
        editTexts.add(edtCidade1);
        editTexts.add(edtNumero1);
        editTexts.add(edtBairro1);
        editTexts.add(edtEstado1);
        editTexts.add(edtEmail1);
        editTexts.add(edtSenha1);
        editTexts.add(edtnomeSocial1);

        for (EditText editText : editTexts) {
            if (editText != null && editText.getText().toString().trim().isEmpty()) {
                Log.d("Validation", "Campo vazio: " + editText.getId());
                editText.setError("Campo obrigatório");
                camposValidos = false;
                break;
            }
        }



        return camposValidos;
    }
}
