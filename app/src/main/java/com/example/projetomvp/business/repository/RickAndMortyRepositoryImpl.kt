package com.example.projetomvp.business.repository

import com.example.projetomvp.business.api.RickAndMortyApi
import com.example.projetomvp.model.CharactersModel
import io.reactivex.Single

class RickAndMortyRepositoryImpl(
    private val api: RickAndMortyApi
) : RickAndMortyRepository {
    override fun loadCharacters(): Single<CharactersModel> {
        return api.loadCharacters()
    }
}