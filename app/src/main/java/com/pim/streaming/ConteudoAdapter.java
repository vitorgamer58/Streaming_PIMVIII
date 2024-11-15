package com.pim.streaming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConteudoAdapter extends RecyclerView.Adapter<ConteudoAdapter.ConteudoViewHolder> {

    private List<Conteudo> conteudoList;

    public ConteudoAdapter(List<Conteudo> conteudoList) {
        this.conteudoList = conteudoList;
    }

    @NonNull
    @Override
    public ConteudoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conteudo, parent, false);
        return new ConteudoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConteudoViewHolder holder, int position) {
        Conteudo conteudo = conteudoList.get(position);
        holder.tituloTextView.setText(conteudo.getTitulo());
        holder.descricaoTextView.setText(conteudo.getDescricao());
        holder.nomeCriadorTextView.setText(conteudo.getNomeCriador());
    }

    @Override
    public int getItemCount() {
        return conteudoList.size();
    }

    // ViewHolder para otimizar a exibição dos itens
    public static class ConteudoViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTextView, descricaoTextView, nomeCriadorTextView;

        public ConteudoViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            descricaoTextView = itemView.findViewById(R.id.descricaoTextView);
            nomeCriadorTextView = itemView.findViewById(R.id.nomeCriadorTextView);
        }
    }
}
