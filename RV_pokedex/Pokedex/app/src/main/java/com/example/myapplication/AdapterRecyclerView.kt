package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPokemonBinding


class AdapterRecyclerView(private var listaPokemons: MutableList<Pokemon>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterRecyclerView.ViewHolder, position: Int) {
        val itemPokemonActual = listaPokemons[position]

        holder.bind(itemPokemonActual)

    }
    override fun getItemCount(): Int = listaPokemons.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        val binding = ItemPokemonBinding.bind(view)

        init {
            view.setOnClickListener(this)
        }

        fun bind(pokemon: Pokemon){
            binding.tvNombrePokemon.text = pokemon.nombrePokemon
            binding.cbCapturado.isChecked = pokemon.capturado
        }

        override fun onClick(v: View) {
            val posicion: Int = adapterPosition
            val pokemon: Pokemon = listaPokemons[posicion]
            itemClickListener.onItemClick(pokemon)
        }
    }
}