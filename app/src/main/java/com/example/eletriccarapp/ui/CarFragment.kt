package com.example.eletriccarapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccarapp.R
import com.example.eletriccarapp.data.carFactory
import com.example.eletriccarapp.ui.adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CarFragment : Fragment() {
    lateinit var listaCarros: RecyclerView
    lateinit var fabCalcular: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCampos(view)
        setLista()
        setListener()
    }

   fun getCampos(view: View) {
       view?.apply {
           listaCarros = findViewById(R.id.rv_lista_carros)
           fabCalcular = findViewById(R.id.fab_calcular)
       }

   }

   fun setLista () {
       val dados = carFactory().list
       val adapter = CarAdapter(dados)
       listaCarros.adapter = adapter
   }

    fun setListener() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomiaApp::class.java))
        }

    }
}