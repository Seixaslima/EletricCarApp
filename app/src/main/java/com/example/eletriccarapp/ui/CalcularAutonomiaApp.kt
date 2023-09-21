package com.example.eletriccarapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eletriccarapp.R

class CalcularAutonomiaApp : AppCompatActivity() {
    lateinit var precoKWh: EditText
    lateinit var kmPercorrido: EditText
    lateinit var tvResultado: TextView
    lateinit var btnCalcular: Button
    lateinit var btnClose: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)

        getCampos()
        setListener()

    }

    fun getCampos() {
        precoKWh = findViewById(R.id.et_preço_kwh)
        kmPercorrido = findViewById(R.id.et_km_percorrido)
        btnCalcular = findViewById(R.id.btn_calcular)
        tvResultado = findViewById(R.id.tv_resultado)
        btnClose = findViewById((R.id.iv_close))
    }

    fun setListener() {
        btnCalcular.setOnClickListener {
            calcular()
        }
        btnClose.setOnClickListener{
            finish()
        }
    }

    fun calcular() {
        var valorKwh = precoKWh.text.toString().toFloat()
        var valorKmPercorrido = kmPercorrido.text.toString().toFloat()
        var valorResultado =  valorKwh / valorKmPercorrido

        tvResultado.text = valorResultado.toString()
    }


}