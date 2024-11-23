package com.pim.streaming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ConteudoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo);

        Bundle extras = Objects.requireNonNull(getIntent().getExtras());

        String titulo = extras.getString("titulo");
        String descricao = extras.getString("descricao");

        TextView tituloView = findViewById(R.id.tituloConteudo);
        TextView descricaoView = findViewById(R.id.descricaoConteudo);
        tituloView.setText(titulo);
        descricaoView.setText(descricao);

        Button botaoCurtir = findViewById(R.id.butaoCurtir);

        botaoCurtir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoCurtir.setText("Curtiu");
            }
        });
    }
}
