package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapterRecyclerViewCapturados: AdapterRecyclerView
    private lateinit var adapterRecyclerViewNoCapturados: AdapterRecyclerView
    private lateinit var listaPokemonCapturados: MutableList<Pokemon>
    private lateinit var listaPokemonNoCapturados: MutableList<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPokemon = mutableListOf(
            Pokemon("Blastoise", true),
            Pokemon("Alakazam", false),
            Pokemon("Gyarados", true),
            Pokemon("Snorlax", false),
            Pokemon("Vaporeon", true),
            Pokemon("Jolteon", false),
            Pokemon("Flareon", false),
            Pokemon("Dragonite", true),
            Pokemon("Machamp", false),
            Pokemon("Gengar", true),
            Pokemon("Venusaur", false),
            Pokemon("Pidgeot", false),
            Pokemon("Rhydon", true),
            Pokemon("Lapras", true),
            Pokemon("Arcanine", false),
            Pokemon("Exeggutor", true)
        )

        listaPokemonCapturados = mutableListOf<Pokemon>()
        listaPokemonNoCapturados = mutableListOf<Pokemon>()
        listaPokemon.forEach { pokemon ->
            if(pokemon.capturado){
                listaPokemonCapturados.add(pokemon)
            }else{
                listaPokemonNoCapturados.add(pokemon)
            }
        }

        adapterRecyclerViewCapturados = AdapterRecyclerView(listaPokemonCapturados, this)
        adapterRecyclerViewNoCapturados = AdapterRecyclerView(listaPokemonNoCapturados, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rvCapturados.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRecyclerViewCapturados
        }

        binding.rvNoCapturados.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRecyclerViewNoCapturados
        }

        binding.ivAgregar.setOnClickListener {
            val nombrePokemon = binding.etNombrePokemonAgregar.text.toString().trim().capitalize()
            if(nombrePokemon == ""){
                Toast.makeText(this, "Introduce nombre del pokemon", Toast.LENGTH_LONG).show()
            }else{
                val estaCapturado = false
                val pokemon = Pokemon(nombrePokemon, estaCapturado)
                listaPokemonNoCapturados.add(pokemon)
                adapterRecyclerViewNoCapturados.notifyDataSetChanged()
                binding.etNombrePokemonAgregar.setText("")
            }
        }
    }

    override fun onItemClick(pokemon: Pokemon) {

        val estaCapturado = pokemon.capturado

        if (estaCapturado) {
            pokemon.capturado = false
            listaPokemonCapturados.remove(pokemon)
            listaPokemonNoCapturados.add(pokemon)
            adapterRecyclerViewCapturados.notifyDataSetChanged()
            adapterRecyclerViewNoCapturados.notifyDataSetChanged()
        } else {
            pokemon.capturado = true
            listaPokemonCapturados.add(pokemon)
            listaPokemonNoCapturados.remove(pokemon)
            adapterRecyclerViewNoCapturados.notifyDataSetChanged()
            adapterRecyclerViewCapturados.notifyDataSetChanged()
        }
    }


}