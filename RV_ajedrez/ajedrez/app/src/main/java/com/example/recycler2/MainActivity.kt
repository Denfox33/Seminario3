package com.example.recycler2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    private lateinit var adaptadorficha : AdaptadorFicha
    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        var data = mutableListOf(
            Ficha("Rey",getDrawable(R.drawable.rey)!!),
            Ficha("Reina",getDrawable(R.drawable.reina)!!),
            Ficha("Torre",getDrawable(R.drawable.torre)!!),
            Ficha("Alfil",getDrawable(R.drawable.alfil)!!),
            Ficha("Caballo",getDrawable(R.drawable.caballo)!!),
            Ficha("Peon",getDrawable(R.drawable.peon)!!)
        )

        adaptadorficha = AdaptadorFicha(data)

        bind.recycler.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
            adapter = adaptadorficha
        }

    }
}