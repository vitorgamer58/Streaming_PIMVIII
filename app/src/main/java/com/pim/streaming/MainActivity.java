package com.pim.streaming;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ConteudoApiService conteudoApiService;
    private ConteudoAdapter conteudoAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.8:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        conteudoApiService = retrofit.create(ConteudoApiService.class);

        getConteudos();
    }

    private void getConteudos() {
        Log.d("API_CALL", "Iniciando a requisição para a API");
        Call<List<Conteudo>> call = conteudoApiService.getPopularMovies();

        call.enqueue(new Callback<List<Conteudo>>() {
            @Override
            public void onResponse(Call<List<Conteudo>> call, Response<List<Conteudo>> response) {
                Log.d("API_CALL", "Resposta recebida da API");
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API_CALL", "Dados: " + response.body().toString());
                    List<Conteudo> conteudos = response.body();

                    // Configurar o Adapter com os dados recebidos
                    conteudoAdapter = new ConteudoAdapter(conteudos);
                    recyclerView.setAdapter(conteudoAdapter);
                } else {
                    Log.e("API_CALL", "Resposta da API não foi bem-sucedida");
                }
            }

            @Override
            public void onFailure(Call<List<Conteudo>> call, Throwable t) {
                Log.e("API_CALL", "Erro na chamada da API: " + t.getMessage());
            }
        });
    }
}