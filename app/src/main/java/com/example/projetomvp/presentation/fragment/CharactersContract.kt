package com.example.projetomvp.presentation.fragment

import com.example.projetomvp.model.CharactersModel

interface CharactersContract {
    interface View {
        fun showCharacters(model: CharactersModel)
    }

    interface Presenter {
        fun loadCharacters()
    }
}