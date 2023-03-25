package com.example.projetomvp.presentation.listcharacters.fragment

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.projetomvp.business.repository.RickAndMortyRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharactersPresenter(
    private var view: CharactersContract.View?,
    private val repository: RickAndMortyRepository
): CharactersContract.Presenter {
    private val error: MutableLiveData<String> = MutableLiveData()
    private val disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun loadCharacters() {
        disposable.add(
            repository.loadCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        view?.showCharacters(it)},
                    {e -> error.value = e.message}))
    }
}