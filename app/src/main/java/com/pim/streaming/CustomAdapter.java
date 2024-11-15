package com.pim.streaming;

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
        holder.textTitulo.setText(list.get(position).getTitulo());
        String descricao = list.get(position).getDescricao();

        if(descricao == null || descricao.isEmpty()) {
            holder.textDescricao.setVisibility(TextView.GONE);
        }
        holder.textDescricao.setText(list.get(position).getDescricao());
        holder.textCriador.setText(String.format("Criador: %s", list.get(position).getNomeCriador()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
