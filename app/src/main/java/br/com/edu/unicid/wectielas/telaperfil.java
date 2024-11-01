package br.com.edu.unicid.wectielas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telaperfil extends AppCompatActivity {
    ImageView arrow;
    ImageView profileImageView;
    /*variável que define um launcher (iniciador) de activity,
     * usado para abrir outra atividade e processar o resultado quando a ação é concluída.*/
    private ActivityResultLauncher<Intent> imagePickerLauncher;
    Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaperfil);
        //Flecha que irei usar para fazer o botão de retorno
        arrow = findViewById(R.id.arrow);
        profileImageView = findViewById(R.id.userProfile);
        uploadButton = findViewById(R.id.uploadButton);

        //Launcher = Iniciador de activity

        //registerForActivityResult = método registra um lançador para iniciar a atividade e receber o resultado.
        imagePickerLauncher = registerForActivityResult(
                //d efine que o tipo de ação que será realizada envolve iniciar uma nova atividade (neste caso, abrir a galeria).
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    //verificando o resultado e pegue a imagem selecionada
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        //extrai o URI da imagem selecionada, que é o "endereço" da imagem no dispositivo.
                        Uri selectedImage = result.getData().getData();
                        //seta o endereço da imagem no imageView
                        profileImageView.setImageURI(selectedImage);
                    }
                }
        );

        // Defina a ação do botão de upload para abrir a galeria
        uploadButton.setOnClickListener(v -> {
            //cria um Intent que especifica a ação de abrir a galeria de imagens (usando Intent.ACTION_PICK)
            //e a localização do conteúdo, neste caso, as imagens armazenadas
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickerLauncher.launch(intent); // Abra a galeria
        });
    }
}