package com.example.projetomvp.presentation.activity

interface MainContract {
    interface View {
        fun goToCharactersFragment()
    }

    interface Presenter {
        fun initFlow()
    }
}