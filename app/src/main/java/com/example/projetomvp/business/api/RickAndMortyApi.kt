package com.example.projetomvp.business.api

import com.example.projetomvp.business.api.PathConstants.CHARACTERS
import com.example.projetomvp.model.CharactersModel
import io.reactivex.Single
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET(CHARACTERS)
    fun loadCharacters(): Single<CharactersModel>
}

object PathConstants{
    const val CHARACTERS = "character"
}