package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemUserBinding

class AdapterRecyclerView(private var listaUsuarios: MutableList<Pokemon>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterRecyclerView.ViewHolder, position: Int) {
        val itemUsuarioActual = listaUsuarios[position]

        holder.bind(itemUsuarioActual)

        holder.setListener(itemUsuarioActual)
    }
       override fun getItemCount(): Int = listaUsuarios.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        val binding = ItemUserBinding.bind(view)

        fun setListener(persona: Pokemon){
            binding.root.setOnLongClickListener {
                itemClickListener.onLongItemClick(persona)
                true
            }
        }

        init {
            view.setOnClickListener(this)
        }

        fun bind(poke: Pokemon){
            binding.tvNombre.text = poke.nombre
            binding.tvCorreo.text = poke.correo
            binding.tvNumeroTelefono.text = poke.telefono
            poke.imagen?.let { binding.ivFotoPersona.setImageResource(it) }
        }

        override fun onClick(v: View) {
            val posicion: Int = adapterPosition
            val persona: Pokemon = listaUsuarios[posicion]
            itemClickListener.onItemClick(persona)
        }
    }

    fun eliminarPoke(persona: Pokemon) {
        listaUsuarios.remove(persona)
        notifyDataSetChanged()
    }
}