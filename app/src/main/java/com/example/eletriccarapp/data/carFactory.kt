package com.example.eletriccarapp.data

import com.example.eletriccarapp.domain.Carro

class carFactory {
    val list = listOf<Carro>(
        Carro(1,"R$ 300.000,00","200cv","300 kwh", "25min", "www.google.com.br"),
        Carro(2,"R$ 250.000,00","150cv","200 kwh", "20min", "www.google.com.br")
    )
}