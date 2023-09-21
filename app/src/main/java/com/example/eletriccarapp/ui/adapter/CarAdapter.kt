package com.example.eletriccarapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccarapp.R
import com.example.eletriccarapp.domain.Carro

class CarAdapter(private val carros: List<Carro>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

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

    }
    // pega a quantidade de itens da lista passada
    override fun getItemCount(): Int {
        return carros.size
    }


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val preco : TextView = view.findViewById(R.id.tv_preco_valor)
        val bateria : TextView = view.findViewById(R.id.tv_bateria_valor)
        val potencia : TextView = view.findViewById(R.id.tv_potencia_valor)
        val recarga : TextView = view.findViewById(R.id.tv_recarga_valor)


    }
}