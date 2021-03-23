package br.com.bernardino.marvelcharacters.data.remote

import br.com.bernardino.marvelcharacters.data.remote.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(): Response<List<CharacterResponse>>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<CharacterResponse>
}