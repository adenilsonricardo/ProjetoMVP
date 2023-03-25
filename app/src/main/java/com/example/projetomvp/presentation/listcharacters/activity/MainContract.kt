package com.example.projetomvp.presentation.listcharacters.activity

interface MainContract {
    interface View {
        fun goToCharactersFragment()
    }

    interface Presenter {
        fun initFlow()
    }
}