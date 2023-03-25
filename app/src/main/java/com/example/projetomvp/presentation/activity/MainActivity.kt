package com.example.projetomvp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomvp.R
import com.example.projetomvp.databinding.ActivityMainBinding
import com.example.projetomvp.presentation.fragment.CharactersFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding : ActivityMainBinding

    private val presenter : MainContract.Presenter by inject{
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.initFlow()
    }

    override fun goToCharactersFragment(){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentListCharacters, CharactersFragment.newInstance())
            addToBackStack(null)
            commit()
        }
    }
}