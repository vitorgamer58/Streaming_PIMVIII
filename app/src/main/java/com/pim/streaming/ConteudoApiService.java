package com.pim.streaming;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConteudoApiService {
    @GET("/Conteudo/todos")
    Call<List<Conteudo>> getPopularMovies();
}
