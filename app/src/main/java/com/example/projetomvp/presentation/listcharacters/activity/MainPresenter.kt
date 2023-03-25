package com.example.projetomvp.presentation.listcharacters.activity

class MainPresenter(
    private var view: MainContract.View?
): MainContract.Presenter {
    override fun initFlow() {
        view?.goToCharactersFragment()
    }
}