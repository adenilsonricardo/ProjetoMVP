package com.example.projetomvp.business.repository

import com.example.projetomvp.model.CharactersModel
import io.reactivex.Single

interface RickAndMortyRepository {
    fun loadCharacters(): Single<CharactersModel>
}