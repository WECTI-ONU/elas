package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class telaperfil extends AppCompatActivity {
    ImageView profileImageView;
    private ActivityResultLauncher<Intent> imagePickerLauncher;
    Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaperfil);

        profileImageView = findViewById(R.id.userProfile);
        uploadButton = findViewById(R.id.uploadButton);

        //Colocando a foto do usuário como padrão
        profileImageView.setImageResource(R.drawable.user);

        FloatingActionButton btnVoltarPerfil = findViewById(R.id.btnVoltarPerfil);
        btnVoltarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaperfil.this, telaprincipal.class);
                startActivity(intent);
                finish();
            }
        });

        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedImage = result.getData().getData();
                        if (selectedImage != null) {
                            profileImageView.setImageURI(selectedImage); // Atualiza com a nova imagem
                        }
                    }
                }
        );

        uploadButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickerLauncher.launch(intent);
        });


    }
}
