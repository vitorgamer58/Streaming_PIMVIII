package com.pim.streaming;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView textTitulo, textDescricao, textCriador;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitulo = itemView.findViewById(R.id.textTitulo);
        textDescricao = itemView.findViewById(R.id.textDescricao);
        textCriador = itemView.findViewById(R.id.textCriador);
    }
}
