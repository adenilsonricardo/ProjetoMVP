package com.example.projetomvp.presentation.activity

class MainPresenter(
    private var view: MainContract.View?
): MainContract.Presenter {
    override fun initFlow() {
        view?.goToCharactersFragment()
    }
}