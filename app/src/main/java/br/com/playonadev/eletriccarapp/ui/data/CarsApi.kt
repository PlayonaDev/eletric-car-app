package br.com.playonadev.eletriccarapp.ui.data


import br.com.playonadev.eletriccarapp.ui.domain.Carro
import retrofit2.Call
import retrofit2.http.GET

interface CarsApi {
    @GET("cars.json")
    fun getAllCars(): Call<List<Carro>>
}