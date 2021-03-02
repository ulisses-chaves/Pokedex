package com.ufrpe.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonList (
    @SerializedName("count") val count: String,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<Results>
)