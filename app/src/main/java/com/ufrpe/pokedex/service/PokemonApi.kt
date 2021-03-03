package com.ufrpe.pokedex.service
import com.ufrpe.pokedex.model.Details
import com.ufrpe.pokedex.model.PokemonList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonApi {
    private val endpoint: PokemonEndpoint
    init {
        val retrofitClient = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        endpoint = retrofitClient.create(PokemonEndpoint::class.java)
    }

    fun getPokemonList(l : Int) : PokemonList {
        val callback = endpoint.getPokemonList(l, 20)
        return callback.execute().body()!!
    }

    fun getPokemons(name : String) : Details {
        val callback = endpoint.getDetails(name)
        return callback.execute().body()!!
    }
}