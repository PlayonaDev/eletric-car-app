package br.com.playonadev.eletriccarapp.ui.data

import br.com.playonadev.eletriccarapp.ui.domain.Carro

object CarFactory {
    val list = listOf<Carro>(
        Carro(
            id = 1,
            preco = "R$ 300.000,00",
            bateria = "300 kWh",
            potencia = "200cv",
            recarga = "30 min",
            urlPhoto = "www.google.com.br"
        ),
        Carro(
            id = 2,
            preco = "R$ 250.000,00",
            bateria = "250 kWh",
            potencia = "120cv",
            recarga = "45 min",
            urlPhoto = "www.google.com.br"
        ),
        Carro(
            id = 3,
            preco = "R$ 150.000,00",
            bateria = "150 kWh",
            potencia = "85cv",
            recarga = "45 min",
            urlPhoto = "www.google.com.br"
        ),
        Carro(
            id = 4,
            preco = "R$ 50.000,00",
            bateria = "75 kWh",
            potencia = "120cv",
            recarga = "45 min",
            urlPhoto = "www.google.com.br"
        )
    )
}