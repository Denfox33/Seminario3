package com.example.recycler2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler2.databinding.ItemFichaBinding

class AdaptadorFicha (var listaPiezas : MutableList<Ficha>): RecyclerView.Adapter<AdaptadorFicha.ViewHolder>(){

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemFichaBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ficha, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaPiezas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var pieza = listaPiezas.get(position)

        holder.binding.nombre.text = pieza.nombre
        holder.binding.ficha.setImageDrawable(pieza.foto)
    }
}