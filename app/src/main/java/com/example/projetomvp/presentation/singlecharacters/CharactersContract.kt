package com.example.projetomvp.presentation.singlecharacters

import com.example.projetomvp.model.listcharacters.CharactersModel

interface CharactersContract {
    interface View {
        fun showCharacters(model: CharactersModel)
    }

    interface Presenter {
        fun loadCharacters()
    }
}