package com.example.eletriccarapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccarapp.R
import com.example.eletriccarapp.domain.Carro

class CarAdapter(private val carros: List<Carro>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    var carItemLister: (Carro) -> Unit = {}

    // cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carro_item,parent,false)

        return  ViewHolder(view)
    }

    //Pega o conteudo de uma view e troca pela informação de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.preco.text = carros[position].preco
        holder.bateria.text = carros[position].bateria
        holder.potencia.text = carros[position].potencia
        holder.recarga.text = carros[position].recarga
        holder.favorito.setOnClickListener{
            val carro = carros[position]
            carItemLister(carro)

            setFavorite(carro, holder)
        }

    }

    private fun setFavorite(
        carro: Carro,
        holder: ViewHolder
    ) {
        carro.isFavorite = !carro.isFavorite
        if (carro.isFavorite)
            holder.favorito.setImageResource(R.drawable.ic_star_favorite)
        else
            holder.favorito.setImageResource(R.drawable.ic_star)
    }

    // pega a quantidade de itens da lista passada
    override fun getItemCount(): Int {
        return carros.size
    }


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val preco : TextView
        val bateria : TextView
        val potencia : TextView
        val recarga : TextView
        val favorito: ImageView

        init {
            view.apply {
                preco = findViewById(R.id.tv_preco_valor)
                bateria = findViewById(R.id.tv_bateria_valor)
                potencia = findViewById(R.id.tv_potencia_valor)
                recarga = findViewById(R.id.tv_recarga_valor)
                favorito = findViewById(R.id.iv_favorite)
            }

        }


    }
}