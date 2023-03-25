package com.example.projetomvp.presentation.listcharacters.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomvp.databinding.CharactersItemBinding
import com.example.projetomvp.model.listcharacters.CharactersModel.ResultApi
import com.squareup.picasso.Picasso

class CharactersAdapter (private var list: List<ResultApi> = listOf()):
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>(){

    class ViewHolder(private val binding: CharactersItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(characters: ResultApi){
            binding.nameCharacter.text= characters.name
            binding.genderCharacter.text = characters.gender
            binding.statusCharacter.text = characters.status
            Picasso
                .get()
                .load(characters.image)
                .into(binding.imageCharacter)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CharactersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}