package com.pim.streaming;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<MyModel> list;

    public CustomAdapter(Context context, List<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.single_itens, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String titulo = list.get(holder.getAdapterPosition()).getTitulo();
        String criador = String.format("Criador: %s", list.get(position).getNomeCriador());
        String descricao = list.get(position).getDescricao();

        holder.textTitulo.setText(titulo);

        if(descricao == null || descricao.isEmpty()) {
            holder.textDescricao.setVisibility(TextView.GONE);
        }
        holder.textDescricao.setText(truncateString(descricao, 50));
        holder.textCriador.setText(criador);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ConteudoActivity.class);
            intent.putExtra("titulo", titulo);
            intent.putExtra("descricao", descricao);
            intent.putExtra("criador", criador);

            context.startActivity(intent);
        });
    }

    private String truncateString(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength) + "...";
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
