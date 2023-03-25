package com.example.projetomvp.di

import com.example.projetomvp.business.repository.RickAndMortyRepository
import com.example.projetomvp.business.repository.RickAndMortyRepositoryImpl
import com.example.projetomvp.presentation.activity.MainContract
import com.example.projetomvp.presentation.activity.MainPresenter
import com.example.projetomvp.presentation.fragment.CharactersContract
import com.example.projetomvp.presentation.fragment.CharactersPresenter
import org.koin.dsl.module

class CharactersModule: FeatureModule() {

    override val instance = module {
        factory { RetrofitService.service }
        single<RickAndMortyRepository>{RickAndMortyRepositoryImpl(api = get())}
        factory<CharactersContract.Presenter> {
            CharactersPresenter(
            view = get(),
            repository = get())
        }

        factory<MainContract.Presenter> {
            MainPresenter(
                view = get()
            )
        }
    }
}