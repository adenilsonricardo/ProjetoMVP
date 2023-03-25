package com.example.projetomvp.presentation.listcharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetomvp.databinding.FragmentListCharactersBinding
import com.example.projetomvp.model.listcharacters.CharactersModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CharactersFragment: Fragment(), CharactersContract.View {
    private var _binding: FragmentListCharactersBinding? = null
    private val binding get() = _binding!!

    private val presenter: CharactersContract.Presenter by inject{
        parametersOf(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadCharacters()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object{
        fun newInstance() = CharactersFragment()
    }

    override fun showCharacters(model: CharactersModel) {
        configRv(model)
    }

    private fun configRv(model: CharactersModel) {
        val adapter = CharactersAdapter(model.results)
        binding.rvListCharacters.adapter = adapter
        binding.rvListCharacters.layoutManager =
            LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
    }

}