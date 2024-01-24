package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterRecyclerView: AdapterRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPokemon = mutableListOf(
            Pokemon(
                R.drawable.ampharos,
                nombre = "Ampharos rayos",
                correo = "Ampharos@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.bulbasaurt,
                nombre = "bulbasaurd hojitas",
                correo = "bellotero@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.charmander,
                nombre = "Charmander llama",
                correo = "charmy@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.cubone,
                nombre = "Cubone Huerfanito",
                correo = "huerfanito@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.evee,
                nombre = "evee ",
                correo = "evee@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.gengar,
                nombre = "Gengar Shadow",
                correo = "sombra@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.lapras,
                nombre = "lapras marine",
                correo = "lapos@gmail.com",
                telefono = "666666666",
            ),

            Pokemon(
                R.drawable.quilaba,
                nombre = "Qilaba clipper",
                correo = "mecherito@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.sandex,
                nombre = "sandrew el topillo",
                correo = "topo@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.snorlax,
                nombre = "Snorlax",
                correo = "zzzzz@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.totodile,
                nombre = "Totodile",
                correo = "cococdrilosacamuelas@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.umbreom,
                nombre = "Umbreon",
                correo = "umbreo@gmail.com",
                telefono = "666666666",
            ),
            Pokemon(
                R.drawable.piplud,
                nombre = "Piplud",
                correo = "pingu@gmail.com",
                telefono = "666666666",
            ),
        )

        //adapterRecyclerView = AdapterRecyclerView(listaPersonas): Se crea una instancia del adaptador
        //personalizado AdapterRecyclerView, que se espera que tenga una lista de objetos
        //Persona (listaPersonas) como su conjunto de datos.
        adapterRecyclerView = AdapterRecyclerView(listaPokemon, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRecyclerView
        }
    }

    override fun onItemClick(pokemon: Pokemon) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("pokemon", pokemon)
        startActivity(intent)
    }

    override fun onLongItemClick(pokemon: Pokemon) {
        eliminarPersonaAutomaticamente(pokemon)
    }

    private fun eliminarPersonaAutomaticamente(pokemon: Pokemon) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar contacto")
        builder.setMessage("¿Estás seguro de que deseas eliminar este contacto?")
        builder.setPositiveButton("Sí") { _, _ ->
            // Elimina la persona de la lista
            adapterRecyclerView.eliminarPoke(pokemon)
            // Notifica al adaptador que se ha eliminado un elemento
            adapterRecyclerView.notifyDataSetChanged()
        }
        builder.setNegativeButton("No") { _, _ ->
            // No hacer nada si el usuario elige no eliminar
        }
        val dialog = builder.create()
        dialog.show()
    }


}