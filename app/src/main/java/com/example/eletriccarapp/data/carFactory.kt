package com.example.eletriccarapp.data

import com.example.eletriccarapp.domain.Carro

class carFactory {
    val list = listOf<Carro>(
        Carro(1, "R$ 300.000,00","250kw", "200cv", "25min", "www.google.com.br"),
        Carro(2, "R$ 250.000,00","200kw", "150cv", "20min", "www.google.com.br")
    )
}