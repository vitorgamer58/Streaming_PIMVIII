package com.pim.streaming;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<MyModel> myModelList;
    CustomAdapter customAdapter;

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

        displayItems();
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myModelList = new ArrayList<>();

        myModelList.add(new MyModel("Lord vinheteiro perdeu a senha dos BITCOIN", "Vamos falar sobre a perda da senha dos bitcoins do Lord Vinheteiro", "AncapSu"));
        myModelList.add(new MyModel("Qual a melhor linguagem de programação?", "Eu fazia tudo em python", "Cortes do Ciência Sem Fim [OFICIAL]"));
        myModelList.add(new MyModel("A fantástica fábrica das crianças coach", "", "mano deyvin"));
        myModelList.add(new MyModel("ATENÇÃO! SAIBA DISSO ANTES DE VIR AO PARAGUAI", "Paraguai não é para qualquer um", "Porque o Paraguai?"));
        myModelList.add(new MyModel("Downloading images from US Military Satellites", "Is this legal?", "saveitforparts"));
        myModelList.add(new MyModel("#93 O ISO Mitos e Verdades !!!", "", "Câmera Velha"));
        myModelList.add(new MyModel("Passeio a Kherson no segundo aniversário da libertação da cidade", "Estou aqui na Ucrânia, na cidade de Kherson", "Diários da Quarentena"));
        myModelList.add(new MyModel("15 de Nov: Forças Ucranianas avançam e retomam Terny!", "", "Boletim d aUcrânia"));

        customAdapter = new CustomAdapter(this, myModelList);

        recyclerView.setAdapter(customAdapter);
    }
}