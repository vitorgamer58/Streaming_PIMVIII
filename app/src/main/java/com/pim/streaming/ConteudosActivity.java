package com.pim.streaming;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConteudosActivity extends AppCompatActivity {
    List<MyModel> myModelList;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    private ConteudoApiService conteudoApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.conteudos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.8:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        conteudoApiService = retrofit.create(ConteudoApiService.class);

        getConteudos();
    }

    private void getConteudos() {
        Log.d("API_CALL", "Iniciando a requisição para a API");
        Call<List<MyModel>> call = conteudoApiService.getConteudos();

        call.enqueue(new Callback<List<MyModel>>() {
            @Override
            public void onResponse(Call<List<MyModel>> call, Response<List<MyModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    myModelList = response.body();
                    displayItems();
                } else {
                    Log.e("API_CALL", "Resposta da API não foi bem-sucedida");
                }
            }

            @Override
            public void onFailure(Call<List<MyModel>> call, Throwable t) {
                Log.e("API_CALL", "Erro na chamada da API: " + t.getMessage());
            }
        });
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        customAdapter = new CustomAdapter(this, myModelList);

        recyclerView.setAdapter(customAdapter);
    }
}
